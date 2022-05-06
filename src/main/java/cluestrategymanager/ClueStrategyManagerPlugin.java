package cluestrategymanager;

import cluestrategymanager.data.*;
import cluestrategymanager.transportation.Spellbook;
import cluestrategymanager.ui.ClueStrategyManagerPluginPanel;
import cluestrategymanager.ui.Tab;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Provides;
import javax.inject.Inject;
import javax.swing.ImageIcon;

import joptsimple.internal.Strings;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;

import java.awt.image.BufferedImage;
import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@PluginDescriptor(
	name = "Clue Strategy Manager"
)
public class ClueStrategyManagerPlugin extends Plugin
{
	public static final String CONFIG_GROUP = "cluestrategymanager";

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private ItemManager itemManager;

	@Inject
	SpriteManager spriteManager;

	@Inject
	private Gson gson;

	@Inject
	private ClueStrategyManagerConfig config;

	private ClueStrategyManagerPluginPanel pluginPanel;
	private NavigationButton navigationButton;

	private Map<ClueTier, List<ClueStrategy>> clueStrategies;

	@Override
	protected void startUp()
	{
		log.info("Clue Strategy Manager started!");
		// TODO init clue strats
		clueStrategies = new HashMap<>();
		readConfig();
		// try and read in config clue strats and
		//BufferedImage test = spriteManager.getSprite(1584, 0);
		clientThread.invoke(() ->
		{
			BufferedImage test = spriteManager.getSprite(Spellbook.LUNAR.getSpriteID(), 0);
			ImageIcon testIcon = new ImageIcon(test);
		});

		pluginPanel = new ClueStrategyManagerPluginPanel(this, itemManager, config, spriteManager);
		pluginPanel.rebuild();

		BufferedImage icon = ImageUtil.loadImageResource(ClueStrategyManagerPlugin.class, "/panel_icon.png");

		navigationButton = NavigationButton.builder()
				.tooltip("Clue Strategy Manager")
				.icon(icon)
				.priority(5)
				.panel(pluginPanel)
				.build();

		clientToolbar.addNavigation(navigationButton);
	}

	@Override
	protected void shutDown()
	{
		clientToolbar.removeNavigation(navigationButton);
		saveConfig();
		log.info("Clue Strategy Manager stopped!");
	}

	private void readConfig()
	{
		for (ClueTier clueTier : ClueTier.values())
		{
			clueStrategies.put(clueTier, new ArrayList<>());
		}

		final String storedStrategies = config.strategies();

		if (Strings.isNullOrEmpty(storedStrategies))
		{
			log.debug("empty strats initing");
			initClueStrategies();
		}
		else
		{
			log.debug("strats found loading");
			// TODO ignore try catch for now
			// try
			Type type = new TypeToken<ArrayList<ClueStrategy>>() {}.getType();

			List<ClueStrategy> clueStrategiesList = gson.fromJson(storedStrategies, type);
			List<Step> missingSteps = new ArrayList<>(Arrays.asList(Step.values()));
			for (ClueStrategy clueStrategy : clueStrategiesList)
			{
				clueStrategies.get(clueStrategy.getStep().getTier()).add(clueStrategy);
				log.debug("{}", clueStrategy.getStep());
				missingSteps.remove(clueStrategy.getStep());
			}
			log.debug("loadeded {}", clueStrategies);
			for (Step clue : missingSteps)
			{
				log.debug("missing clue adding new blank strat for {}", clue);
				clueStrategies.get(clue.getTier()).add(new ClueStrategy(clue));
			}
		}
	}

	private void saveConfig()
	{
		List<ClueStrategy> clueStrategiesList = new ArrayList<>();

		for (ClueTier clueTier : clueStrategies.keySet())
		{
			clueStrategiesList.addAll(clueStrategies.get(clueTier));
		}

		final String clueStrategiesJson = gson.toJson(clueStrategiesList);
		config.saveStrategies(clueStrategiesJson);
		log.debug("saved: {}", clueStrategiesJson);
	}

	private void initClueStrategies()
	{
		for (ClueTier clueTier : Step.CLUE_TIERS)
		{
			for (Step step : Step.CLUE_MAP.get(clueTier))
			{
				clueStrategies.get(clueTier).add(new ClueStrategy(step));
			}

		}

		log.debug("inited {}", clueStrategies);
		//TODO compare to all clues defined
		// for any missing clue strats, create either a default/suggested clue strat or an empty one (empty prolly ezier for now)
	}

	// TODO need to parse clue text from widget
	@Subscribe
	public void onWidgetLoaded(final WidgetLoaded event)
	{

	}

	// TODO remove when clue not in inv
	public void onItemContainerChange(ItemContainerChanged event)
	{

	}

	@Provides
	ClueStrategyManagerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ClueStrategyManagerConfig.class);
	}

	// TODO this should return clue strats not clues
	public List<ClueStrategy> getClues(Tab tab)
	{
		return clueStrategies.get(tab.getClueTier());
	}

	public void rebuildSidePanel()
	{
		pluginPanel.rebuild();
	}
}

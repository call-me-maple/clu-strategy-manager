package cluestrategymanager;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import cluestrategymanager.ui.Tab;

@ConfigGroup(ClueStrategyManagerPlugin.CONFIG_GROUP)
public interface ClueStrategyManagerConfig extends Config
{
	@ConfigItem(
			keyName = "activeTab",
			name = "Active Tab",
			description = "The currently selected tab",
			hidden = true
	)
	default Tab activeTab()
	{
		return Tab.BEGINNER;
	}

	@ConfigItem(
			keyName = "activeTab",
			name = "",
			description = "",
			hidden = true
	)
	void setActiveTab(Tab t);

	@ConfigItem(
			keyName = "cluestrategies",
			name = "Clue Strategies",
			description = "Json list of Clue Strategies",
			hidden = true
	)
	default String strategies()
	{
		return "";
	}

	@ConfigItem(
			keyName = "cluestrategies",
			name = "",
			description = "",
			hidden = true
	)
	void saveStrategies(String s);
}

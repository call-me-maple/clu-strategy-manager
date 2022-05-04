package cluestrategymanager.ui;

import cluestrategymanager.ClueStrategyManagerConfig;
import cluestrategymanager.ClueStrategyManagerPlugin;
import cluestrategymanager.ClueTier;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.materialtabs.MaterialTab;
import net.runelite.client.ui.components.materialtabs.MaterialTabGroup;
import net.runelite.client.util.AsyncBufferedImage;

import javax.annotation.Nullable;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ClueStrategyManagerPluginPanel extends PluginPanel
{

    private final ClueStrategyManagerPlugin plugin;
    private final ItemManager itemManager;
    private final ClueStrategyManagerConfig config;
    private boolean active;

    private final JPanel clueSelectorPanel = new JPanel();
    private final Map<Tab, MaterialTab> uiTabs = new HashMap<>();
    private final MaterialTabGroup clueSelectorGroup = new MaterialTabGroup(clueSelectorPanel);

    @Nullable
    private ClueTierPanel activeTabPanel = null;

    public ClueStrategyManagerPluginPanel(ClueStrategyManagerPlugin plugin, ItemManager itemManager, ClueStrategyManagerConfig config)
    {
        this.plugin = plugin;
        this.itemManager = itemManager;
        this.config = config;

        setLayout(new BorderLayout());

        for (ClueTier clueTier : ClueTier.CLUE_TIERS)
        {
            addTab(clueTier.getTab(), new ClueTierPanel(plugin, this, plugin.getClues(clueTier)));
        }

        add(clueSelectorGroup, BorderLayout.NORTH);
        add(clueSelectorPanel, BorderLayout.CENTER);
    }

    private void addTab(Tab tab, ClueTierPanel clueTierPanel)
    {
        JPanel wrapped = new JPanel(new BorderLayout());
        wrapped.add(clueTierPanel, BorderLayout.NORTH);
        wrapped.setBackground(ColorScheme.DARK_GRAY_COLOR);

        JScrollPane scroller = new JScrollPane(wrapped);
        scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroller.getVerticalScrollBar().setPreferredSize(new Dimension(16, 0));
        scroller.getVerticalScrollBar().setBorder(new EmptyBorder(0, 9, 0, 0));
        scroller.setBackground(ColorScheme.DARK_GRAY_COLOR);

        // Use a placeholder icon until the async image gets loaded
        MaterialTab materialTab = new MaterialTab(new ImageIcon(), clueSelectorGroup, scroller);
        materialTab.setPreferredSize(new Dimension(30, 27));
        materialTab.setName(tab.getName());
        materialTab.setToolTipText(tab.getName());

        AsyncBufferedImage icon = itemManager.getImage(tab.getItemID());
        Runnable resize = () ->
        {
            BufferedImage subIcon = icon.getSubimage(0, 0, 32, 32);
            materialTab.setIcon(new ImageIcon(subIcon.getScaledInstance(24, 24, Image.SCALE_SMOOTH)));
        };
        icon.onLoaded(resize);
        resize.run();

        materialTab.setOnSelectEvent(() ->
        {
            config.setActiveTab(tab);
            activeTabPanel = clueTierPanel;

            clueTierPanel.update();
            log.debug("selected {}", tab.getName());
            return true;
        });

        uiTabs.put(tab, materialTab);
        clueSelectorGroup.addTab(materialTab);

        if (config.activeTab() == tab)
        {
            clueSelectorGroup.select(materialTab);
            log.debug("selected group {}", tab.getName());
        }
    }

    void switchTab(Tab tab)
    {
        clueSelectorGroup.select(uiTabs.get(tab));
    }
    void update()
    {
        if (!active || activeTabPanel == null)
        {
            return;
        }

        SwingUtilities.invokeLater(activeTabPanel::update);
    }

    @Override
    public void onActivate()
    {
        active = true;
        update();
    }

    @Override
    public void onDeactivate()
    {
        active = false;
    }

    public void rebuild()
    {
        repaint();
        revalidate();
    }
}
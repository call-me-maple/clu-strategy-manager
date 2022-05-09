package cluestrategymanager.ui;


import cluestrategymanager.ClueStrategy;
import cluestrategymanager.ClueStrategyManagerPlugin;
import cluestrategymanager.transportation.Transportation;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Constants;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.overlay.components.ComponentConstants;

import javax.swing.*;
import java.awt.*;
import java.util.List;

@Slf4j
public class ClueTierPanel extends JPanel
{
    private ClueStrategyManagerPlugin plugin;
    private ClueStrategyManagerPluginPanel panel;
    private List<ClueStrategy> clueStrategies;
    private SpriteManager spriteManager;
    private ItemManager itemManager;

    public ClueTierPanel(ClueStrategyManagerPlugin plugin, ItemManager itemManager, SpriteManager spriteManager, ClueStrategyManagerPluginPanel panel, List<ClueStrategy> clueStrategies)
    {
        this.plugin = plugin;
        this.panel = panel;
        this.clueStrategies = clueStrategies;
        this.spriteManager = spriteManager;
        this.itemManager = itemManager;
        setPreferredSize(new Dimension(PluginPanel.PANEL_WIDTH, Constants.GAME_FIXED_HEIGHT));
    }
    // TODO The number of clues in a tier determines when we scroll atm lol
    public void editClueStrategy(ClueStrategy clueStrategy)
    {
        removeAll();
        setLayout(new BorderLayout());

        // TODO testing auto populate
        clueStrategy.setTransportation(Transportation.NARDAH_TELEPORT);
        add(new ClueStrategyEditPanel(plugin, itemManager, spriteManager,this, clueStrategy), BorderLayout.CENTER);

        repaint();
        revalidate();
    }

    public void build()
    {
        removeAll();
        setLayout(new GridBagLayout());

        log.debug("building wowowowow");
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.weightx = 1;
        //constraints.weighty = 1;
        constraints.gridx = 0;
        constraints.gridy = 0;

        add(Box.createRigidArea(new Dimension(0, 10)), constraints);
        constraints.gridy++;

        for (ClueStrategy clueStrategy : clueStrategies)
        {
            add(new ClueStrategyPanel(plugin, this, clueStrategy), constraints);
            constraints.gridy++;

            add(Box.createRigidArea(new Dimension(0, 10)), constraints);
            constraints.gridy++;

            log.debug("added label {}", clueStrategy.getStep().getText());
        }
        repaint();
        revalidate();
    }
}
package cluestrategymanager.ui;


import cluestrategymanager.ClueStrategy;
import cluestrategymanager.ClueStrategyManagerPlugin;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.util.List;

@Slf4j
public class ClueTierPanel extends JPanel
{
    private ClueStrategyManagerPlugin plugin;
    private ClueStrategyManagerPluginPanel panel;
    private List<ClueStrategy> clueStrategies;

    public ClueTierPanel(ClueStrategyManagerPlugin plugin, ClueStrategyManagerPluginPanel panel, List<ClueStrategy> clueStrategies)
    {
        this.plugin = plugin;
        this.panel = panel;
        this.clueStrategies = clueStrategies;

        setLayout(new GridBagLayout());
        build();
    }

    public void update()
    {
    }

    public void editClueStrategy(ClueStrategy clueStrategy)
    {
        removeAll();
    }

    public void build()
    {
        removeAll();

        log.debug("building wowowowow");
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1;
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
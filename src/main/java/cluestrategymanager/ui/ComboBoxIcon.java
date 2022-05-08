package cluestrategymanager.ui;

import net.runelite.client.ui.PluginPanel;

import javax.swing.Icon;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Dimension;

public class ComboBoxIcon extends JComboBox<ComboBoxIconEntry>
{

    private final ComboBoxIconListRenderer renderer;

    ComboBoxIcon(String defaultText)
    {
        //setFocusable(false); // To prevent an annoying "focus paint" effect
        setForeground(Color.WHITE);
        setPreferredSize(new Dimension(PluginPanel.PANEL_WIDTH - 25, 30));
        setMaximumRowCount(15);
        renderer = new ComboBoxIconListRenderer(defaultText);
        setRenderer(renderer);
    }


    public void setIcon(Icon icon)
    {
        //renderer
    }
}

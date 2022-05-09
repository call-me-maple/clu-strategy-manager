package cluestrategymanager.ui;

import net.runelite.client.ui.PluginPanel;

import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.*;

public class ComboBoxIcon extends JComboBox<ComboBoxIconEntry>
{

    ComboBoxIcon(String defaultText)
    {
        //setFocusable(false); // To prevent an annoying "focus paint" effect
        setForeground(Color.WHITE);
        setPreferredSize(new Dimension(PluginPanel.PANEL_WIDTH - 25, 30));
        setMaximumRowCount(15);
        ComboBoxIconListRenderer renderer = new ComboBoxIconListRenderer(defaultText);
        setRenderer(renderer);
    }
    public void setIcon(Icon icon)
    {
        //renderer
    }
}

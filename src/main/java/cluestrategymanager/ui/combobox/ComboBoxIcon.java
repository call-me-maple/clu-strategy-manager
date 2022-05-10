package cluestrategymanager.ui.combobox;

import net.runelite.client.ui.PluginPanel;

import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Dimension;

public class ComboBoxIcon extends JComboBox<ComboBoxIconEntry>
{
    private boolean sorted;

    public ComboBoxIcon(String defaultText)
    {
        this(defaultText, false, false);
    }

    public ComboBoxIcon(String defaultText, boolean editable, boolean sorted)
    {
        this.sorted = sorted;

        //setFocusable(false); // To prevent an annoying "focus paint" effect
        setForeground(Color.WHITE);
        setPreferredSize(new Dimension(PluginPanel.PANEL_WIDTH - 25, 30));
        setMaximumRowCount(15);
        ComboBoxIconListRenderer renderer = new ComboBoxIconListRenderer(defaultText);
        setRenderer(renderer);

        if (editable)
        {
            AutoCompletion.enable(this);
        }
    }

    @Override
    public void addItem(ComboBoxIconEntry item)
    {
        insertItemAt(item, getItemCount() > 0 ? getItemCount() - 1 : 0);
    }

    @Override
    public void insertItemAt(ComboBoxIconEntry item, int index)
    {
        if (!sorted)
        {
            super.insertItemAt(item, index);
            return;
        }

        int size = getItemCount();
        for (index = 0; index < size; index++)
        {
            ComboBoxIconEntry other = getItemAt(index);
            if (other.compareTo(item) > 0)
            {
                break;
            }
        }
        super.insertItemAt(item, index);
    }
}

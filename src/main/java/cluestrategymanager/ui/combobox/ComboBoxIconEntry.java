package cluestrategymanager.ui.combobox;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.client.util.AsyncBufferedImage;

import javax.annotation.Nullable;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Image;

@Getter
@AllArgsConstructor
public class ComboBoxIconEntry implements Comparable<ComboBoxIconEntry>
{
    private final Icon icon;
    private final String text;
    @Nullable
    private final Object data;

    @Override
    public String toString()
    {
        return text;
    }

    @Override
    public int compareTo(ComboBoxIconEntry other)
    {
        return this.text.compareTo(other.text);
    }
}

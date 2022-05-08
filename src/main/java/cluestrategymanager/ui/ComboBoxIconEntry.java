package cluestrategymanager.ui;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.annotation.Nullable;
import javax.swing.Icon;

@AllArgsConstructor
@Getter
public class ComboBoxIconEntry
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
}

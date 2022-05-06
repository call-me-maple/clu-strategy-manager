package cluestrategymanager.transportation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.SpriteID;

@AllArgsConstructor
@Getter
public enum Spellbook
{
    LUNAR("Lunar Spellbook", SpriteID.TAB_MAGIC_SPELLBOOK_LUNAR),
    ANCIENT("Ancient Magicks", SpriteID.TAB_MAGIC_SPELLBOOK_ANCIENT_MAGICKS),
    STANDARD("Standard Spellbook", SpriteID.TAB_MAGIC),
    ARCEUUS("Arceuus Spellbook", SpriteID.TAB_MAGIC_SPELLBOOK_ARCEUUS);

    private final String name;
    private final int spriteID;


}

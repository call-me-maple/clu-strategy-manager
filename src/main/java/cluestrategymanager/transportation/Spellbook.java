package cluestrategymanager.transportation;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Spellbook
{
    LUNAR("Lunar Spellbook", LunarSpellbook.TELEPORTS),
    ANCIENT("Ancient Magicks", AncientMagicks.TELEPORTS),
    STANDARD("Standard Spellbook", StandardTeleports.TELEPORTS),
    ARCEUUS("Arceuus Spellbook", ArceuusSpellbook.TELEPORTS);

    private final String name;
    private final SpellbookTeleport[] teleports;


}

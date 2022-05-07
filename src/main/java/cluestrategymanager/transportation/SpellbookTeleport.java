package cluestrategymanager.transportation;

import com.google.common.collect.ImmutableMultimap;
import lombok.Getter;
import lombok.AllArgsConstructor;
import net.runelite.api.SpriteID;

@AllArgsConstructor
public enum SpellbookTeleport
{
    // Standard Spellbook
    STANDARD_HOME("Lumbridge Home Teleport", Spellbook.STANDARD, SpriteID.SPELL_LUMBRIDGE_HOME_TELEPORT),
    STANDARD_VARROCK("Varrock Teleport", Spellbook.STANDARD, SpriteID.SPELL_VARROCK_TELEPORT),
    STANDARD_LUMBRIDGE("Lumbridge Teleport", Spellbook.STANDARD, SpriteID.SPELL_LUMBRIDGE_TELEPORT),
    STANDARD_FALADOR("Falador Teleport", Spellbook.STANDARD, SpriteID.SPELL_FALADOR_TELEPORT),
    STANDARD_HOUSE("Teleport to House", Spellbook.STANDARD, SpriteID.SPELL_TELEPORT_TO_HOUSE),
    STANDARD_CAMELOT("Camelot Teleport", Spellbook.STANDARD, SpriteID.SPELL_CAMELOT_TELEPORT),
    STANDARD_ARDOUGNE("Ardougne Teleport", Spellbook.STANDARD, SpriteID.SPELL_ARDOUGNE_TELEPORT),
    STANDARD_WATCHTOWER("Watchtower Teleport", Spellbook.STANDARD, SpriteID.SPELL_WATCHTOWER_TELEPORT),
    STANDARD_TROLLHEIM("Trollheim Teleport", Spellbook.STANDARD, SpriteID.SPELL_TROLLHEIM_TELEPORT),
    STANDARD_APE_ATOLL("Ape Atoll Teleport", Spellbook.STANDARD, SpriteID.SPELL_TELEPORT_TO_APE_ATOLL),
    STANDARD_KOUREND_CASTLE("Kourend Castle Teleport", Spellbook.STANDARD, SpriteID.SPELL_TELEPORT_TO_KOUREND),
    
    // Ancient Magicks
    ANCIENT_HOME("Edgeville Home Teleport", Spellbook.ANCIENT, SpriteID.SPELL_LUMBRIDGE_HOME_TELEPORT),
    ANCIENT_PADDEWWA("Paddewwa Teleport", Spellbook.ANCIENT, SpriteID.SPELL_PADDEWWA_TELEPORT),
    ANCIENT_SENNTISTEN("Senntisten Teleport", Spellbook.ANCIENT, SpriteID.SPELL_SENNTISTEN_TELEPORT),
    ANCIENT_KHARYRLL("Kharyrll Teleport", Spellbook.ANCIENT, SpriteID.SPELL_KHARYRLL_TELEPORT),
    ANCIENT_LASSAR("Lassar Teleport", Spellbook.ANCIENT, SpriteID.SPELL_LASSAR_TELEPORT),
    ANCIENT_DAREEYAK("Dareeyak Teleport", Spellbook.ANCIENT, SpriteID.SPELL_DAREEYAK_TELEPORT),
    ANCIENT_CARRALLANGAR("Carrallangar Teleport", Spellbook.ANCIENT, SpriteID.SPELL_CARRALLANGAR_TELEPORT),
    ANCIENT_ANNAKARL("Annakarl Teleport", Spellbook.ANCIENT, SpriteID.SPELL_ANNAKARL_TELEPORT),
    ANCIENT_GHORROCK("Ghorrock Teleport", Spellbook.ANCIENT, SpriteID.SPELL_GHORROCK_TELEPORT),
    
    // Lunar Spellbook
    LUNAR_HOME("Lunar Home Teleport", Spellbook.LUNAR, SpriteID.SPELL_LUMBRIDGE_HOME_TELEPORT),
    LUNAR_MOONCLAN("Moonclan Teleport", Spellbook.LUNAR, SpriteID.SPELL_MOONCLAN_TELEPORT),
    LUNAR_OURANIA("Ourania Teleport", Spellbook.LUNAR, SpriteID.SPELL_OURANIA_TELEPORT),
    LUNAR_WATERBIRTH("Waterbirth Teleport", Spellbook.LUNAR, SpriteID.SPELL_WATERBIRTH_TELEPORT),
    LUNAR_BARBARIAN("Barbarian Teleport", Spellbook.LUNAR, SpriteID.SPELL_BARBARIAN_TELEPORT),
    LUNAR_KHAZARD("Khazard Teleport", Spellbook.LUNAR, SpriteID.SPELL_KHAZARD_TELEPORT),
    LUNAR_FISHING_GUILD("Fishing Guild Teleport", Spellbook.LUNAR, SpriteID.SPELL_FISHING_GUILD_TELEPORT),
    LUNAR_CATHERBY("Catherby Teleport", Spellbook.LUNAR, SpriteID.SPELL_CATHERBY_TELEPORT),
    LUNAR_ICE_PLATEAU("Ice Plateau Teleport", Spellbook.LUNAR, SpriteID.SPELL_ICE_PLATEAU_TELEPORT),
    
    // Arceuus Spellbook
    ARCEUUS_HOME("Arceuus Home Teleport", Spellbook.ARCEUUS, 1251),
    ARCEUUS_LIBRARY("Arceuus Library Teleport", Spellbook.ARCEUUS, SpriteID.SPELL_ARCEUUS_LIBRARY_TELEPORT),
    ARCEUUS_DRAYNOR_MANOR("Draynor Manor Teleport", Spellbook.ARCEUUS, SpriteID.SPELL_DRAYNOR_MANOR_TELEPORT),
    ARCEUUS_BATTLEFRONT("Battlefront Teleport", Spellbook.ARCEUUS, SpriteID.SPELL_DRAYNOR_MANOR_TELEPORT),
    ARCEUUS_MIND_ALTER("Mind Altar Teleport", Spellbook.ARCEUUS, SpriteID.SPELL_MIND_ALTAR_TELEPORT),
    ARCEUUS_RESPAWN("Respawn Teleport", Spellbook.ARCEUUS, SpriteID.SPELL_RESPAWN_TELEPORT),
    ARCEUUS_SALVE_GRAVEYARD("Salve Graveyard Teleport", Spellbook.ARCEUUS, SpriteID.SPELL_SALVE_GRAVEYARD_TELEPORT),
    ARCEUUS_FENKENSTRAINS_CASTLE("Fenkenstrain's Castle Teleport", Spellbook.ARCEUUS, SpriteID.SPELL_FENKENSTRAINS_CASTLE_TELEPORT),
    ARCEUUS_WEST_ARDOUGNE("West Ardougne Teleport", Spellbook.ARCEUUS, SpriteID.SPELL_WEST_ARDOUGNE_TELEPORT),
    ARCEUUS_HARMONY_ISLAND("Harmony Island Teleport", Spellbook.ARCEUUS, SpriteID.SPELL_HARMONY_ISLAND_TELEPORT),
    ARCEUUS_CEMETERY("Cemetery Teleport", Spellbook.ARCEUUS, SpriteID.SPELL_CEMETERY_TELEPORT),
    ARCEUUS_BARROWS("Barrows Teleport", Spellbook.ARCEUUS, SpriteID.SPELL_BARROWS_TELEPORT),
    ARCEUUS_APE_ATOLL("Ape Atoll Teleport", Spellbook.ARCEUUS, SpriteID.SPELL_APE_ATOLL_TELEPORT);

    @Getter
    private String name;
    
    @Getter
    private Spellbook spellbook;
    
    @Getter
    private int spriteID;

    public static final ImmutableMultimap<Spellbook, SpellbookTeleport> TELEPORT_MAP;
    static
    {
        final ImmutableMultimap.Builder<Spellbook, SpellbookTeleport> map = ImmutableMultimap.builder();
        for (final SpellbookTeleport teleport : values())
        {
            map.put(teleport.getSpellbook(), teleport);
        }
        TELEPORT_MAP = map.build();
    }
}

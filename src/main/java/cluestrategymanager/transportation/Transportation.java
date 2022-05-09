package cluestrategymanager.transportation;

import com.google.common.collect.ImmutableMultimap;
import lombok.Getter;
import net.runelite.api.ItemID;
import net.runelite.api.SpriteID;

@Getter
public enum Transportation
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
    ARCEUUS_RESPAWN("Respawn Teleport", Spellbook.ARCEUUS, SpriteID.SPELL_RESPAWN_TELEPORT), // Should this list respawns locations?
    ARCEUUS_SALVE_GRAVEYARD("Salve Graveyard Teleport", Spellbook.ARCEUUS, SpriteID.SPELL_SALVE_GRAVEYARD_TELEPORT),
    ARCEUUS_FENKENSTRAINS_CASTLE("Fenkenstrain's Castle Teleport", Spellbook.ARCEUUS, SpriteID.SPELL_FENKENSTRAINS_CASTLE_TELEPORT),
    ARCEUUS_WEST_ARDOUGNE("West Ardougne Teleport", Spellbook.ARCEUUS, SpriteID.SPELL_WEST_ARDOUGNE_TELEPORT),
    ARCEUUS_HARMONY_ISLAND("Harmony Island Teleport", Spellbook.ARCEUUS, SpriteID.SPELL_HARMONY_ISLAND_TELEPORT),
    ARCEUUS_CEMETERY("Cemetery Teleport", Spellbook.ARCEUUS, SpriteID.SPELL_CEMETERY_TELEPORT),
    ARCEUUS_BARROWS("Barrows Teleport", Spellbook.ARCEUUS, SpriteID.SPELL_BARROWS_TELEPORT),
    ARCEUUS_APE_ATOLL("Ape Atoll Teleport", Spellbook.ARCEUUS, SpriteID.SPELL_APE_ATOLL_TELEPORT),


    // Grouping Interface Teleports
    BARBARIAN_ASSAULT("Barbarian Assault", Grouping.BARBARIAN_ASSAULT, ItemID.HEALER_HORN),
    BLAST_FURNACE("Blast Furnace", Grouping.BLAST_FURNACE, ItemID.GOLD_ORE),
    BURTHORPE_GAMES_ROOM("Burthorpe Games Room", Grouping.BURTHORPE_GAMES_ROOM, ItemID.GAMES_ROOM),
    CASTLE_WARS("Castle Wars", Grouping.CASTLE_WARS, ItemID.CASTLEWARS_CLOAK),
    CLAN_WARS("Clan Wars", Grouping.CLAN_WARS, ItemID.CLAN_WARS_CAPE),
    FISHING_TRAWLER("Fishing Trawler", Grouping.FISHING_TRAWLER, ItemID.SMALL_FISHING_NET),
    GUARDIANS_OF_THE_RIFT("Guardians of the Rift", Grouping.GUARDIANS_OF_THE_RIFT, ItemID.CATALYTIC_TALISMAN),
    LAST_MAN_STANDING("Last Man Standing", Grouping.LAST_MAN_STANDING, ItemID.VICTORS_CAPE_1000),
    NIGHTMARE_ZONE("Nightmare Zone", Grouping.NIGHTMARE_ZONE, ItemID.DREAM_POTION),
    PEST_CONTROL("Pest Control", Grouping.PEST_CONTROL, ItemID.VOID_SEAL1),
    RAT_PITS_ARDOUGNE("Rat Pits Ardougne", Grouping.RAT_PITS, ItemID.PET_KITTEN_1558),
    RAT_PITS_VARROCK("Rat Pits Varrock", Grouping.RAT_PITS, ItemID.PET_CAT_1562),
    RAT_PITS_KELDAGRIM("Rat Pits Keldagrim", Grouping.RAT_PITS, ItemID.PET_CAT_1567),
    RAT_PITS_PORT_SARIM("Rat Pits Port Sarim", Grouping.RAT_PITS, ItemID.WILY_CAT_6560),
    SHADES_OF_MORTTON("Shades of Mort'ton", Grouping.SHADES_OF_MORTTON, ItemID.FIYR_REMAINS),
    SOUL_WARS("Soul Wars", Grouping.SOUL_WARS, ItemID.SOUL_CAPE),
    TITHE_FARM("Tithe Farm", Grouping.TITHE_FARM, ItemID.LOGAVANO_FRUIT),
    TROUBLE_BREWING("Trouble Brewing", Grouping.TROUBLE_BREWING, ItemID.PIECES_OF_EIGHT),
    TZHAAR_FIGHT_PIT("TzHaar Fight Pit", Grouping.TZHAAR_FIGHT_PIT, ItemID.OBSIDIAN_CAPE),

    // Enchanted jewellery
    GAMES_NECKLACE_BARBARIAN_ASSAULT("Barbarian Assault", TeleportItem.GAMES_NECKLACE, ItemID.GAMES_NECKLACE1),
    GAMES_NECKLACE_BURTHORPE_GAMES_ROOM("Burthorpe Games Room", TeleportItem.GAMES_NECKLACE, ItemID.GAMES_NECKLACE1),
    GAMES_NECKLACE_TEARS_OF_GUTHIX("Tears of Guthix", TeleportItem.GAMES_NECKLACE, ItemID.GAMES_NECKLACE1),
    GAMES_NECKLACE_CORPOREAL_BEAST("Corporeal Beast", TeleportItem.GAMES_NECKLACE, ItemID.GAMES_NECKLACE1),
    GAMES_NECKLACE_WINTERTODT_CAMP("Wintertodt Camp", TeleportItem.GAMES_NECKLACE, ItemID.GAMES_NECKLACE1),

    RING_OF_DUELING_DUEL_ARENA("Duel Arena", TeleportItem.RING_OF_DUELING, ItemID.RING_OF_DUELING1),
    RING_OF_DUELING_FEROX_ENCLAVE("Ferox Enclave", TeleportItem.RING_OF_DUELING, ItemID.RING_OF_DUELING1),
    RING_OF_DUELING_CASTLE_WARS("Castle Wars", TeleportItem.RING_OF_DUELING, ItemID.RING_OF_DUELING1),

    RING_OF_LIFE("Ring of life", TeleportItem.RING_OF_LIFE, ItemID.RING_OF_LIFE),

    COMBAT_BRACELET_WARRIORS_GUILD("Warriors' Guild", TeleportItem.COMBAT_BRACELET, ItemID.COMBAT_BRACELET1),
    COMBAT_BRACELET_CHAMPIONS_GUILD("Champions' Guild", TeleportItem.COMBAT_BRACELET, ItemID.COMBAT_BRACELET1),
    COMBAT_BRACELET_EDGEVILLE_MONASTERY("Edgeville Monastery", TeleportItem.COMBAT_BRACELET, ItemID.COMBAT_BRACELET1),
    COMBAT_BRACELET_RANGING_GUILD("Ranging Guild", TeleportItem.COMBAT_BRACELET, ItemID.COMBAT_BRACELET1),

    SKILLS_NECKLACE_FISHING_GUILD("Fishing Guild", TeleportItem.SKILLS_NECKLACE, ItemID.SKILLS_NECKLACE1),
    SKILLS_NECKLACE_MINING_GUILD("Mining Guild", TeleportItem.SKILLS_NECKLACE, ItemID.SKILLS_NECKLACE1),
    SKILLS_NECKLACE_CRAFTING_GUILD("Crafting Guild", TeleportItem.SKILLS_NECKLACE, ItemID.SKILLS_NECKLACE1),
    SKILLS_NECKLACE_COOKS_GUILD("Cooks' Guild", TeleportItem.SKILLS_NECKLACE, ItemID.SKILLS_NECKLACE1),
    SKILLS_NECKLACE_WOODCUTTING_GUILD("Woodcutting Guild", TeleportItem.SKILLS_NECKLACE, ItemID.SKILLS_NECKLACE1),
    SKILLS_NECKLACE_FARMING_GUILD("Farming Guild", TeleportItem.SKILLS_NECKLACE, ItemID.SKILLS_NECKLACE1),

    AMULET_OF_GLORY_EDGEVILLE("Edgeville", TeleportItem.AMULET_OF_GLORY, ItemID.AMULET_OF_GLORY1),
    AMULET_OF_GLORY_KARAMJA("Karamja", TeleportItem.AMULET_OF_GLORY, ItemID.AMULET_OF_GLORY1),
    AMULET_OF_GLORY_DRAYNOR_VILLAGE("Draynor Village", TeleportItem.AMULET_OF_GLORY, ItemID.AMULET_OF_GLORY1),
    AMULET_OF_GLORY_AL_KHARID("Al-Kharid", TeleportItem.AMULET_OF_GLORY, ItemID.AMULET_OF_GLORY1),

    AMULET_OF_ETERNAL_GLORY_EDGEVILLE("Edgeville", TeleportItem.AMULET_OF_ETERNAL_GLORY, ItemID.AMULET_OF_ETERNAL_GLORY),
    AMULET_OF_ETERNAL_GLORY_KARAMJA("Karamja", TeleportItem.AMULET_OF_ETERNAL_GLORY, ItemID.AMULET_OF_ETERNAL_GLORY),
    AMULET_OF_ETERNAL_GLORY_DRAYNOR_VILLAGE("Draynor Village", TeleportItem.AMULET_OF_ETERNAL_GLORY, ItemID.AMULET_OF_ETERNAL_GLORY),
    AMULET_OF_ETERNAL_GLORY_AL_KHARID("Al-Kharid", TeleportItem.AMULET_OF_ETERNAL_GLORY, ItemID.AMULET_OF_ETERNAL_GLORY),

    RING_OF_WEALTH_MISCELLANIA("Miscellania", TeleportItem.RING_OF_WEALTH, ItemID.RING_OF_WEALTH_1),
    RING_OF_WEALTH_GRAND_EXCHANGE("Grand Exchange", TeleportItem.RING_OF_WEALTH, ItemID.RING_OF_WEALTH_1),
    RING_OF_WEALTH_FALADOR_PARK("Falador Park", TeleportItem.RING_OF_WEALTH, ItemID.RING_OF_WEALTH_1),
    RING_OF_WEALTH_DONDAKAN("Dondakan", TeleportItem.RING_OF_WEALTH, ItemID.RING_OF_WEALTH_1),

    SLAYER_RING_SLAYER_TOWER("Slayer Tower", TeleportItem.SLAYER_RING, ItemID.SLAYER_RING_1),
    SLAYER_RING_FREMENNIK_SLAYER_DUNGEON("Fremennik Slayer Dungeon", TeleportItem.SLAYER_RING, ItemID.SLAYER_RING_1),
    SLAYER_RING_TARNS_LAIR("Tarn's Lair", TeleportItem.SLAYER_RING, ItemID.SLAYER_RING_1),
    SLAYER_RING_STRONGHOLD_SLAYER_CAVE("Stronghold Slayer Cave", TeleportItem.SLAYER_RING, ItemID.SLAYER_RING_1),
    SLAYER_RING_DARK_BEASTS("Dark Beasts", TeleportItem.SLAYER_RING, ItemID.SLAYER_RING_1),

    SLAYER_RING_ETERNAL_SLAYER_TOWER("Slayer Tower", TeleportItem.SLAYER_RING_ETERNAL, ItemID.SLAYER_RING_ETERNAL),
    SLAYER_RING_ETERNAL_FREMENNIK_SLAYER_DUNGEON("Fremennik Slayer Dungeon", TeleportItem.SLAYER_RING_ETERNAL, ItemID.SLAYER_RING_ETERNAL),
    SLAYER_RING_ETERNAL_TARNS_LAIR("Tarn's Lair", TeleportItem.SLAYER_RING_ETERNAL, ItemID.SLAYER_RING_ETERNAL),
    SLAYER_RING_ETERNAL_STRONGHOLD_SLAYER_CAVE("Stronghold Slayer Cave", TeleportItem.SLAYER_RING_ETERNAL, ItemID.SLAYER_RING_ETERNAL),
    SLAYER_RING_ETERNAL_DARK_BEASTS("Dark Beasts", TeleportItem.SLAYER_RING_ETERNAL, ItemID.SLAYER_RING_ETERNAL),

    DIGSITE_PENDANT_DIGSITE("Digsite", TeleportItem.DIGSITE_PENDANT, ItemID.DIGSITE_PENDANT_1),
    DIGSITE_PENDANT_HOUSE_ON_THE_HILL("House on the Hill", TeleportItem.DIGSITE_PENDANT, ItemID.DIGSITE_PENDANT_1),
    DIGSITE_PENDANT_LITHKREN("Lithkren", TeleportItem.DIGSITE_PENDANT, ItemID.DIGSITE_PENDANT_1),

    RING_OF_RETURNING_LUMBRIDGE("Lumbridge", TeleportItem.RING_OF_RETURNING, ItemID.RING_OF_RETURNING1),
    RING_OF_RETURNING_FALADOR("Falador", TeleportItem.RING_OF_RETURNING, ItemID.RING_OF_RETURNING1),
    RING_OF_RETURNING_CAMELOT("Camelot", TeleportItem.RING_OF_RETURNING, ItemID.RING_OF_RETURNING1),
    RING_OF_RETURNING_EDGEVILLE("Edgeville", TeleportItem.RING_OF_RETURNING, ItemID.RING_OF_RETURNING1),
    RING_OF_RETURNING_PRIFDDINAS("Prifddinas", TeleportItem.RING_OF_RETURNING, ItemID.RING_OF_RETURNING1),
    RING_OF_RETURNING_FEROX_ENCLAVE("Ferox Enclave", TeleportItem.RING_OF_RETURNING, ItemID.RING_OF_RETURNING1),

    NECKLACE_OF_PASSAGE_WIZARDS_TOWER("Wizards' Tower", TeleportItem.NECKLACE_OF_PASSAGE, ItemID.NECKLACE_OF_PASSAGE1),
    NECKLACE_OF_PASSAGE_JORRALS_OUTPOST("Jorral's Outpost", TeleportItem.NECKLACE_OF_PASSAGE, ItemID.NECKLACE_OF_PASSAGE1),
    NECKLACE_OF_PASSAGE_DESERT_EAGLE_STATION("Desert eagle station", TeleportItem.NECKLACE_OF_PASSAGE, ItemID.NECKLACE_OF_PASSAGE1),

    BURNING_AMULET_CHAOS_TEMPLE("Chaos Temple", TeleportItem.BURNING_AMULET, ItemID.BURNING_AMULET1),
    BURNING_AMULET_BANDIT_CAMP("Bandit Camp", TeleportItem.BURNING_AMULET, ItemID.BURNING_AMULET1),
    BURNING_AMULET_LAVA_MAZE("Lava Maze", TeleportItem.BURNING_AMULET, ItemID.BURNING_AMULET1),


    // Standard tablets
    VARROCK_TABLET("Varrock tablet", TeleportItem.VARROCK_TABLET, ItemID.VARROCK_TELEPORT),
    FALADOR_TABLET("Falador tablet", TeleportItem.FALADOR_TABLET, ItemID.FALADOR_TELEPORT),
    LUMBRIDGE_TABLET("Lumbridge tablet", TeleportItem.LUMBRIDGE_TABLET, ItemID.LUMBRIDGE_TELEPORT),
    CAMELOT_TABLET("Camelot tablet", TeleportItem.CAMELOT_TABLET, ItemID.CAMELOT_TELEPORT),
    ARDOUGNE_TABLET("Ardougne tablet", TeleportItem.ARDOUGNE_TABLET, ItemID.ARDOUGNE_TELEPORT),
    WATCHTOWER_TABLET("Watchtower tablet", TeleportItem.WATCHTOWER_TABLET, ItemID.WATCHTOWER_TELEPORT),
    HOUSE_TABLET("House tablet", TeleportItem.HOUSE_TABLET, ItemID.TELEPORT_TO_HOUSE),// idk
    RIMMINGTON_TABLET("Rimmington tablet", TeleportItem.RIMMINGTON_TABLET, ItemID.RIMMINGTON_TELEPORT),
    TAVERLEY_TABLET("Taverley tablet", TeleportItem.TAVERLEY_TABLET, ItemID.TAVERLEY_TELEPORT),
    POLLNIVNEACH_TABLET("Pollnivneach tablet", TeleportItem.POLLNIVNEACH_TABLET, ItemID.POLLNIVNEACH_TELEPORT),
    RELLEKKA_TABLET("Rellekka tablet", TeleportItem.RELLEKKA_TABLET, ItemID.RELLEKKA_TELEPORT),
    BRIMHAVEN_TABLET("Brimhaven tablet", TeleportItem.BRIMHAVEN_TABLET, ItemID.BRIMHAVEN_TELEPORT),
    YANILLE_TABLET("Yanille tablet", TeleportItem.YANILLE_TABLET, ItemID.YANILLE_TELEPORT),
    TROLLHEIM_TABLET("Trollheim tablet", TeleportItem.TROLLHEIM_TABLET, ItemID.TROLLHEIM_TELEPORT),
    HOSIDIUS_TABLET("Hosidius tablet", TeleportItem.HOSIDIUS_TABLET, ItemID.HOSIDIUS_TELEPORT),

    // Ancient tablets
    PADDEWWA_TELEPORT_TABLET("Paddewwa teleport tablet", TeleportItem.PADDEWWA_TELEPORT_TABLET, ItemID.PADDEWWA_TELEPORT),
    SENNTISTEN_TELEPORT_TABLET("Senntisten teleport tablet", TeleportItem.SENNTISTEN_TELEPORT_TABLET, ItemID.SENNTISTEN_TELEPORT),
    KHARYRLL_TELEPORT_TABLET("Kharyrll teleport tablet", TeleportItem.KHARYRLL_TELEPORT_TABLET, ItemID.KHARYRLL_TELEPORT),
    LASSAR_TELEPORT_TABLET("Lassar teleport tablet", TeleportItem.LASSAR_TELEPORT_TABLET, ItemID.LASSAR_TELEPORT),
    DAREEYAK_TELEPORT_TABLET("Dareeyak teleport tablet", TeleportItem.DAREEYAK_TELEPORT_TABLET, ItemID.DAREEYAK_TELEPORT),
    CARRALLANGAR_TELEPORT_TABLET("Carrallangar teleport tablet", TeleportItem.CARRALLANGAR_TELEPORT_TABLET, ItemID.CARRALLANGAR_TELEPORT),
    ANNAKARL_TELEPORT_TABLET("Annakarl teleport tablet", TeleportItem.ANNAKARL_TELEPORT_TABLET, ItemID.ANNAKARL_TELEPORT),
    GHORROCK_TELEPORT_TABLET("Ghorrock teleport tablet", TeleportItem.GHORROCK_TELEPORT_TABLET, ItemID.GHORROCK_TELEPORT),

    // Lunar tablets
    MOONCLAN_TELEPORT_TABLET("Moonclan teleport tablet", TeleportItem.MOONCLAN_TELEPORT_TABLET, ItemID.MOONCLAN_TELEPORT),
    OURANIA_TELEPORT_TABLET("Ourania teleport tablet", TeleportItem.OURANIA_TELEPORT_TABLET, ItemID.OURANIA_TELEPORT),
    WATERBIRTH_TELEPORT_TABLET("Waterbirth teleport tablet", TeleportItem.WATERBIRTH_TELEPORT_TABLET, ItemID.WATERBIRTH_TELEPORT),
    BARBARIAN_TELEPORT_TABLET("Barbarian teleport tablet", TeleportItem.BARBARIAN_TELEPORT_TABLET, ItemID.BARBARIAN_TELEPORT),
    KHAZARD_TELEPORT_TABLET("Khazard teleport tablet", TeleportItem.KHAZARD_TELEPORT_TABLET, ItemID.KHAZARD_TELEPORT),
    FISHING_GUILD_TELEPORT_TABLET("Fishing guild teleport tablet", TeleportItem.FISHING_GUILD_TELEPORT_TABLET, ItemID.FISHING_GUILD_TELEPORT),
    CATHERBY_TELEPORT_TABLET("Catherby teleport tablet", TeleportItem.CATHERBY_TELEPORT_TABLET, ItemID.CATHERBY_TELEPORT),
    ICE_PLATEAU_TELEPORT_TABLET("Ice plateau teleport tablet", TeleportItem.ICE_PLATEAU_TELEPORT_TABLET, ItemID.ICE_PLATEAU_TELEPORT),

    // Arceuus tablets
    ARCEUUS_LIBRARY_TABLET("Arceuus Library tablet", TeleportItem.ARCEUUS_LIBRARY_TABLET, ItemID.ARCEUUS_LIBRARY_TELEPORT),
    DRAYNOR_MANOR_TABLET("Draynor Manor tablet", TeleportItem.DRAYNOR_MANOR_TABLET, ItemID.DRAYNOR_MANOR_TELEPORT),
    BATTLEFRONT_TABLET("Battlefront tablet", TeleportItem.BATTLEFRONT_TABLET, ItemID.BATTLEFRONT_TELEPORT),
    MIND_ALTAR_TABLET("Mind altar tablet", TeleportItem.MIND_ALTAR_TABLET, ItemID.MIND_ALTAR_TELEPORT),
    SALVE_GRAVEYARD_TABLET("Salve Graveyard tablet", TeleportItem.SALVE_GRAVEYARD_TABLET, ItemID.SALVE_GRAVEYARD_TELEPORT),
    FENKENSTRAINS_CASTLE_TABLET("Fenkenstrain’s Castle tablet", TeleportItem.FENKENSTRAINS_CASTLE_TABLET, ItemID.FENKENSTRAINS_CASTLE_TELEPORT),
    WEST_ARDOUGNE_TABLET("West Ardougne tablet", TeleportItem.WEST_ARDOUGNE_TABLET, ItemID.WEST_ARDOUGNE_TELEPORT),
    HARMONY_ISLAND_TABLET("Harmony Island tablet", TeleportItem.HARMONY_ISLAND_TABLET, ItemID.HARMONY_ISLAND_TELEPORT),
    CEMETERY_TABLET("Cemetery tablet", TeleportItem.CEMETERY_TABLET, ItemID.CEMETERY_TELEPORT),
    BARROWS_TABLET("Barrows tablet", TeleportItem.BARROWS_TABLET, ItemID.BARROWS_TELEPORT),
    APE_ATOLL_TABLET("Ape Atoll tablet", TeleportItem.APE_ATOLL_TABLET, ItemID.APE_ATOLL_TELEPORT),

    // Other 1-use teleport items
    TARGET_TELEPORT("Target teleport", TeleportItem.TARGET_TELEPORT, ItemID.TARGET_TELEPORT),
    VOLCANIC_MINE_TELEPORT("Volcanic mine teleport", TeleportItem.VOLCANIC_MINE_TELEPORT, ItemID.VOLCANIC_MINE_TELEPORT),
    WILDERNESS_CRABS_TELEPORT("Wilderness crabs teleport", TeleportItem.WILDERNESS_CRABS_TELEPORT, ItemID.WILDERNESS_CRABS_TELEPORT),
    DORGESHKAAN_SPHERE("Dorgesh-kaan sphere", TeleportItem.DORGESHKAAN_SPHERE, ItemID.DORGESHKAAN_SPHERE),
    GOBLIN_VILLAGE_SPHERE("Goblin village sphere", TeleportItem.GOBLIN_VILLAGE_SPHERE, ItemID.GOBLIN_VILLAGE_SPHERE),
    PLAIN_OF_MUD_SPHERE("Plain of mud sphere", TeleportItem.PLAIN_OF_MUD_SPHERE, ItemID.PLAIN_OF_MUD_SPHERE),
    GRAND_SEED_POD("Grand seed pod", TeleportItem.GRAND_SEED_POD, ItemID.GRAND_SEED_POD),
    RUM_TROUBLE_BREWING("Rum (Trouble Brewing)", TeleportItem.RUM_TROUBLE_BREWING, ItemID.RUM),

    // Teleport scrolls
    NARDAH_TELEPORT("Nardah teleport", TeleportItem.NARDAH_TELEPORT, ItemID.NARDAH_TELEPORT),
    DIGSITE_TELEPORT("Digsite teleport", TeleportItem.DIGSITE_TELEPORT, ItemID.DIGSITE_TELEPORT),
    FELDIP_HILLS_TELEPORT("Feldip hills teleport", TeleportItem.FELDIP_HILLS_TELEPORT, ItemID.FELDIP_HILLS_TELEPORT),
    LUNAR_ISLE_TELEPORT("Lunar isle teleport", TeleportItem.LUNAR_ISLE_TELEPORT, ItemID.LUNAR_ISLE_TELEPORT),
    MORTTON_TELEPORT("Mort'ton teleport", TeleportItem.MORTTON_TELEPORT, ItemID.MORTTON_TELEPORT),
    PEST_CONTROL_TELEPORT("Pest control teleport", TeleportItem.PEST_CONTROL_TELEPORT, ItemID.PEST_CONTROL_TELEPORT),
    PISCATORIS_TELEPORT("Piscatoris teleport", TeleportItem.PISCATORIS_TELEPORT, ItemID.PISCATORIS_TELEPORT),
    TAI_BWO_WANNAI_TELEPORT("Tai bwo wannai teleport", TeleportItem.TAI_BWO_WANNAI_TELEPORT, ItemID.TAI_BWO_WANNAI_TELEPORT),
    IORWERTH_CAMP_TELEPORT("Iorwerth camp teleport", TeleportItem.IORWERTH_CAMP_TELEPORT, ItemID.IORWERTH_CAMP_TELEPORT),
    MOS_LEHARMLESS_TELEPORT("Mos le'harmless teleport", TeleportItem.MOS_LEHARMLESS_TELEPORT, ItemID.MOS_LEHARMLESS_TELEPORT),
    LUMBERYARD_TELEPORT("Lumberyard teleport", TeleportItem.LUMBERYARD_TELEPORT, ItemID.LUMBERYARD_TELEPORT),
    ZULANDRA_TELEPORT("Zul-andra teleport", TeleportItem.ZULANDRA_TELEPORT, ItemID.ZULANDRA_TELEPORT),
    KEY_MASTER_TELEPORT("Key master teleport", TeleportItem.KEY_MASTER_TELEPORT, ItemID.KEY_MASTER_TELEPORT),
    REVENANT_CAVE_TELEPORT("Revenant cave teleport", TeleportItem.REVENANT_CAVE_TELEPORT, ItemID.REVENANT_CAVE_TELEPORT),
    WATSON_TELEPORT("Watson teleport", TeleportItem.WATSON_TELEPORT, ItemID.WATSON_TELEPORT),

    // Achievement diary items
    KARAMJA_GLOVES_GEM_MINE("Gem Mine", TeleportItem.KARAMJA_GLOVES, ItemID.KARAMJA_GLOVES_3),
    KARAMJA_GLOVES_DURADEL("Duradel", TeleportItem.KARAMJA_GLOVES, ItemID.KARAMJA_GLOVES_4),

    ARDOUGNE_CLOAK_MONASTERY("Monastery", TeleportItem.ARDOUGNE_CLOAK, ItemID.ARDOUGNE_CLOAK_1),
    ARDOUGNE_CLOAK_ARDOUGNE_FARM_PATCH("Ardougne Farm Patch", TeleportItem.ARDOUGNE_CLOAK, ItemID.ARDOUGNE_CLOAK_4),

    DESERT_AMULET_NARDAH("Nardah", TeleportItem.DESERT_AMULET, ItemID.DESERT_AMULET_2),
    DESERT_AMULET_KALPHITE_CAVE("Kalphite Cave", TeleportItem.DESERT_AMULET, ItemID.DESERT_AMULET_4),

    MORYTANIA_LEGS_ECTOFUNTUS("Ectofuntus", TeleportItem.MORYTANIA_LEGS, ItemID.MORYTANIA_LEGS_4),
    MORYTANIA_LEGS_BURGH_DE_ROTT("Burgh de Rott", TeleportItem.MORYTANIA_LEGS, ItemID.MORYTANIA_LEGS_4),

    FREMENNIK_SEA_BOOTS("Fremennik sea boots", TeleportItem.FREMENNIK_SEA_BOOTS, ItemID.FREMENNIK_SEA_BOOTS_4),
    KANDARIN_HEADGEAR("Kandarin headgear", TeleportItem.KANDARIN_HEADGEAR, ItemID.KANDARIN_HEADGEAR_4),
    WILDERNESS_SWORD("Wilderness sword", TeleportItem.WILDERNESS_SWORD, ItemID.WILDERNESS_SWORD_4),
    WESTERN_BANNER("Western banner", TeleportItem.WESTERN_BANNER, ItemID.WESTERN_BANNER_4),
    EXPLORERS_RING("Explorer's ring", TeleportItem.EXPLORERS_RING, ItemID.EXPLORERS_RING_4),

    RADAS_BLESSING_KOUREND_WOODLAND("Kourend Woodland", TeleportItem.RADAS_BLESSING, ItemID.RADAS_BLESSING_1),
    RADAS_BLESSING_MOUNT_KARUULM("Mount Karuulm", TeleportItem.RADAS_BLESSING, ItemID.RADAS_BLESSING_3),


    // Skill capes
    CRAFTING_CAPE("Crafting Guild", TeleportItem.CRAFTING_CAPE, ItemID.CRAFTING_CAPET),
    FARMING_CAPE("Farming Guild", TeleportItem.FARMING_CAPE, ItemID.FARMING_CAPET),
    STRENGTH_CAPE("Warriors' Guild", TeleportItem.STRENGTH_CAPE, ItemID.STRENGTH_CAPET),
    QUEST_POINT_CAPE("Legends' Guild", TeleportItem.QUEST_POINT_CAPE, ItemID.QUEST_POINT_CAPE_T),
    MUSIC_CAPE("Falo the Bard", TeleportItem.MUSIC_CAPE, ItemID.MUSIC_CAPET),

    CONSTRUCT_CAPE_RIMMINGTON("Rimmington", TeleportItem.CONSTRUCT_CAPE, ItemID.CONSTRUCT_CAPET),
    CONSTRUCT_CAPE_TAVERLEY ("Taverley ", TeleportItem.CONSTRUCT_CAPE, ItemID.CONSTRUCT_CAPET),
    CONSTRUCT_CAPE_POLLNIVNEACH("Pollnivneach", TeleportItem.CONSTRUCT_CAPE, ItemID.CONSTRUCT_CAPET),
    CONSTRUCT_CAPE_HOSIDIUS("Hosidius", TeleportItem.CONSTRUCT_CAPE, ItemID.CONSTRUCT_CAPET),
    CONSTRUCT_CAPE_RELLEKKA ("Rellekka ", TeleportItem.CONSTRUCT_CAPE, ItemID.CONSTRUCT_CAPET),
    CONSTRUCT_CAPE_BRIMHAVEN("Brimhaven", TeleportItem.CONSTRUCT_CAPE, ItemID.CONSTRUCT_CAPET),
    CONSTRUCT_CAPE_YANILLE("Yanille", TeleportItem.CONSTRUCT_CAPE, ItemID.CONSTRUCT_CAPET),
    CONSTRUCT_CAPE_PRIFDDINAS("Prifddinas", TeleportItem.CONSTRUCT_CAPE, ItemID.CONSTRUCT_CAPET),

    FISHING_CAPE_FISHING_GUILD("Fishing Guild", TeleportItem.FISHING_CAPE, ItemID.FISHING_CAPET),
    FISHING_CAPE_OTTOS_GROTTO("Otto's Grotto", TeleportItem.FISHING_CAPE, ItemID.FISHING_CAPET),

    HUNTER_CAPE_BLACK_CHINCHOMPAS("Black chinchompas", TeleportItem.HUNTER_CAPE, ItemID.HUNTER_CAPET),
    HUNTER_CAPE_RED_CHINCHOMPAS("Red chinchompas", TeleportItem.HUNTER_CAPE, ItemID.HUNTER_CAPET),

    MAX_CAPE_CRAFTING("Crafting Guild", TeleportItem.MAX_CAPE, ItemID.CRAFTING_CAPET),
    MAX_CAPE_CONSTRUCT_RIMMINGTON("Rimmington", TeleportItem.MAX_CAPE, ItemID.CONSTRUCT_CAPET),
    MAX_CAPE_CONSTRUCT_TAVERLEY ("Taverley ", TeleportItem.MAX_CAPE, ItemID.CONSTRUCT_CAPET),
    MAX_CAPE_CONSTRUCT_POLLNIVNEACH("Pollnivneach", TeleportItem.MAX_CAPE, ItemID.CONSTRUCT_CAPET),
    MAX_CAPE_CONSTRUCT_HOSIDIUS("Hosidius", TeleportItem.MAX_CAPE, ItemID.CONSTRUCT_CAPET),
    MAX_CAPE_CONSTRUCT_RELLEKKA ("Rellekka ", TeleportItem.MAX_CAPE, ItemID.CONSTRUCT_CAPET),
    MAX_CAPE_CONSTRUCT_BRIMHAVEN("Brimhaven", TeleportItem.MAX_CAPE, ItemID.CONSTRUCT_CAPET),
    MAX_CAPE_CONSTRUCT_YANILLE("Yanille", TeleportItem.MAX_CAPE, ItemID.CONSTRUCT_CAPET),
    MAX_CAPE_CONSTRUCT_PRIFDDINAS("Prifddinas", TeleportItem.MAX_CAPE, ItemID.CONSTRUCT_CAPET),
    MAX_CAPE_FISHING_GUILD("Fishing Guild", TeleportItem.MAX_CAPE, ItemID.FISHING_CAPET),
    MAX_CAPE_OTTOS_GROTTO("Otto's Grotto", TeleportItem.MAX_CAPE, ItemID.FISHING_CAPET),
    MAX_CAPE_FARMING("Farming Guild", TeleportItem.MAX_CAPE, ItemID.FARMING_CAPET),
    MAX_CAPE_BLACK_CHINCHOMPAS("Black chinchompas", TeleportItem.MAX_CAPE, ItemID.HUNTER_CAPET),
    MAX_CAPE_RED_CHINCHOMPAS("Red chinchompas", TeleportItem.MAX_CAPE, ItemID.HUNTER_CAPET),
    MAX_CAPE_STRENGTH("Warriors' Guild", TeleportItem.MAX_CAPE, ItemID.STRENGTH_CAPET),

    ACHIEVEMENT_DIARY_CAPE_TWO_PINTS("Two-pints", TeleportItem.ACHIEVEMENT_DIARY_CAPE, ItemID.ACHIEVEMENT_DIARY_CAPE_T),
    ACHIEVEMENT_DIARY_CAPE_JARR("Jarr", TeleportItem.ACHIEVEMENT_DIARY_CAPE, ItemID.ACHIEVEMENT_DIARY_CAPE_T),
    ACHIEVEMENT_DIARY_CAPE_SIR_REBRAL("Sir Rebral", TeleportItem.ACHIEVEMENT_DIARY_CAPE, ItemID.ACHIEVEMENT_DIARY_CAPE_T),
    ACHIEVEMENT_DIARY_CAPE_THORODIN("Thorodin", TeleportItem.ACHIEVEMENT_DIARY_CAPE, ItemID.ACHIEVEMENT_DIARY_CAPE_T),
    ACHIEVEMENT_DIARY_CAPE_FLAX_KEEPER("Flax keeper", TeleportItem.ACHIEVEMENT_DIARY_CAPE, ItemID.ACHIEVEMENT_DIARY_CAPE_T),
    ACHIEVEMENT_DIARY_CAPE_PIRATE_JACKIE_THE_FRUIT("Pirate Jackie the Fruit", TeleportItem.ACHIEVEMENT_DIARY_CAPE, ItemID.ACHIEVEMENT_DIARY_CAPE_T),
    ACHIEVEMENT_DIARY_CAPE_KALEB_PARAMAYA("Kaleb Paramaya", TeleportItem.ACHIEVEMENT_DIARY_CAPE, ItemID.ACHIEVEMENT_DIARY_CAPE_T),
    ACHIEVEMENT_DIARY_CAPE_JUNGLE_FORESTER("Jungle forester", TeleportItem.ACHIEVEMENT_DIARY_CAPE, ItemID.ACHIEVEMENT_DIARY_CAPE_T),
    ACHIEVEMENT_DIARY_CAPE_TZHAAR_MEJ("TzHaar-Mej", TeleportItem.ACHIEVEMENT_DIARY_CAPE, ItemID.ACHIEVEMENT_DIARY_CAPE_T),
    ACHIEVEMENT_DIARY_CAPE_ELISE("Elise", TeleportItem.ACHIEVEMENT_DIARY_CAPE, ItemID.ACHIEVEMENT_DIARY_CAPE_T),
    ACHIEVEMENT_DIARY_CAPE_HATIUS_COSAINTUS("Hatius Cosaintus", TeleportItem.ACHIEVEMENT_DIARY_CAPE, ItemID.ACHIEVEMENT_DIARY_CAPE_T),
    ACHIEVEMENT_DIARY_CAPE_LE_SABRE("Le-sabrè", TeleportItem.ACHIEVEMENT_DIARY_CAPE, ItemID.ACHIEVEMENT_DIARY_CAPE_T),
    ACHIEVEMENT_DIARY_CAPE_TOBY("Toby", TeleportItem.ACHIEVEMENT_DIARY_CAPE, ItemID.ACHIEVEMENT_DIARY_CAPE_T),
    ACHIEVEMENT_DIARY_CAPE_LESSER_FANATIC("Lesser Fanatic", TeleportItem.ACHIEVEMENT_DIARY_CAPE, ItemID.ACHIEVEMENT_DIARY_CAPE_T),
    ACHIEVEMENT_DIARY_CAPE_ELDER_GNOME_CHILD("Elder Gnome child", TeleportItem.ACHIEVEMENT_DIARY_CAPE, ItemID.ACHIEVEMENT_DIARY_CAPE_T),
    ACHIEVEMENT_DIARY_CAPE_TWIGGY_OKORN("Twiggy O'Korn", TeleportItem.ACHIEVEMENT_DIARY_CAPE, ItemID.ACHIEVEMENT_DIARY_CAPE_T),

    // Quest-related items
    ECTOPHIAL("Ectophial", TeleportItem.ECTOPHIAL, ItemID.ECTOPHIAL),
    ROYAL_SEED_POD("Royal seed pod", TeleportItem.ROYAL_SEED_POD, ItemID.ROYAL_SEED_POD),
    MYTHICAL_CAPE("Mythical cape", TeleportItem.MYTHICAL_CAPE, ItemID.MYTHICAL_CAPE_22114),
    STONY_BASALT("Stony basalt", TeleportItem.STONY_BASALT, ItemID.STONY_BASALT),
    ICY_BASALT("Icy basalt", TeleportItem.ICY_BASALT, ItemID.ICY_BASALT),

    TELEPORT_CRYSTAL_LLETYA("Lletya", TeleportItem.TELEPORT_CRYSTAL, ItemID.TELEPORT_CRYSTAL),
    TELEPORT_CRYSTAL_PRIFDDINAS("Prifddinas", TeleportItem.TELEPORT_CRYSTAL, ItemID.TELEPORT_CRYSTAL),

    ETERNAL_TELEPORT_CRYSTAL_LLETYA("Lletya", TeleportItem.ETERNAL_TELEPORT_CRYSTAL, ItemID.ETERNAL_TELEPORT_CRYSTAL),
    ETERNAL_TELEPORT_CRYSTAL_PRIFDDINAS("Prifddinas", TeleportItem.ETERNAL_TELEPORT_CRYSTAL, ItemID.ETERNAL_TELEPORT_CRYSTAL),

    ENCHANTED_LYRE_RELLEKKA_DOCK("Rellekka dock", TeleportItem.ENCHANTED_LYRE, ItemID.ENCHANTED_LYRE),
    ENCHANTED_LYRE_WATERBIRTH_ISLAND("Waterbirth Island", TeleportItem.ENCHANTED_LYRE, ItemID.ENCHANTED_LYRE),
    ENCHANTED_LYRE_JATIZSO("Jatizso", TeleportItem.ENCHANTED_LYRE, ItemID.ENCHANTED_LYRE),
    ENCHANTED_LYRE_NEITIZNOT("Neitiznot", TeleportItem.ENCHANTED_LYRE, ItemID.ENCHANTED_LYRE),

    CAMULET_ENAKHRAS_TEMPLE("Enakhra's Temple", TeleportItem.CAMULET, ItemID.CAMULET),
    CAMULET_ENAKHRAS_TEMPLE_ENTRANCE("Enakhra's Temple entrance", TeleportItem.CAMULET, ItemID.CAMULET),

    KHAREDSTS_MEMOIRS_HOSIDIUS("Lunch by the lancalliums (Hosidius)", TeleportItem.KHAREDSTS_MEMOIRS, ItemID.KHAREDSTS_MEMOIRS),
    KHAREDSTS_MEMOIRS_PISCARILIUS("The fisher's flute (Piscarilius)", TeleportItem.KHAREDSTS_MEMOIRS, ItemID.KHAREDSTS_MEMOIRS),
    KHAREDSTS_MEMOIRS_SHAYZIEN("History and hearsay (Shayzien)", TeleportItem.KHAREDSTS_MEMOIRS, ItemID.KHAREDSTS_MEMOIRS),
    KHAREDSTS_MEMOIRS_LOVAKENGJ("Jewellery of jubilation (Lovakengj)", TeleportItem.KHAREDSTS_MEMOIRS, ItemID.KHAREDSTS_MEMOIRS),
    KHAREDSTS_MEMOIRS_ARCEUUS("A dark disposition (Arceuus)", TeleportItem.KHAREDSTS_MEMOIRS, ItemID.KHAREDSTS_MEMOIRS),

    BOOK_OF_THE_DEAD_HOSIDIUS("Lunch by the lancalliums (Hosidius)", TeleportItem.BOOK_OF_THE_DEAD, ItemID.BOOK_OF_THE_DEAD),
    BOOK_OF_THE_DEAD_PISCARILIUS("The fisher's flute (Piscarilius)", TeleportItem.BOOK_OF_THE_DEAD, ItemID.BOOK_OF_THE_DEAD),
    BOOK_OF_THE_DEAD_SHAYZIEN("History and hearsay (Shayzien)", TeleportItem.BOOK_OF_THE_DEAD, ItemID.BOOK_OF_THE_DEAD),
    BOOK_OF_THE_DEAD_LOVAKENGJ("Jewellery of jubilation (Lovakengj)", TeleportItem.BOOK_OF_THE_DEAD, ItemID.BOOK_OF_THE_DEAD),
    BOOK_OF_THE_DEAD_ARCEUUS("A dark disposition (Arceuus)", TeleportItem.BOOK_OF_THE_DEAD, ItemID.BOOK_OF_THE_DEAD),

    DRAKANS_MEDALLION_VER_SINHAZA("Ver Sinhaza", TeleportItem.DRAKANS_MEDALLION, ItemID.DRAKANS_MEDALLION),
    DRAKANS_MEDALLION_DARKMEYER("Darkmeyer", TeleportItem.DRAKANS_MEDALLION, ItemID.DRAKANS_MEDALLION),
    DRAKANS_MEDALLION_SLEPE("Slepe", TeleportItem.DRAKANS_MEDALLION, ItemID.DRAKANS_MEDALLION),


    // Other items
    CHRONICLE("Chronicle", TeleportItem.CHRONICLE, ItemID.CHRONICLE),
    SKULL_SCEPTRE("Skull sceptre", TeleportItem.SKULL_SCEPTRE, ItemID.SKULL_SCEPTRE),
    AMULET_OF_THE_EYE("Amulet of the Eye", TeleportItem.AMULET_OF_THE_EYE, ItemID.AMULET_OF_THE_EYE),

    PHARAOHS_SCEPTRE_JALSAVRAH("Jalsavrah (Pyramid Plunder)", TeleportItem.PHARAOHS_SCEPTRE, ItemID.PHARAOHS_SCEPTRE),
    PHARAOHS_SCEPTRE_JALEUSTROPHOS("Jaleustrophos (Agility Pyramid)", TeleportItem.PHARAOHS_SCEPTRE, ItemID.PHARAOHS_SCEPTRE),
    PHARAOHS_SCEPTRE_JALDRAOCHT("Jaldraocht (Azzanadra's Pyramid)", TeleportItem.PHARAOHS_SCEPTRE, ItemID.PHARAOHS_SCEPTRE),
    PHARAOHS_SCEPTRE_JALTEVAS("Jaltevas (Necropolis)", TeleportItem.PHARAOHS_SCEPTRE, ItemID.PHARAOHS_SCEPTRE),

    XERICS_TALISMAN_LOOKOUT("Xeric's Lookout", TeleportItem.XERICS_TALISMAN, ItemID.XERICS_TALISMAN),
    XERICS_TALISMAN_GLADE("Xeric's Glade", TeleportItem.XERICS_TALISMAN, ItemID.XERICS_TALISMAN),
    XERICS_TALISMAN_INFERNO("Xeric's Inferno", TeleportItem.XERICS_TALISMAN, ItemID.XERICS_TALISMAN),
    XERICS_TALISMAN_HEART("Xeric's Heart", TeleportItem.XERICS_TALISMAN, ItemID.XERICS_TALISMAN),
    XERICS_TALISMAN_HONOUR("Xeric's Honour", TeleportItem.XERICS_TALISMAN, ItemID.XERICS_TALISMAN),

    RING_OF_THE_ELEMENTS_FIRE_ALTAR("Fire Altar", TeleportItem.RING_OF_THE_ELEMENTS, ItemID.RING_OF_THE_ELEMENTS_26818),
    RING_OF_THE_ELEMENTS_WATER_ALTAR("Water Altar", TeleportItem.RING_OF_THE_ELEMENTS, ItemID.RING_OF_THE_ELEMENTS_26818),
    RING_OF_THE_ELEMENTS_AIR_ALTAR("Air Altar", TeleportItem.RING_OF_THE_ELEMENTS, ItemID.RING_OF_THE_ELEMENTS_26818),
    RING_OF_THE_ELEMENTS_EARTH_ALTAR("Earth Altar", TeleportItem.RING_OF_THE_ELEMENTS, ItemID.RING_OF_THE_ELEMENTS_26818);


    private final String name;

    private final TransportationMethod transportationMethod;

    private final Spellbook spellbook;
    private final Grouping grouping;
    private final TeleportItem teleportItem;

    private final int spriteID;
    private final int itemID;

    public static final ImmutableMultimap<Spellbook, Transportation> SPELLBOOK_TELEPORT_MAP;
    public static final ImmutableMultimap<Grouping, Transportation> GROUPING_TELEPORT_MAP;
    public static final ImmutableMultimap<TeleportItem, Transportation> ITEM_TELEPORT_MAP;

    static
    {
        final ImmutableMultimap.Builder<Spellbook, Transportation> spellbookBuilder = ImmutableMultimap.builder();
        final ImmutableMultimap.Builder<Grouping, Transportation> groupingBuilder = ImmutableMultimap.builder();
        final ImmutableMultimap.Builder<TeleportItem, Transportation> teleportItemBuilder = ImmutableMultimap.builder();

        for (final Transportation transportation : values())
        {
            if (transportation.getSpellbook() != null)
            {
                spellbookBuilder.put(transportation.getSpellbook(), transportation);
            }
            if (transportation.getGrouping() != null)
            {
                groupingBuilder.put(transportation.getGrouping(), transportation);
            }
            if (transportation.getTeleportItem() != null)
            {
                teleportItemBuilder.put(transportation.getTeleportItem(), transportation);
            }

        }
        SPELLBOOK_TELEPORT_MAP = spellbookBuilder.build();
        GROUPING_TELEPORT_MAP = groupingBuilder.build();
        ITEM_TELEPORT_MAP = teleportItemBuilder.build();
    }

    Transportation(String name, Spellbook spellbook, int spriteID)
    {
        this.name = name;
        this.spellbook = spellbook;
        this.spriteID = spriteID;

        this.grouping = null;
        this.teleportItem = null;
        this.itemID = -1;
        this.transportationMethod = TransportationMethod.SPELLBOOK_TELEPORT;
    }
    Transportation(String name, Grouping grouping, int itemID)
    {
        this.name = name;
        this.grouping = grouping;
        this.itemID = itemID;

        this.spellbook = null;
        this.teleportItem = null;
        this.spriteID = -1;
        this.transportationMethod = TransportationMethod.GROUPING_TELEPORT;
    }

    Transportation(String name, TeleportItem teleportItem, int itemID)
    {
        this.name = name;
        this.teleportItem = teleportItem;
        this.itemID = itemID;

        this.spellbook = null;
        this.grouping = null;
        this.spriteID = -1;
        this.transportationMethod = TransportationMethod.ITEM_TELEPORT;
    }
}

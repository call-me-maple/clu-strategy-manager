package cluestrategymanager.transportation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.ItemID;

@Getter
@AllArgsConstructor
public enum TeleportItem
{
    // Enchanted jewellery
    GAMES_NECKLACE("Games necklace", ItemID.GAMES_NECKLACE1),
    RING_OF_DUELING("Ring of dueling", ItemID.RING_OF_DUELING1),
    RING_OF_LIFE("Ring of life", ItemID.RING_OF_LIFE),
    COMBAT_BRACELET("Combat bracelet", ItemID.COMBAT_BRACELET1),
    SKILLS_NECKLACE("Skills necklace", ItemID.SKILLS_NECKLACE1),
    AMULET_OF_GLORY("Amulet of glory", ItemID.AMULET_OF_GLORY1),
    AMULET_OF_ETERNAL_GLORY("Amulet of eternal glory", ItemID.AMULET_OF_ETERNAL_GLORY),
    RING_OF_WEALTH("Ring of wealth", ItemID.RING_OF_WEALTH_1),
    SLAYER_RING("Slayer ring", ItemID.SLAYER_RING_1),
    SLAYER_RING_ETERNAL("Slayer ring (eternal)", ItemID.SLAYER_RING_ETERNAL),
    DIGSITE_PENDANT("Digsite pendant", ItemID.DIGSITE_PENDANT_1),
    RING_OF_RETURNING("Ring of returning", ItemID.RING_OF_RETURNING1),
    NECKLACE_OF_PASSAGE("Necklace of passage", ItemID.NECKLACE_OF_PASSAGE1),
    BURNING_AMULET("Burning amulet", ItemID.BURNING_AMULET1),
    
    // Standard tablets
    VARROCK_TABLET("Varrock tablet", ItemID.VARROCK_TELEPORT),
    FALADOR_TABLET("Falador tablet", ItemID.FALADOR_TELEPORT),
    LUMBRIDGE_TABLET("Lumbridge tablet", ItemID.LUMBRIDGE_TELEPORT),
    CAMELOT_TABLET("Camelot tablet", ItemID.CAMELOT_TELEPORT),
    ARDOUGNE_TABLET("Ardougne tablet", ItemID.ARDOUGNE_TELEPORT),
    WATCHTOWER_TABLET("Watchtower tablet", ItemID.WATCHTOWER_TELEPORT),
    HOUSE_TABLET("House tablet", ItemID.TELEPORT_TO_HOUSE),// idk
    RIMMINGTON_TABLET("Rimmington tablet", ItemID.RIMMINGTON_TELEPORT),
    TAVERLEY_TABLET("Taverley tablet", ItemID.TAVERLEY_TELEPORT),
    POLLNIVNEACH_TABLET("Pollnivneach tablet", ItemID.POLLNIVNEACH_TELEPORT),
    RELLEKKA_TABLET("Rellekka tablet", ItemID.RELLEKKA_TELEPORT),
    BRIMHAVEN_TABLET("Brimhaven tablet", ItemID.BRIMHAVEN_TELEPORT),
    YANILLE_TABLET("Yanille tablet", ItemID.YANILLE_TELEPORT),
    TROLLHEIM_TABLET("Trollheim tablet", ItemID.TROLLHEIM_TELEPORT),
    HOSIDIUS_TABLET("Hosidius tablet", ItemID.HOSIDIUS_TELEPORT),
    
    // Ancient tablets
    PADDEWWA_TELEPORT_TABLET("Paddewwa teleport tablet", ItemID.PADDEWWA_TELEPORT),
    SENNTISTEN_TELEPORT_TABLET("Senntisten teleport tablet", ItemID.SENNTISTEN_TELEPORT),
    KHARYRLL_TELEPORT_TABLET("Kharyrll teleport tablet", ItemID.KHARYRLL_TELEPORT),
    LASSAR_TELEPORT_TABLET("Lassar teleport tablet", ItemID.LASSAR_TELEPORT),
    DAREEYAK_TELEPORT_TABLET("Dareeyak teleport tablet", ItemID.DAREEYAK_TELEPORT),
    CARRALLANGAR_TELEPORT_TABLET("Carrallangar teleport tablet", ItemID.CARRALLANGAR_TELEPORT),
    ANNAKARL_TELEPORT_TABLET("Annakarl teleport tablet", ItemID.ANNAKARL_TELEPORT),
    GHORROCK_TELEPORT_TABLET("Ghorrock teleport tablet", ItemID.GHORROCK_TELEPORT),
    
    // Lunar tablets
    MOONCLAN_TELEPORT_TABLET("Moonclan teleport tablet", ItemID.MOONCLAN_TELEPORT),
    OURANIA_TELEPORT_TABLET("Ourania teleport tablet", ItemID.OURANIA_TELEPORT),
    WATERBIRTH_TELEPORT_TABLET("Waterbirth teleport tablet", ItemID.WATERBIRTH_TELEPORT),
    BARBARIAN_TELEPORT_TABLET("Barbarian teleport tablet", ItemID.BARBARIAN_TELEPORT),
    KHAZARD_TELEPORT_TABLET("Khazard teleport tablet", ItemID.KHAZARD_TELEPORT),
    FISHING_GUILD_TELEPORT_TABLET("Fishing guild teleport tablet", ItemID.FISHING_GUILD_TELEPORT),
    CATHERBY_TELEPORT_TABLET("Catherby teleport tablet", ItemID.CATHERBY_TELEPORT),
    ICE_PLATEAU_TELEPORT_TABLET("Ice plateau teleport tablet", ItemID.ICE_PLATEAU_TELEPORT),
    
    // Arceuus tablets
    ARCEUUS_LIBRARY_TABLET("Arceuus Library tablet", ItemID.ARCEUUS_LIBRARY_TELEPORT),
    DRAYNOR_MANOR_TABLET("Draynor Manor tablet", ItemID.DRAYNOR_MANOR_TELEPORT),
    BATTLEFRONT_TABLET("Battlefront tablet", ItemID.BATTLEFRONT_TELEPORT),
    MIND_ALTAR_TABLET("Mind altar tablet", ItemID.MIND_ALTAR_TELEPORT),
    SALVE_GRAVEYARD_TABLET("Salve Graveyard tablet", ItemID.SALVE_GRAVEYARD_TELEPORT),
    FENKENSTRAINS_CASTLE_TABLET("Fenkenstrain’s Castle tablet", ItemID.FENKENSTRAINS_CASTLE_TELEPORT),
    WEST_ARDOUGNE_TABLET("West Ardougne tablet", ItemID.WEST_ARDOUGNE_TELEPORT),
    HARMONY_ISLAND_TABLET("Harmony Island tablet", ItemID.HARMONY_ISLAND_TELEPORT),
    CEMETERY_TABLET("Cemetery tablet", ItemID.CEMETERY_TELEPORT),
    BARROWS_TABLET("Barrows tablet", ItemID.BARROWS_TELEPORT),
    APE_ATOLL_TABLET("Ape Atoll tablet", ItemID.APE_ATOLL_TELEPORT),
    
    // Other 1-use teleport items
    TARGET_TELEPORT("Target teleport", ItemID.TARGET_TELEPORT),
    VOLCANIC_MINE_TELEPORT("Volcanic mine teleport", ItemID.VOLCANIC_MINE_TELEPORT),
    WILDERNESS_CRABS_TELEPORT("Wilderness crabs teleport", ItemID.WILDERNESS_CRABS_TELEPORT),
    DORGESHKAAN_SPHERE("Dorgesh-kaan sphere", ItemID.DORGESHKAAN_SPHERE),
    GOBLIN_VILLAGE_SPHERE("Goblin village sphere", ItemID.GOBLIN_VILLAGE_SPHERE),
    PLAIN_OF_MUD_SPHERE("Plain of mud sphere", ItemID.PLAIN_OF_MUD_SPHERE),
    GRAND_SEED_POD("Grand seed pod", ItemID.GRAND_SEED_POD),
    RUM_TROUBLE_BREWING("Rum (Trouble Brewing)", ItemID.RUM),
    
    // Teleport scrolls
    NARDAH_TELEPORT("Nardah teleport", ItemID.NARDAH_TELEPORT),
    DIGSITE_TELEPORT("Digsite teleport", ItemID.DIGSITE_TELEPORT),
    FELDIP_HILLS_TELEPORT("Feldip hills teleport", ItemID.FELDIP_HILLS_TELEPORT),
    LUNAR_ISLE_TELEPORT("Lunar isle teleport", ItemID.LUNAR_ISLE_TELEPORT),
    MORTTON_TELEPORT("Mort'ton teleport", ItemID.MORTTON_TELEPORT),
    PEST_CONTROL_TELEPORT("Pest control teleport", ItemID.PEST_CONTROL_TELEPORT),
    PISCATORIS_TELEPORT("Piscatoris teleport", ItemID.PISCATORIS_TELEPORT),
    TAI_BWO_WANNAI_TELEPORT("Tai bwo wannai teleport", ItemID.TAI_BWO_WANNAI_TELEPORT),
    IORWERTH_CAMP_TELEPORT("Iorwerth camp teleport", ItemID.IORWERTH_CAMP_TELEPORT),
    MOS_LEHARMLESS_TELEPORT("Mos le'harmless teleport", ItemID.MOS_LEHARMLESS_TELEPORT),
    LUMBERYARD_TELEPORT("Lumberyard teleport", ItemID.LUMBERYARD_TELEPORT),
    ZULANDRA_TELEPORT("Zul-andra teleport", ItemID.ZULANDRA_TELEPORT),
    KEY_MASTER_TELEPORT("Key master teleport", ItemID.KEY_MASTER_TELEPORT),
    REVENANT_CAVE_TELEPORT("Revenant cave teleport", ItemID.REVENANT_CAVE_TELEPORT),
    WATSON_TELEPORT("Watson teleport", ItemID.WATSON_TELEPORT),
    
    // Achievement diary items
    KARAMJA_GLOVES("Karamja gloves", ItemID.KARAMJA_GLOVES_4),
    ARDOUGNE_CLOAK("Ardougne cloak", ItemID.ARDOUGNE_CLOAK_4),
    DESERT_AMULET("Desert amulet", ItemID.DESERT_AMULET_4),
    MORYTANIA_LEGS("Morytania legs", ItemID.MORYTANIA_LEGS_4),
    FREMENNIK_SEA_BOOTS("Fremennik sea boots", ItemID.FREMENNIK_SEA_BOOTS_4),
    KANDARIN_HEADGEAR("Kandarin headgear", ItemID.KANDARIN_HEADGEAR_4),
    WILDERNESS_SWORD("Wilderness sword", ItemID.WILDERNESS_SWORD_4),
    WESTERN_BANNER("Western banner", ItemID.WESTERN_BANNER_4),
    EXPLORERS_RING("Explorer's ring", ItemID.EXPLORERS_RING_4),
    RADAS_BLESSING("Rada's blessing", ItemID.RADAS_BLESSING_4),
    
    // Skill capes
    CRAFTING_CAPE("Crafting cape", ItemID.CRAFTING_CAPET),
    CONSTRUCT_CAPE("Construct. cape", ItemID.CONSTRUCT_CAPET),
    FISHING_CAPE("Fishing cape", ItemID.FISHING_CAPET),
    FARMING_CAPE("Farming cape", ItemID.FARMING_CAPET),
    HUNTER_CAPE("Hunter cape", ItemID.HUNTER_CAPET),
    STRENGTH_CAPE("Strength cape", ItemID.STRENGTH_CAPET),
    MAX_CAPE("Max cape", ItemID.MAX_CAPE),
    QUEST_POINT_CAPE("Quest point cape", ItemID.QUEST_POINT_CAPE_T),
    MUSIC_CAPE("Music cape", ItemID.MUSIC_CAPET),
    ACHIEVEMENT_DIARY_CAPE("Achievement diary cape", ItemID.ACHIEVEMENT_DIARY_CAPE_T),
    
    //Quest-related items
    ECTOPHIAL("Ectophial", ItemID.ECTOPHIAL),
    TELEPORT_CRYSTAL("Teleport crystal", ItemID.TELEPORT_CRYSTAL),
    ETERNAL_TELEPORT_CRYSTAL("Eternal teleport crystal", ItemID.ETERNAL_TELEPORT_CRYSTAL),
    ROYAL_SEED_POD("Royal seed pod", ItemID.ROYAL_SEED_POD),
    ENCHANTED_LYRE("Enchanted lyre", ItemID.ENCHANTED_LYRE),
    CAMULET("Camulet", ItemID.CAMULET),
    KHAREDSTS_MEMOIRS("Kharedst's memoirs", ItemID.KHAREDSTS_MEMOIRS),
    BOOK_OF_THE_DEAD("Book of the dead", ItemID.BOOK_OF_THE_DEAD),
    DRAKANS_MEDALLION("Drakan's medallion", ItemID.DRAKANS_MEDALLION),
    MYTHICAL_CAPE("Mythical cape", ItemID.MYTHICAL_CAPE_22114),
    STONY_BASALT("Stony basalt", ItemID.STONY_BASALT),
    ICY_BASALT("Icy basalt", ItemID.ICY_BASALT),
    
    // Other items
    PHARAOHS_SCEPTRE("Pharaoh's sceptre", ItemID.PHARAOHS_SCEPTRE),
    SKULL_SCEPTRE("Skull sceptre", ItemID.SKULL_SCEPTRE),
    XERICS_TALISMAN("Xeric's talisman", ItemID.XERICS_TALISMAN),
    CHRONICLE("Chronicle", ItemID.CHRONICLE),
    RING_OF_THE_ELEMENTS("Ring of the elements", ItemID.RING_OF_THE_ELEMENTS_26818),
    AMULET_OF_THE_EYE("Amulet of the Eye", ItemID.AMULET_OF_THE_EYE);


    private final String name;
    private final int itemID;
}

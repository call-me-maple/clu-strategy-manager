package cluestrategymanager.transportation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.ItemID;

@Getter
@AllArgsConstructor
public enum Grouping
{
    BARBARIAN_ASSAULT("Barbarian Assault", ItemID.HEALER_HORN),
    BLAST_FURNACE("Blast Furnace", ItemID.GOLD_ORE),
    BURTHORPE_GAMES_ROOM("Burthorpe Games Room", ItemID.GAMES_ROOM),
    CASTLE_WARS("Castle Wars", ItemID.CASTLEWARS_CLOAK),
    CLAN_WARS("Clan Wars", ItemID.CLAN_WARS_CAPE),
    FISHING_TRAWLER("Fishing Trawler", ItemID.SMALL_FISHING_NET),
    GUARDIANS_OF_THE_RIFT("Guardians of the Rift", ItemID.CATALYTIC_TALISMAN),
    LAST_MAN_STANDING("Last Man Standing", ItemID.VICTORS_CAPE_1000),
    NIGHTMARE_ZONE("Nightmare Zone", ItemID.DREAM_POTION),
    PEST_CONTROL("Pest Control", ItemID.VOID_SEAL1),
    RAT_PITS("Rat Pits", ItemID.PET_CAT_1562),
    SHADES_OF_MORTTON("Shades of Mort'ton", ItemID.FIYR_REMAINS),
    SOUL_WARS("Soul Wars", ItemID.SOUL_CAPE),
    TITHE_FARM("Tithe Farm", ItemID.LOGAVANO_FRUIT),
    TROUBLE_BREWING("Trouble Brewing", ItemID.PIECES_OF_EIGHT),
    TZHAAR_FIGHT_PIT("TzHaar Fight Pit", ItemID.OBSIDIAN_CAPE);

    private final String name;
    private final int itemID;
}

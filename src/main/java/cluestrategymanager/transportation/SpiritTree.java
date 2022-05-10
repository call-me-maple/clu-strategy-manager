package cluestrategymanager.transportation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.ItemID;

@Getter
@AllArgsConstructor
public enum SpiritTree
{
    TREE_GNOME_VILLAGE("Tree Gnome Village", ItemID.SPIRIT_TREE_20635),
    GNOME_STRONGHOLD("Gnome Stronghold", ItemID.SPIRIT_TREE_20635),
    BATTLEFIELD_OF_KHAZARD("Battlefield of Khazard", ItemID.SPIRIT_TREE_20635),
    GRAND_EXCHANGE("Grand Exchange", ItemID.SPIRIT_TREE_20635),
    FELDIP_HILLS("Feldip Hills", ItemID.SPIRIT_TREE_20635),
    PRIFDDINAS("Prifddinas", ItemID.SPIRIT_TREE_20635),
    PORT_SARIM("Port Sarim", ItemID.SPIRIT_TREE_20635),
    ETCETERIA("Etceteria", ItemID.SPIRIT_TREE_20635),
    BRIMHAVEN("Brimhaven", ItemID.SPIRIT_TREE_20635),
    HOSIDIUS("Hosidius", ItemID.SPIRIT_TREE_20635),
    FARMING_GUILD("Farming Guild", ItemID.SPIRIT_TREE_20635),
    PLAYER_OWNED_HOUSE("Player-Owned House", ItemID.SPIRIT_TREE_20635);

    private final String name;
    private final int itemID;
}

package cluestrategymanager.transportation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.ItemID;
import net.runelite.api.SpriteID;

@Getter
@AllArgsConstructor
public enum TransportationMethod
{

    SPELLBOOK_TELEPORT("Spellbook Teleport", SpriteID.TAB_MAGIC, -1),
    GROUPING_TELEPORT("Grouping Teleport", 3344, -1),
    ITEM_TELEPORT("Item Teleport", SpriteID.TAB_INVENTORY, -1),
    MAP_TRANSPORTATION("Map Transportation", SpriteID.MAP_ICON_TRANSPORTATION, -1),
    PLAYER_OWNED_HOUSE("Player Owned House", SpriteID.MAP_ICON_HOUSE_PORTAL, -1),
    FAIRY_RING("Fairy Ring", -1, ItemID.FAIRY_RING),
    SPIRIT_TREE("Spirit Tree", -1, ItemID.SPIRIT_TREE_20635);

    private final String name;
    private final int spriteID;
    private final int itemID;
}

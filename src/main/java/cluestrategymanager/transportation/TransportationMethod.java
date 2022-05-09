package cluestrategymanager.transportation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.SpriteID;

@Getter
@AllArgsConstructor
public enum TransportationMethod
{

    SPELLBOOK_TELEPORT("Spellbook Teleport", SpriteID.TAB_MAGIC),
    GROUPING_TELEPORT("Grouping Teleport", 3344),
    ITEM_TELEPORT("Item Teleport", SpriteID.TAB_INVENTORY),
    MAP_TRANSPORTATION("Map Transportation", SpriteID.MAP_ICON_TRANSPORTATION),
    PLAYER_OWNED_HOUSE("Player Owned House", SpriteID.MAP_ICON_HOUSE_PORTAL);

    private final String name;
    private int spriteID;
}

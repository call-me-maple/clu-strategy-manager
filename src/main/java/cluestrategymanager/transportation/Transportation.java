package cluestrategymanager.transportation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.SpriteID;

@Getter
@AllArgsConstructor
public enum Transportation
{

    SPELLBOOK_TELEPORT("Spellbook Teleport", SpriteID.TAB_MAGIC, SpellbookTeleport.class),
    MINIGAME_TELEPORT("Minigame Teleport", SpriteID.MAP_ICON_MINIGAME, SpellbookTeleport.class),
    ITEM_TELEPORT("Item Teleport", SpriteID.TAB_INVENTORY, SpellbookTeleport.class),
    MAP_TRANSPORTATION("Map Transportation", SpriteID.MAP_ICON_TRANSPORTATION, SpellbookTeleport.class),
    PLAYER_OWNED_HOUSE("Player Owned House", SpriteID.MAP_ICON_HOUSE_PORTAL, SpellbookTeleport.class);

    private final String name;
    private int spriteID;
    private Class thing;
}

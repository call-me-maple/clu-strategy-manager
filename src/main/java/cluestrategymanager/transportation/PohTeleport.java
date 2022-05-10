package cluestrategymanager.transportation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.Item;
import net.runelite.api.ItemID;
import net.runelite.api.SpriteID;
import net.runelite.api.Varbits;

@Getter
@AllArgsConstructor
public enum PohTeleport
{
    NEXUS("Portal Nexus", ItemID.CRYSTALLINE_PORTAL_NEXUS),
    JEWELRY_BOX("Jewelry Box", ItemID.ORNATE_JEWELLERY_BOX),
    MOUNTED_GLORY("Mounted Amulet of Glory", ItemID.AMULET_OF_GLORY_8283),
    MOUNTED_MYTHS("Mounted Mythical cape", ItemID.MYTHICAL_CAPE),
    MOUNTED_XERICS("Mounted Xeric's Talisman", ItemID.MOUNTED_XERICS_TALISMAN),
    MOUNTED_DIGSITE("Mounted Digsite Pendant", ItemID.MOUNTED_DIGSITE_PENDANT),
    CAPE_HANGER("Cape Rack", ItemID.CAPE_HANGER),
    FAIRY_RING("Fairy Ring", ItemID.FAIRY_RING),
    SPIRIT_TREE("Spirit Tree", ItemID.SPIRIT_TREE_20635),
    OBELISK("Wilderness Obelisk", ItemID.OBELISK),
    PORTAL("Portal", 8330);

    private final String name;
    private final int itemID;
}
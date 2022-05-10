package cluestrategymanager.data.transportation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.ItemID;

@Getter
@AllArgsConstructor
public enum FairyRing
{
    AIQ("AIQ (Asgarnia: Mudskipper Point)", ItemID.FAIRY_RING),
    AIR("AIR (Islands: South-east of Ardougne)", ItemID.FAIRY_RING),
    AJQ("AJQ (Dungeons: Cave south of Dorgesh-Kaan)", ItemID.FAIRY_RING),
    AJR("AJR (Kandarin: Slayer cave south-east of Rellekka)", ItemID.FAIRY_RING),
    AJS("AJS (Islands: Penguins near Miscellania.)", ItemID.FAIRY_RING),
    AKP("AKP (Kharidian Desert: Necropolis)", ItemID.FAIRY_RING),
    AKQ("AKQ (Kandarin: Piscatoris Hunter area)", ItemID.FAIRY_RING),
    AKS("AKS (Feldip Hills: Feldip Hunter area)", ItemID.FAIRY_RING),
    ALP("ALP (Islands: Lighthouse)", ItemID.FAIRY_RING),
    ALQ("ALQ (Morytania: Haunted Woods east of Canifis)", ItemID.FAIRY_RING),
    ALR("ALR (Other Realms: Abyssal Area)", ItemID.FAIRY_RING),
    ALS("ALS (Kandarin: McGrubor's Wood)", ItemID.FAIRY_RING),
    BIP("BIP (Islands: South-west of Mort Myre)", ItemID.FAIRY_RING),
    BIQ("BIQ (Kharidian Desert near Kalphite Hive.)", ItemID.FAIRY_RING),
    BIS("BIS (Kandarin: Ardougne Zoo - Unicorns)", ItemID.FAIRY_RING),
    BJR("BJR (Other Realms: Realm of the Fisher King)", ItemID.FAIRY_RING),
    BJS("BJS (Islands: Near Zul-Andra)", ItemID.FAIRY_RING),
    BKP("BKP (Feldip Hills: South of Castle Wars)", ItemID.FAIRY_RING),
    BKQ("BKQ (Other Realms: Enchanted Valley)", ItemID.FAIRY_RING),
    BKR("BKR (Morytania: Mort Myre Swamp, south of Canifis)", ItemID.FAIRY_RING),
    BKS("BKS (Other Realms: Zanaris)", ItemID.FAIRY_RING),
    BLP("BLP (Dungeons: TzHaar area)", ItemID.FAIRY_RING),
    BLR("BLR (Kandarin: Legends' Guild)", ItemID.FAIRY_RING),
    BLQ("BLQ (Other Realms: Yu'biusk)", ItemID.FAIRY_RING),
    CIP("CIP (Islands: Miscellania)", ItemID.FAIRY_RING),
    CIQ("CIQ (Kandarin: North-west of Yanille)", ItemID.FAIRY_RING),
    CIR("CIR (Kebos Lowlands: South of Mount Karuulm)", ItemID.FAIRY_RING),
    CIS("CIS (Great Kourend: Arceuus Library)", ItemID.FAIRY_RING),
    CJR("CJR (Kandarin: Sinclair Mansion (east))", ItemID.FAIRY_RING),
    CKP("CKP (Other Realms: Cosmic entity's plane)", ItemID.FAIRY_RING),
    CKR("CKR (Karamja: South of Tai Bwo Wannai Village)", ItemID.FAIRY_RING),
    CKS("CKS (Morytania: Canifis)", ItemID.FAIRY_RING),
    CLP("CLP (Islands: South of Draynor Village)", ItemID.FAIRY_RING),
    CLR("CLR (Islands: Ape Atoll)", ItemID.FAIRY_RING),
    CLS("CLS (Islands: Hazelmere's home)", ItemID.FAIRY_RING),
    DIP("DIP (Other Realms: Abyssal Nexus)", ItemID.FAIRY_RING),
    DIQ("DIQ (Player-owned house Superior Garden)", ItemID.FAIRY_RING),
    DIR("DIR (Other Realms: Gorak's Plane)", ItemID.FAIRY_RING),
    DIS("DIS (Misthalin: Wizards' Tower)", ItemID.FAIRY_RING),
    DJP("DJP (Kandarin: Tower of Life)", ItemID.FAIRY_RING),
    DJR("DJR (Great Kourend: Chasm of Fire)", ItemID.FAIRY_RING),
    DKP("DKP (Karamja: Gnome Glider)", ItemID.FAIRY_RING),
    DKR("DKR (Misthalin: Edgeville)", ItemID.FAIRY_RING),
    DKS("DKS (Fremennik: Polar Hunter area)", ItemID.FAIRY_RING),
    DLQ("DLQ (Kharidian Desert: North of Nardah)", ItemID.FAIRY_RING),
    DLR("DLR (Islands: Poison Waste south of Isafdar)", ItemID.FAIRY_RING),
    DLS("DLS (Dungeons: Myreque hideout under The Hollows)", ItemID.FAIRY_RING);

    private final String name;
    private final int itemID;

    @Override
    public String toString()
    {
        return this.name;
    }
}

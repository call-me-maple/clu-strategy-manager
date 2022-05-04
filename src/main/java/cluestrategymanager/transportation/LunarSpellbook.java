package cluestrategymanager.transportation;

import lombok.Getter;

public enum LunarSpellbook
{
    HOME(new SpellbookTeleport("Lunar Home Teleport")),
    MOONCLAN(new SpellbookTeleport("Moonclan Teleport")),
    OURANIA(new SpellbookTeleport("Ourania Teleport")),
    WATERBIRTH(new SpellbookTeleport("Waterbirth Teleport")),
    BARBARIAN(new SpellbookTeleport("Barbarian Teleport")),
    KHAZARD(new SpellbookTeleport("Khazard Teleport")),
    FISHING_GUILD(new SpellbookTeleport("Fishing Guild Teleport")),
    CATHERBY(new SpellbookTeleport("Catherby Teleport")),
    ICE_PLATEAU(new SpellbookTeleport("Ice Plateau Teleport"));

    @Getter
    private final SpellbookTeleport teleport;

    LunarSpellbook(SpellbookTeleport teleport)
    {
        this.teleport = teleport;
    }

    public static SpellbookTeleport[] TELEPORTS = {
            HOME.getTeleport(), MOONCLAN.getTeleport(), OURANIA.getTeleport(),
            WATERBIRTH.getTeleport(), BARBARIAN.getTeleport(), KHAZARD.getTeleport(),
            FISHING_GUILD.getTeleport(), CATHERBY.getTeleport(), ICE_PLATEAU.getTeleport()};
}


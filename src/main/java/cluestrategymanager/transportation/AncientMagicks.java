package cluestrategymanager.transportation;

import lombok.Getter;

public enum AncientMagicks
{
    HOME(new SpellbookTeleport("Edgeville Home Teleport")),
    PADDEWWA(new SpellbookTeleport("Paddewwa Teleport")),
    SENNTISTEN(new SpellbookTeleport("Senntisten Teleport")),
    KHARYRLL(new SpellbookTeleport("Kharyrll Teleport")),
    LASSAR(new SpellbookTeleport("Lassar Teleport")),
    DAREEYAK(new SpellbookTeleport("Dareeyak Teleport")),
    CARRALLANGAR(new SpellbookTeleport("Carrallangar Teleport")),
    ANNAKARL(new SpellbookTeleport("Annakarl Teleport")),
    GHORROCK(new SpellbookTeleport("Ghorrock Teleport"));

    @Getter
    private final SpellbookTeleport teleport;

    AncientMagicks(SpellbookTeleport teleport)
    {
        this.teleport = teleport;
    }

    public static SpellbookTeleport[] TELEPORTS = {
            HOME.getTeleport(), PADDEWWA.getTeleport(), SENNTISTEN.getTeleport(),
            KHARYRLL.getTeleport(), LASSAR.getTeleport(), DAREEYAK.getTeleport(),
            CARRALLANGAR.getTeleport(), ANNAKARL.getTeleport(), GHORROCK.getTeleport()};
}

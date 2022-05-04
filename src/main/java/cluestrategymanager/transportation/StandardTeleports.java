package cluestrategymanager.transportation;

import lombok.AllArgsConstructor;
import lombok.Getter;

public enum StandardTeleports
{
    HOME(new SpellbookTeleport("Lumbridge Home Teleport")),
    VARROCK(new SpellbookTeleport("Varrock Teleport")),
    LUMBRIDGE(new SpellbookTeleport("Lumbridge Teleport")),
    FALADOR(new SpellbookTeleport("Falador Teleport")),
    HOUSE(new SpellbookTeleport("Teleport to House")),
    CAMELOT(new SpellbookTeleport("Camelot Teleport")),
    ARDOUGNE(new SpellbookTeleport("Ardougne Teleport")),
    WATCHTOWER(new SpellbookTeleport("Watchtower Teleport")),
    TROLLHEIM(new SpellbookTeleport("Trollheim Teleport")),
    APE_ATOLL(new SpellbookTeleport("Ape Atoll Teleport")),
    KOUREND_CASTLE(new SpellbookTeleport("Kourend Castle Teleport"));

    @Getter
    private final SpellbookTeleport teleport;

    StandardTeleports(SpellbookTeleport teleport)
    {
        this.teleport = teleport;
    }

    public static SpellbookTeleport[] TELEPORTS = {
            HOME.getTeleport(), VARROCK.getTeleport(), LUMBRIDGE.getTeleport(),
            FALADOR.getTeleport(), HOUSE.getTeleport(), CAMELOT.getTeleport(),
            ARDOUGNE.getTeleport(), WATCHTOWER.getTeleport(), TROLLHEIM.getTeleport(),
            APE_ATOLL.getTeleport(), KOUREND_CASTLE.getTeleport()};
}

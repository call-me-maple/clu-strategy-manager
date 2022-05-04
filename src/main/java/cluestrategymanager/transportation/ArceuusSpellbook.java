package cluestrategymanager.transportation;

import lombok.Getter;

public enum ArceuusSpellbook
{
    HOME(new SpellbookTeleport("Arceuus Home Teleport")),
    LIBRARY(new SpellbookTeleport("Arceuus Library Teleport")),
    DRAYNOR_MANOR(new SpellbookTeleport("Draynor Manor Teleport")),
    BATTLEFRONT(new SpellbookTeleport("Battlefront Teleport")),
    MIND_ALTER(new SpellbookTeleport("Mind Altar Teleport")),
    RESPAWN(new SpellbookTeleport("Respawn Teleport")),
    SALVE_GRAVEYARD(new SpellbookTeleport("Salve Graveyard Teleport")),
    FENKENSTRAINS_CASTLE(new SpellbookTeleport("Fenkenstrain's Castle Teleport")),
    WEST_ARDOUGNE(new SpellbookTeleport("West Ardougne Teleport")),
    HARMONY_ISLAND(new SpellbookTeleport("Harmony Island Teleport")),
    CEMETERY(new SpellbookTeleport("Cemetery Teleport")),
    BARROWS(new SpellbookTeleport("Barrows Teleport")),
    APE_ATOLL(new SpellbookTeleport("Ape Atoll Teleport"));

    @Getter
    private final SpellbookTeleport teleport;

    ArceuusSpellbook(SpellbookTeleport teleport)
    {
        this.teleport = teleport;
    }

    public static SpellbookTeleport[] TELEPORTS = {
            HOME.getTeleport(), LIBRARY.getTeleport(), DRAYNOR_MANOR.getTeleport(),
            BATTLEFRONT.getTeleport(), MIND_ALTER.getTeleport(), RESPAWN.getTeleport(),
            SALVE_GRAVEYARD.getTeleport(), FENKENSTRAINS_CASTLE.getTeleport(), WEST_ARDOUGNE.getTeleport(),
            HARMONY_ISLAND.getTeleport(), CEMETERY.getTeleport(), BARROWS.getTeleport(), APE_ATOLL.getTeleport()};
}

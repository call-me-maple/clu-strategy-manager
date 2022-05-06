package cluestrategymanager.ui;

import cluestrategymanager.ClueTier;
import cluestrategymanager.clues.Clue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.ItemID;

@RequiredArgsConstructor
@Getter
public enum Tab
{
    BEGINNER("Beginner Clues", ItemID.CLUE_SCROLL_BEGINNER, ClueTier.BEGINNER),
    EASY("Easy Clues", ItemID.CLUE_SCROLL_EASY, ClueTier.EASY),
    MEDIUM("Medium Clues", ItemID.CLUE_SCROLL_MEDIUM, ClueTier.MEDIUM),
    HARD("Hard Clues", ItemID.CLUE_SCROLL_HARD, ClueTier.HARD),
    ELITE("Elite Clues", ItemID.CLUE_SCROLL_ELITE, ClueTier.ELITE),
    MASTER("Master Clues", ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER);

    public static final Tab[] CLUE_TABS = {BEGINNER, EASY, MEDIUM, HARD, ELITE, MASTER};

    private final String name;
    private final int itemID;
    private final ClueTier clueTier;
}
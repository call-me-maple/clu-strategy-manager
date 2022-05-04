package cluestrategymanager.ui;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.ItemID;

@RequiredArgsConstructor
@Getter
public enum Tab
{
    BEGINNER("Beginner Clues", ItemID.CLUE_SCROLL_BEGINNER),
    EASY("Easy Clues", ItemID.CLUE_SCROLL_EASY),
    MEDIUM("Medium Clues", ItemID.CLUE_SCROLL_MEDIUM),
    HARD("Hard Clues", ItemID.CLUE_SCROLL_HARD),
    ELITE("Elite Clues", ItemID.CLUE_SCROLL_ELITE),
    MASTER("Master Clues", ItemID.CLUE_SCROLL_MASTER);

    public static final Tab[] CLUE_TABS = {BEGINNER, EASY, MEDIUM, HARD, ELITE, MASTER};

    private final String name;
    private final int itemID;
}
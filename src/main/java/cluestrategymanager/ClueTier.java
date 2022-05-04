package cluestrategymanager;

import cluestrategymanager.clues.*;
import cluestrategymanager.ui.Tab;
import com.google.common.collect.ImmutableList;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
public enum ClueTier
{
    BEGINNER("Beginner Clue", Tab.BEGINNER),
    EASY("Easy Clue", Tab.EASY),
    MEDIUM("Medium Clue", Tab.MEDIUM),
    HARD("Hard Clue", Tab.HARD),
    ELITE("Elite Clue", Tab.ELITE),
    MASTER("Master Clue", Tab.MASTER);

    @Getter
    private final String name;
    @Getter
    private final Tab tab;

    public static final ClueTier[] CLUE_TIERS = {BEGINNER, EASY, MEDIUM, HARD, ELITE, MASTER};
}

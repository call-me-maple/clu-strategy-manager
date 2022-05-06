package cluestrategymanager;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ClueTier
{
    BEGINNER("Beginner Clue"),
    EASY("Easy Clue"),
    MEDIUM("Medium Clue"),
    HARD("Hard Clue"),
    ELITE("Elite Clue"),
    MASTER("Master Clue");

    @Getter
    private final String name;
}

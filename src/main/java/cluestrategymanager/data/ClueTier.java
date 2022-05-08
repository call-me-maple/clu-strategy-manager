package cluestrategymanager.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ClueTier
{
    BEGINNER("Beginner Clue"),
    EASY("Easy Clue"),
    MEDIUM("Medium Clue"),
    HARD("Hard Clue"),
    ELITE("Elite Clue"),
    MASTER("Master Clue");

    private final String name;
}

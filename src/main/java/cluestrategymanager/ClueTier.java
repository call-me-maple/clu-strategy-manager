package cluestrategymanager;

import cluestrategymanager.clues.*;
import cluestrategymanager.ui.Tab;
import com.google.common.collect.ImmutableList;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

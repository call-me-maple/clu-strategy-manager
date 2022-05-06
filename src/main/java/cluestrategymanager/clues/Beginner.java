package cluestrategymanager.clues;

import cluestrategymanager.ClueTier;
import com.google.common.collect.ImmutableList;

import java.util.List;

public class Beginner
{
    public static final List<Clue> CLUES = ImmutableList.of(
            new Clue("An Earl", ClueTier.BEGINNER),
            new Clue("Carpet Ahoy", ClueTier.BEGINNER)
    );
}

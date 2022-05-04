package cluestrategymanager.clues;

import cluestrategymanager.ClueTier;
import cluestrategymanager.ui.Tab;
import com.google.common.collect.ImmutableList;
import lombok.Getter;

import java.util.List;

public class Beginner extends Clue
{
    @Getter
    private static final List<Clue> clues = ImmutableList.of(
            new Clue("An Earl", ClueTier.BEGINNER),
            new Clue("Carpet Ahoy", ClueTier.BEGINNER)
    );

    public Beginner(String clueText)
    {
        super(clueText, ClueTier.BEGINNER);
    }
}

package cluestrategymanager.clues;

import cluestrategymanager.ClueTier;
import com.google.common.collect.ImmutableList;
import lombok.Getter;

import java.util.List;

public class Easy extends Clue
{
    @Getter
    private static final List<Clue> clues = ImmutableList.of(
            new Clue("Easy place holder step", ClueTier.EASY),
            new Clue("Easy place holder step number 2", ClueTier.EASY)
    );

    public Easy(String clueText)
    {
        super(clueText, ClueTier.EASY);
    }
}

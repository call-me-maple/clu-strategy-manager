package cluestrategymanager.clues;

import cluestrategymanager.ClueTier;
import com.google.common.collect.ImmutableList;
import lombok.Getter;

import java.util.List;

public class Hard extends Clue
{
    @Getter
    private static final List<Clue> clues = ImmutableList.of(
            new Clue("Hard place holder step", ClueTier.HARD)
    );
    public Hard(String clueText)
    {
        super(clueText, ClueTier.HARD);
    }
}

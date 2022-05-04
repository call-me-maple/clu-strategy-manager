package cluestrategymanager.clues;

import cluestrategymanager.ClueTier;
import com.google.common.collect.ImmutableList;
import lombok.Getter;

import java.util.List;

public class Elite extends Clue
{
    @Getter
    private static final List<Clue> clues = ImmutableList.of(
            new Clue("Elite place holder step", ClueTier.ELITE)
    );

    public Elite(String clueText)
    {
        super(clueText, ClueTier.ELITE);
    }
}

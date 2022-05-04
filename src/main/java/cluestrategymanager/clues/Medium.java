package cluestrategymanager.clues;

import cluestrategymanager.ClueTier;
import com.google.common.collect.ImmutableList;
import lombok.Getter;

import java.util.List;

public class Medium extends Clue
{
    @Getter
    private static final List<Clue> clues = ImmutableList.of(
            new Clue("Medium place holder step", ClueTier.MEDIUM)
    );
    public Medium(String clueText)
    {
        super(clueText, ClueTier.MEDIUM);
    }
}

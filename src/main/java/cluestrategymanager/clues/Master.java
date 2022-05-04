package cluestrategymanager.clues;

import cluestrategymanager.ClueTier;
import com.google.common.collect.ImmutableList;
import lombok.Getter;

import java.util.List;

public class Master extends Clue
{
    @Getter
    private static final List<Clue> clues = ImmutableList.of(
            new Clue("Master place holder step", ClueTier.MASTER)
    );
    public Master(String clueText)
    {
        super(clueText, ClueTier.MASTER);
    }
}

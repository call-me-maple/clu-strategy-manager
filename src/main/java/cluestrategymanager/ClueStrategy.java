package cluestrategymanager;

import cluestrategymanager.clues.Clue;
import cluestrategymanager.transportation.Transportation;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.ItemID;

import java.util.List;

public class ClueStrategy
{
    @Getter
    private Clue clue;

    @Getter
    @Setter
    private String hintText;

    @Getter
    @Setter
    private Transportation transportation;

    @Getter
    @Setter
    private boolean completable;

    @Getter
    @Setter
    private List<ItemID> requiredItems;

    public ClueStrategy(Clue clue)
    {
        this.clue = clue;
        this.hintText = "";
        this.transportation = null;
        this.completable = true;
    }

    @Override
    public String toString()
    {
        return "strategy: " + clue.toString() + " hint: " + hintText + " completable: " + completable;
    }
}

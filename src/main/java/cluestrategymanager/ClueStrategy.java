package cluestrategymanager;

import cluestrategymanager.data.clue.Step;
import cluestrategymanager.data.transportation.Transportation;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.ItemID;

import java.util.List;

public class ClueStrategy
{
    @Getter
    private Step step;

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

    public ClueStrategy(Step step)
    {
        this.step = step;
        this.hintText = "";
        this.transportation = null;
        this.completable = true;
    }

    @Override
    public String toString()
    {
        return "strategy: " + step.toString() + " hint: " + hintText + " completable: " + completable;
    }
}

package cluestrategymanager.data;

import cluestrategymanager.ClueTier;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSortedSet;
import lombok.Getter;

public enum Step
{
    // Beginner Steps
    BEG_AN_EARL("An Earl", ClueTier.BEGINNER),
    BEG_CARPET_AHOY("Carpet Ahoy", ClueTier.BEGINNER),

    // Easy Steps
    EASY_PLACEHOLDER_1("Easy place holder step", ClueTier.EASY),
    EASY_PLACEHOLDER_2("Easy place holder step number 2", ClueTier.EASY),

    // Medium Steps
    MED_PLACEHOLDER_1("Medium place holder step", ClueTier.MEDIUM),
    MED_PLACEHOLDER_2("Medium place holder step number 2", ClueTier.MEDIUM),

    // Hard Steps
    HARD_PLACEHOLDER_1("Hard place holder step", ClueTier.HARD),

    // Elite Steps
    ELITE_PLACEHOLDER_1("Elite place holder step", ClueTier.ELITE),

    // Master Steps
    MASTER_PLACEHOLDER_1("Master place holder step", ClueTier.MASTER);

    @Getter
    private final String text;

    @Getter
    private final ClueTier tier;

    public static final ImmutableMultimap<ClueTier, Step> CLUE_MAP;
    public static final ImmutableSortedSet<ClueTier> CLUE_TIERS;
    static
    {
        final ImmutableMultimap.Builder<ClueTier, Step> map = ImmutableMultimap.builder();
        final ImmutableSortedSet.Builder<ClueTier> set = ImmutableSortedSet.naturalOrder();
        for (final Step step : values())
        {
            map.put(step.getTier(), step);
            set.add(step.getTier());
        }
        CLUE_MAP = map.build();
        CLUE_TIERS = set.build();
    }

    Step(String text, ClueTier tier)
    {
        this.text = text;
        this.tier = tier;
    }
}

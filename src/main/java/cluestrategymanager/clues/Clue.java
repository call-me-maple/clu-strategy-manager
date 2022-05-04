package cluestrategymanager.clues;

import cluestrategymanager.ClueTier;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Clue
{
    @Getter
    private final String clueText;

    @Getter
    private final ClueTier clueTier;

    @Override
    public String toString()
    {
        return clueTier.name() + ": " + clueText;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((clueText == null) ? 0 : clueText.hashCode())
                + ((clueTier == null) ? 0 : clueTier.hashCode());
        return result;
    }

    // TODO learn to compare stuff
    // MAYBE need to do in clueteir toooo???
    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        final Clue other = (Clue) obj;

        if (clueTier != other.clueTier)
        {
            return false;
        }

        if (clueText == null)
        {
            return other.clueText == null;
        }
        else
        {
            return clueText.equals(other.clueText);
        }
    }
}

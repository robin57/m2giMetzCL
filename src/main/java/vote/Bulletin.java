package vote;

import com.google.common.collect.ImmutableSet;
import info.gehrels.voting.Ballot;
import info.gehrels.voting.Vote;


/**
 * Created by schuma on 29/12/16.
 *
 */
public class Bulletin {
    private Ballot<Candidat> ballot;

    public Bulletin(Vote<Candidat> vote, int numBulletin) {
        this.ballot = new Ballot<>(numBulletin, ImmutableSet.of(vote));
    }

    public Ballot<Candidat> getBallot() {
        return ballot;
    }
}

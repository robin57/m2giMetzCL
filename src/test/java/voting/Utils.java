package voting;

import com.google.common.collect.ImmutableSet;
import info.gehrels.voting.Election;
import voting.election.Candidat;

/**
 * Created by schuma on 20/03/17.
 *
 */
public class Utils {
    public static Election<VoteChoice> getAnElection(){
        return new Election("Test", ImmutableSet.of(
                new Candidat("Bilbo"),
                new Candidat("Frodo")));
    }
}

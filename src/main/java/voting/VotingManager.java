package voting;

import com.google.common.collect.ImmutableSet;
import info.gehrels.voting.Election;
import info.gehrels.voting.Vote;

import java.util.List;

/**
 * Created by schuma on 29/12/16.
 *
 */
public class VotingManager {
    private int bulletinId = 1;
    private final Election election;

    public VotingManager(Election<VoteChoice> election) {
        this.election = election;
    }

    public Bulletin voter(List<VoteChoice> liste){
        return new Bulletin(Vote.createPreferenceVote(election, ImmutableSet.copyOf(liste)), bulletinId++);
    }


    public Bulletin voterBlanc(){
        return new Bulletin(Vote.createNoVote(election), bulletinId++);
    }
}

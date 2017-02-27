package voting;

import com.google.common.collect.ImmutableSet;
import info.gehrels.voting.AmbiguityResolver;
import info.gehrels.voting.Ballot;
import info.gehrels.voting.Election;
import info.gehrels.voting.NotMoreThanTheAllowedNumberOfCandidatesCanReachItQuorum;
import info.gehrels.voting.singleTransferableVote.STVElectionCalculation;
import info.gehrels.voting.singleTransferableVote.STVElectionCalculationFactory;
import info.gehrels.voting.singleTransferableVote.STVElectionCalculationListener;
import info.gehrels.voting.singleTransferableVote.StringBuilderBackedSTVElectionCalculationListener;
import org.apache.commons.math3.fraction.BigFraction;

import java.util.List;

/**
 * Created by schuma on 27/02/17.
 *
 */
public abstract class VoteManager {
    protected boolean ouvert = true;
    protected int nombreDeChoixAElire;

    protected final VotingManager votingManager;

    protected final Election<VoteChoice> election;
    protected final ImmutableSet<VoteChoice> candidats;

    protected ImmutableSet.Builder<Ballot<VoteChoice>> bulletinsTemp;


    /**
     *Constructor
     *
     * @param name nom du vote
     * @param candidats les candidats
     * @param nombreDeChoixAElire nombre de case à cocher
     */
    protected VoteManager(String name, List<VoteChoice> candidats, int nombreDeChoixAElire) {
        this.nombreDeChoixAElire = nombreDeChoixAElire;

        this.candidats = ImmutableSet.copyOf(candidats);
        this.election = new Election<>(name, this.candidats);

        this.votingManager = new VotingManager(this.election);

        bulletinsTemp = new ImmutableSet.Builder<>();
    }


    public void voterBlanc(){
        if (ouvert) {
            Bulletin bulletin = votingManager.voterBlanc();
            bulletinsTemp.add(bulletin.getBallot());
        }
    }

    /**
     *
     * @param liste
     */
    public void voter(List<VoteChoice> liste){
        if (ouvert) {
            Bulletin bulletin = votingManager.voter(liste);
            bulletinsTemp.add(bulletin.getBallot());
        }
    }

    /**
     *
     * @return Election
     */
    public Election<VoteChoice> getElection() {
        return election;
    }

    /**
     * Close an election
     */
    public void fermerElection(){
        ouvert = false;
    }

    public ImmutableSet<VoteChoice> getResultats(){
        if( !ouvert ) {
            STVElectionCalculation<VoteChoice> calculateurResultats = factory.createElectionCalculation(election, this.construireBulletins());
            return calculateurResultats.calculate(candidats, nombreDeChoixAElire);
        }

        return null;
    }

    private ImmutableSet<Ballot<VoteChoice>> construireBulletins(){
        return bulletinsTemp.build();
    }

    /**
     *
     * @return les candidats
     */
    public ImmutableSet<VoteChoice> getCandidates() {
        return this.candidats;
    }




    // ??????
    public static final class JustTakeTheFirstOneAmbiguityResolver<T extends VoteChoice> implements AmbiguityResolver<T> {
        @Override
        public AmbiguityResolverResult<T> chooseOneOfMany(ImmutableSet<T> bestCandidates) {
            return new AmbiguityResolverResult<>(bestCandidates.iterator().next(),
                    "Habe ganz primitiv das erste Element der Menge genommen");
        }

    }

    //je ne sais pas a quoi ce sert
    NotMoreThanTheAllowedNumberOfCandidatesCanReachItQuorum QUORUM =
            new NotMoreThanTheAllowedNumberOfCandidatesCanReachItQuorum(new BigFraction(1, 1000));
    AmbiguityResolver<VoteChoice> AMBIGUITY = new JustTakeTheFirstOneAmbiguityResolver<>();


    // Préparation résultat
    StringBuilder stringBuilder = new StringBuilder();
    STVElectionCalculationListener<VoteChoice> listener =
            new StringBuilderBackedSTVElectionCalculationListener<>(stringBuilder);

    STVElectionCalculationFactory<VoteChoice> factory = new STVElectionCalculationFactory<>(QUORUM,
            listener,
            AMBIGUITY);

}

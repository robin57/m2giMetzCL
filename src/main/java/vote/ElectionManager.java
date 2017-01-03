package vote;

import com.google.common.collect.ImmutableSet;
import info.gehrels.voting.*;
import info.gehrels.voting.singleTransferableVote.STVElectionCalculation;
import info.gehrels.voting.singleTransferableVote.STVElectionCalculationFactory;
import info.gehrels.voting.singleTransferableVote.STVElectionCalculationListener;
import info.gehrels.voting.singleTransferableVote.StringBuilderBackedSTVElectionCalculationListener;
import org.apache.commons.math3.fraction.BigFraction;

import java.util.List;

/**
 * Created by schuma on 29/12/16.
 *
 */
public class ElectionManager {

    // ??????
    public static final class JustTakeTheFirstOneAmbiguityResolver<T extends Candidat> implements AmbiguityResolver<T> {
        @Override
        public AmbiguityResolverResult<T> chooseOneOfMany(ImmutableSet<T> bestCandidates) {
            return new AmbiguityResolverResult<>(bestCandidates.iterator().next(),
                    "Habe ganz primitiv das erste Element der Menge genommen");
        }

    }

    //je ne sais pas a quoi ce sert
    NotMoreThanTheAllowedNumberOfCandidatesCanReachItQuorum QUORUM =
            new NotMoreThanTheAllowedNumberOfCandidatesCanReachItQuorum(new BigFraction(1, 1000));
    AmbiguityResolver<Candidat> AMBIGUITY = new JustTakeTheFirstOneAmbiguityResolver<>();


    // Préparation résultat
    StringBuilder stringBuilder = new StringBuilder();
    STVElectionCalculationListener<Candidat> listener =
            new StringBuilderBackedSTVElectionCalculationListener<>(stringBuilder);

    STVElectionCalculationFactory<Candidat> factory = new STVElectionCalculationFactory<>(QUORUM,
            listener,
            AMBIGUITY);



    private boolean ouvert = true;

    private int nombreDePersonneAElire;

    private final Election<Candidat> election;
    private final ImmutableSet<Candidat> candidats;
    private ImmutableSet.Builder<Ballot<Candidat>> bulletinsTemp;

    private final VoteManager voteManager;


    /**
     * Constructeur
     *
     * @param name nom
     * @param candidats liste des candidats
     * @param nbPersonnesAElire le nombre de candidats à élire
     */
    public ElectionManager(String name, List<Candidat> candidats, int nbPersonnesAElire) {
        this.candidats = ImmutableSet.copyOf(candidats);
        this.election = new Election<>(name, this.candidats);

        nombreDePersonneAElire = nbPersonnesAElire;
        bulletinsTemp = new ImmutableSet.Builder<>();

        this.voteManager = new VoteManager(this.election);
    }


    public void voterBlanc(){
        if (ouvert) {
            Bulletin bulletin = voteManager.voterBlanc();
            bulletinsTemp.add(bulletin.getBallot());
        }
    }

    /**
     *
     * @param liste
     */
    public void voter(List<Candidat> liste){
        if (ouvert) {
            Bulletin bulletin = voteManager.voter(liste);
            bulletinsTemp.add(bulletin.getBallot());
        }
    }

    /**
     *
     * @return Election
     */
    public Election<Candidat> getElection() {
        return election;
    }

    /**
     *
     * @return les candidats
     */
    public ImmutableSet<Candidat> getCandidates() {
        return this.candidats;
    }


    public void fermerElection(){
        ouvert = false;
    }

    public ImmutableSet<Candidat> getResultats(){
        if( !ouvert ) {
            STVElectionCalculation<Candidat> calculateurResultats = factory.createElectionCalculation(election, this.construireBulletins());
            return calculateurResultats.calculate(candidats, nombreDePersonneAElire);
        }

        return null;
    }


    private ImmutableSet<Ballot<Candidat>> construireBulletins(){
        return bulletinsTemp.build();
    }
}

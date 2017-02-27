package voting.election;

import com.google.common.collect.ImmutableSet;
import info.gehrels.voting.*;
import info.gehrels.voting.singleTransferableVote.STVElectionCalculation;
import info.gehrels.voting.singleTransferableVote.STVElectionCalculationFactory;
import info.gehrels.voting.singleTransferableVote.STVElectionCalculationListener;
import info.gehrels.voting.singleTransferableVote.StringBuilderBackedSTVElectionCalculationListener;
import org.apache.commons.math3.fraction.BigFraction;
import voting.Bulletin;
import voting.VoteChoice;
import voting.VoteManager;

import java.util.List;

/**
 * Created by schuma on 29/12/16.
 *
 */
public class ElectionManager extends VoteManager {

    /**
     * Constructeur
     *
     * @param name nom
     * @param candidats liste des candidats
     * @param nbPersonnesAElire le nombre de candidats à élire
     */
    public ElectionManager(String name, List<VoteChoice> candidats, int nbPersonnesAElire) {
        super(name, candidats, nbPersonnesAElire);
    }

}

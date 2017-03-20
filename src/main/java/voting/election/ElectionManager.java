package voting.election;

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

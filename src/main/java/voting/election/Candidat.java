package voting.election;

import voting.VoteChoice;

/**
 * Created by schuma on 24/12/16.
 *
 */
public class Candidat extends VoteChoice {

    public Candidat(String name) {
        super(name);
    }


    @Override
    public String toString() {
        return name;
    }
}

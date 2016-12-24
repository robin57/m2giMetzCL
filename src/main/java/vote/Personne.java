package vote;

import info.gehrels.voting.Candidate;

/**
 * Created by schuma on 24/12/16.
 *
 */
public class Personne extends Candidate {

    public Personne(String name) {
        super(name);
    }


    @Override
    public String toString() {
        return name;
    }
}

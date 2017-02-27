package voting.survey;

import voting.VoteChoice;

/**
 * Created by schuma on 27/02/17.
 *
 */
public class Choice extends VoteChoice {
    public Choice(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return name;
    }
}

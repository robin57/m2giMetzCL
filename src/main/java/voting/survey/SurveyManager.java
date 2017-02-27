package voting.survey;

import voting.VoteChoice;
import voting.VoteManager;

import java.util.List;

/**
 * Created by schuma on 27/02/17.
 *
 */
public class SurveyManager extends VoteManager {
    private final String subject;

    public SurveyManager(String subject, List<VoteChoice> choices, int nbChoices) {
        super("vide", choices, nbChoices);

        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }
}

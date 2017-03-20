package voting.survey;

import com.google.common.collect.ImmutableSet;
import voting.VoteChoice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by schuma on 27/02/17.
 *
 */
public class TestSurvey {

    public static void main(String[] args) {
        SurveyManager sondage;

        String sujet = "Où pensez-vous partir en vacances ?";

        Choice c1 = new Choice("Florence");
        Choice c2 = new Choice("Rome");
        Choice c3 = new Choice("Paris");
        Choice c4 = new Choice("Londres");
        Choice c5 = new Choice("Madrid");

        List<VoteChoice> choices = new ArrayList<>();
        choices.add(c1);
        choices.add(c2);
        choices.add(c3);
        choices.add(c4);
        choices.add(c5);

        sondage = new SurveyManager(sujet, choices, 1);

        System.out.println(sondage.getSubject());
        System.out.println("Voici les choix :");
        System.out.println(sondage.getCandidates());

        List<VoteChoice> votes = new ArrayList<>();

        //premier voting.election
        votes.add(c1); //florence
        sondage.voter(votes);


        //deuxième voting.election
        votes = new ArrayList<>();
        votes.add(c1); //florence
        sondage.voter(votes);

        //troisième voting.election
        votes = new ArrayList<>();
        votes.add(c5); //madrid
        sondage.voter(votes);

        //quatrième voting.election, un voting.election blanc
        //election.voterBlanc();

        sondage.fermerElection();


        // Résultats
        //TODO ne fonctionne pas tres bien quand il y a des egalites
        ImmutableSet<VoteChoice> elus = sondage.getResultats();

        System.out.println();
        System.out.println("Voici le résultat");
        System.out.println(elus);
    }
}

package vote;

import com.google.common.collect.ImmutableSet;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by florian on 24/12/16.
 *
 */
public class TestVote {


    public static void main(String[] args) {
        ElectionManager election ;


        Candidat p1 = new Candidat("Florian");
        Candidat p2 = new Candidat("Gandalf");
        Candidat p3 = new Candidat("Bilbon");
        Candidat p4 = new Candidat("Frodon");
        Candidat p5 = new Candidat("Gimli");

        List<Candidat> candidats = new ArrayList<>();
        candidats.add(p1);
        candidats.add(p2);
        candidats.add(p3);
        candidats.add(p4);
        candidats.add(p5);


        election = new ElectionManager("Présidence", candidats, 2);

        System.out.println("Voici les candidats :");
        System.out.println(election.getCandidates());


        List<Candidat> votes = new ArrayList<>();

        //premier vote
        votes.add(p1); //florian
        votes.add(p4); //frodon
        election.voter(votes);


        //deuxième vote
        //votes = new ArrayList<>();
        //votes.add(p1); //florian
        //votes.add(p4); //frodon
        //election.voter(votes);

        //troisième vote
        votes = new ArrayList<>();
        votes.add(p5); //florian
        votes.add(p4); //frodon
        votes.add(p1); //gimli
        election.voter(votes);

        //quatrième vote, un vote blanc
        //election.voterBlanc();

        election.fermerElection();


        // Résultats
        //TODO ne fonctionne pas tres bien quand il y a des egalites
        ImmutableSet<Candidat> elus = election.getResultats();

        System.out.println();
        System.out.println("Voici les élus");
        System.out.println(elus);
    }
}

package vote;

import com.google.common.collect.ImmutableSet;
import info.gehrels.voting.Election;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by florian on 24/12/16.
 *
 */
public class TestVote {

    public static void main(String[] args){
        List<Personne> personnes = new ArrayList<>();

        personnes.add(new Personne("Florian"));
        personnes.add(new Personne("Gandalf"));
        personnes.add(new Personne("Bilbon"));
        personnes.add(new Personne("Frodon"));
        personnes.add(new Personne("Gimli"));

        ImmutableSet<Personne> candidats = ImmutableSet.copyOf(personnes);


        Election<Personne> election = new Election<>("président", candidats);

        System.out.println("Voici les candidats :");
        System.out.println(election.getCandidates());
    }
}

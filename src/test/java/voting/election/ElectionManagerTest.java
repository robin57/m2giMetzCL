package voting.election;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import voting.VoteChoice;

import java.util.ArrayList;

/**
 * Created by schuma on 20/03/17.
 *
 */
public class ElectionManagerTest {
    private ElectionManager manager;


    @Before
    public void before() throws Exception {
        manager = new ElectionManager(
                "Chef",
                new ArrayList<VoteChoice>()
                {{
                    add(new Candidat("Frodo"));
                    add(new Candidat("Bilbo"));
                }},
                1);
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testConstructor(){
        Assert.assertNotNull(manager);
    }

    @Test
    public void testGetElection(){
        Assert.assertNotNull(manager.getElection());
    }

    @Test
    public void testGetCandidates(){
        Assert.assertNotNull(manager.getCandidates());
        Assert.assertFalse(manager.getCandidates().isEmpty());
        Assert.assertEquals(2, manager.getCandidates().size());
    }

    @Test
    public void testGetName(){
        Assert.assertEquals("Chef", manager.getElection().getOfficeName());
    }
}

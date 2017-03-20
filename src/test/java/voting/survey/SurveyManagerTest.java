package voting.survey;

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
public class SurveyManagerTest {
    private SurveyManager manager;

    @Before
    public void before() throws Exception {
        manager = new SurveyManager(
                "Destination de vos prochaines vacances",
                new ArrayList<VoteChoice>()
                {{
                    add(new Choice("Paris"));
                    add(new Choice("Londres"));
                    add(new Choice("Berlin"));
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
        Assert.assertEquals(3, manager.getCandidates().size());
    }

    @Test
    public void testGetSubject(){
        Assert.assertEquals("Destination de vos prochaines vacances", manager.getSubject());
    }
}

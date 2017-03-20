package voting;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by schuma on 20/03/17.
 *
 */
public class VotingManagerTest {
    private VotingManager manager;

    @Before
    public void before() throws Exception {
        manager = new VotingManager(Utils.getAnElection());
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testConstructor(){
        Assert.assertNotNull(manager);
    }
}

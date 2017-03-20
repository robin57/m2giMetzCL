package voting;

import info.gehrels.voting.Vote;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by schuma on 20/03/17.
 *
 */
public class BulletinTest {
    private Bulletin bulletin;

    @Before
    public void before() throws Exception {
        bulletin = new Bulletin(Vote.createNoVote(Utils.getAnElection()), 1);
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testConstructor(){
        Assert.assertNotNull(bulletin);
    }

    @Test
    public void testGetBallot(){
        Assert.assertNotNull(bulletin.getBallot());
    }

    @Test
    public void testGetIdOfBulletin(){
        Assert.assertEquals(1, bulletin.getBallot().id);
    }
}

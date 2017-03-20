package voting.election;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by schuma on 20/03/17.
 *
 */
public class CandidatTest {
    private Candidat candidat;

    @Before
    public void before() throws Exception {
        candidat = new Candidat("Bilbo");
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testConstructor(){
        Assert.assertNotNull(candidat);
    }

    @Test
    public void testGetName(){
        Assert.assertEquals("Bilbo", candidat.getName());
    }
}

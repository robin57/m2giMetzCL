package voting.survey;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by schuma on 20/03/17.
 *
 */
public class ChoiceTest {
    private Choice choix;

    @Before
    public void before() throws Exception {
        choix = new Choice("Paris");
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testConstructor(){
        Assert.assertNotNull(choix);
    }

    @Test
    public void testToString(){
        Assert.assertEquals("Paris", choix.toString());
    }

    @Test
    public void testGetName(){
        Assert.assertEquals("Paris", choix.getName());
    }
}

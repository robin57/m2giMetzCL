package crypto;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* TestType Tester. 
* 
* @author Florian
* @since <pre>déc. 24, 2016</pre> 
* @version 1.0 
*/ 
public class TypeTest {

    private Type type;

    @Before
    public void before() throws Exception {
        type = Type.AES;
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testToString(){
        Assert.assertEquals("AES", type.toString());
    }


    @Test
    public void testEqualsValue(){
        Assert.assertFalse(type.equalsValue("DES"));
    }

    @Test
    public void testEqualsValueBis(){
        Assert.assertTrue(type.equalsValue("AES"));
    }
} 

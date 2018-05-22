package utils;

import org.junit.Assert;

public class UtilsTests {

    public static void assertArrays(String expected[], String actual[]) {
        Assert.assertEquals(expected.length, actual.length);
        for(int i=0; i<expected.length; i++) {
            Assert.assertTrue(expected[i].equals(actual[i]));
        }
    }

    public static void assertArrays(int expected[], int actual[]) {
        Assert.assertEquals(expected.length, actual.length);
        for(int i=0; i<expected.length; i++) {
            Assert.assertEquals(expected[i], (actual[i]));
        }
    }
}

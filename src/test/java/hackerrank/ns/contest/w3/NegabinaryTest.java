package hackerrank.ns.contest.w3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import hackerranck.ns.contest.w3.Negabinary;

public class NegabinaryTest {

    @Test
    public void getValueTest() {
        double r = Negabinary.getValue("100110");
        Assert.assertEquals(-30, r, 0.0);

        r = Negabinary.getValue("110001");
        Assert.assertEquals(-15, r, 0.0);

        r = Negabinary.getValue("10");
        Assert.assertEquals(-2, r, 0.0);

        r = Negabinary.getValue("11");
        Assert.assertEquals(-1, r, 0.0);

        r = Negabinary.getValue("0");
        Assert.assertEquals(0, r, 0.0);

        r = Negabinary.getValue("1");
        Assert.assertEquals(1, r, 0.0);

        r = Negabinary.getValue("110");
        Assert.assertEquals(2, r, 0.0);

        r = Negabinary.getValue("10011");
        Assert.assertEquals(15, r, 0.0);

        r = Negabinary.getValue("1100010");
        Assert.assertEquals(30, r, 0.0);

    }

    @Test
    public void oddOccurrenceTest() {
        List<String> elements = new ArrayList<>(Arrays.asList("cat", "dog", "mouse", "cat", "dog"));
        String r = Negabinary.oddOccurrence(elements);
        Assert.assertEquals("mouse", r);

        elements = new ArrayList<>(Arrays.asList("11", "1", "11"));
        r = Negabinary.oddOccurrence(elements);
        Assert.assertEquals("1", r);

        elements = new ArrayList<>(Arrays.asList("11110", "11110", "11100", "101", "11100", "11100", "11100"));
        r = Negabinary.oddOccurrence(elements);
        Assert.assertEquals("101", r);

    }

    @Test
    public void getNegabinaryTest() {
        String result = Negabinary.getNegabinary(-30);
        Assert.assertEquals("100110", result);

        result = Negabinary.getNegabinary(-15);
        Assert.assertEquals("110001", result);

        result = Negabinary.getNegabinary(-2);
        Assert.assertEquals("10", result);

        result = Negabinary.getNegabinary(-1);
        Assert.assertEquals("11", result);

        result = Negabinary.getNegabinary(0);
        Assert.assertEquals("0", result);

        result = Negabinary.getNegabinary(1);
        Assert.assertEquals("1", result);

        result = Negabinary.getNegabinary(2);
        Assert.assertEquals("110", result);

        result = Negabinary.getNegabinary(15);
        Assert.assertEquals("10011", result);

        result = Negabinary.getNegabinary(30);
        Assert.assertEquals("1100010", result);
    }
}

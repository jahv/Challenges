package codefight.arcade;

import org.junit.Assert;
import org.junit.Test;

public class $4_ExploringTheWatersTest {

    @Test
    public void alternatingSumsTest() {

        int result[] = $4_ExploringTheWaters.alternatingSums(new int[]{50, 60, 60, 45, 70});
        Assert.assertEquals(180, result[0]);
        Assert.assertEquals(105, result[1]);

        result = $4_ExploringTheWaters.alternatingSums(new int[]{100, 50});
        Assert.assertEquals(100, result[0]);
        Assert.assertEquals(50, result[1]);

        result = $4_ExploringTheWaters.alternatingSums(new int[]{80});
        Assert.assertEquals(80, result[0]);
        Assert.assertEquals(0, result[1]);
    }

    @Test
    public void addBorderTest() {
        String actual[] = $4_ExploringTheWaters.addBorder(new String[]{"abc", "ded"});
        String expected[] = new String[]{
                "*****",
                "*abc*",
                "*ded*",
                "*****"
        };
        Assert.assertArrayEquals(expected, actual);

        actual = $4_ExploringTheWaters.addBorder(new String[]{"a"});
        expected = new String[]{
                "***",
                "*a*",
                "***"
        };
        Assert.assertArrayEquals(expected, actual);
    }
}

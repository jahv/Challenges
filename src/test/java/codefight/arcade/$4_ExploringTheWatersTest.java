package codefight.arcade;

import org.junit.Assert;
import org.junit.Ignore;
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

    @Ignore
    @Test
    public void similarBySwapTest() {
        int []a = new int[]{1, 2, 3, 4};
        int []b = new int[]{2, 1, 4, 3};

        Assert.assertTrue($4_ExploringTheWaters.similarBySwap(a, b, 0));
        Assert.assertFalse($4_ExploringTheWaters.similarBySwap(a, b, 1));
        Assert.assertTrue($4_ExploringTheWaters.similarBySwap(a, b, 2));
        Assert.assertFalse($4_ExploringTheWaters.similarBySwap(a, b, 3));
    }

    @Ignore
    @Test
    public void areSimilarTest() {
        int []a = new int[]{1, 2, 3};
        int []b = new int[]{1, 2, 3};
        Assert.assertTrue($4_ExploringTheWaters.areSimilar(a, b));

        a = new int[]{1, 2, 3};
        b = new int[]{2, 1, 3};
        Assert.assertTrue($4_ExploringTheWaters.areSimilar(a, b));

        a = new int[]{1, 2, 2};
        b = new int[]{2, 1, 1};
        Assert.assertFalse($4_ExploringTheWaters.areSimilar(a, b));

        a = new int[]{1, 1, 4};
        b = new int[]{1, 2, 3};
        Assert.assertFalse($4_ExploringTheWaters.areSimilar(a, b));

        a = new int[]{1, 2, 3};
        b = new int[]{1, 10, 2};
        Assert.assertFalse($4_ExploringTheWaters.areSimilar(a, b));

        a = new int[]{2, 3, 1};
        b = new int[]{1, 3, 2};
        Assert.assertTrue($4_ExploringTheWaters.areSimilar(a, b));
    }

    @Test
    public void areSimilarTestFinal() {
        int []a = new int[]{1, 2, 3};
        int []b = new int[]{1, 2, 3};
        Assert.assertTrue($4_ExploringTheWaters.areSimilarSolutionBought(a, b));

        a = new int[]{1, 2, 3};
        b = new int[]{2, 1, 3};
        Assert.assertTrue($4_ExploringTheWaters.areSimilarSolutionBought(a, b));

        a = new int[]{1, 2, 2};
        b = new int[]{2, 1, 1};
        Assert.assertFalse($4_ExploringTheWaters.areSimilarSolutionBought(a, b));

        a = new int[]{1, 1, 4};
        b = new int[]{1, 2, 3};
        Assert.assertFalse($4_ExploringTheWaters.areSimilarSolutionBought(a, b));

        a = new int[]{1, 2, 3};
        b = new int[]{1, 10, 2};
        Assert.assertFalse($4_ExploringTheWaters.areSimilarSolutionBought(a, b));

        a = new int[]{2, 3, 1};
        b = new int[]{1, 3, 2};
        Assert.assertTrue($4_ExploringTheWaters.areSimilarSolutionBought(a, b));

        a = new int[]{2, 3, 9};
        b = new int[]{10, 3, 2};
        Assert.assertFalse($4_ExploringTheWaters.areSimilarSolutionBought(a, b));

        a = new int[]{4, 6, 3};
        b = new int[]{3, 4, 6};
        Assert.assertFalse($4_ExploringTheWaters.areSimilarSolutionBought(a, b));

        a = new int[]{832, 998, 148, 570, 533, 561, 894, 147, 455, 279};
        b = new int[]{832, 998, 148, 570, 533, 561, 455, 147, 894, 279};
        Assert.assertTrue($4_ExploringTheWaters.areSimilarSolutionBought(a, b));

        a = new int[]{832, 998, 148, 570, 533, 561, 894, 147, 455, 279};
        b = new int[]{832, 570, 148, 998, 533, 561, 455, 147, 894, 279};
        Assert.assertFalse($4_ExploringTheWaters.areSimilarSolutionBought(a, b));
    }

    @Test
    public void arrayChangeTest() {
        Assert.assertEquals(3, $4_ExploringTheWaters.arrayChange(new int[]{1, 1, 1}));
        Assert.assertEquals(5, $4_ExploringTheWaters.arrayChange(new int[]{-1000, 0, -2, 0}));
        Assert.assertEquals(12, $4_ExploringTheWaters.arrayChange(new int[]{2, 1, 10, 1}));
        Assert.assertEquals(13, $4_ExploringTheWaters.arrayChange(new int[]{2, 3, 3, 5, 5, 5, 4, 12, 12, 10, 15}));
    }
}

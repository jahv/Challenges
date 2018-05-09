package bairesdev;

import org.junit.Assert;
import org.junit.Test;

public class ProblemsTest {

    @Test
    public void isCasiPalindromoTest() {
        Assert.assertTrue(Problems.isCasiPalindromo("abccba"));
        Assert.assertTrue(Problems.isCasiPalindromo("abccbx"));
        Assert.assertFalse(Problems.isCasiPalindromo("abccfg"));
    }

    @Test
    public void menorMasPopularTest() {
        Assert.assertEquals(34, Problems.menorMasPopular(new int[]{34,31,34,77,82}, 5));
        Assert.assertEquals(101, Problems.menorMasPopular(new int[]{22,101,102,101,102,525,88}, 7));
        Assert.assertEquals(66, Problems.menorMasPopular(new int[]{66}, 1));
        Assert.assertEquals(2342, Problems.menorMasPopular(new int[]{14,14,2342,2342,2342}, 5));
    }

    @Test
    public void balacendTest() {
        Assert.assertTrue(Problems.balanced("((((()))))"));
        Assert.assertTrue(Problems.balanced("[{()}]"));
        Assert.assertFalse(Problems.balanced("]["));
        Assert.assertTrue(Problems.balanced("(a[0]+b[2c[6]]) {24 + 53}"));
        Assert.assertTrue(Problems.balanced("f(e(d))"));
        Assert.assertTrue(Problems.balanced("[()]{}([])"));
        Assert.assertFalse(Problems.balanced("((b)"));
        Assert.assertFalse(Problems.balanced("(c]"));
        Assert.assertFalse(Problems.balanced("{(a[])"));
        Assert.assertFalse(Problems.balanced("([)]"));
        Assert.assertFalse(Problems.balanced(")("));
        Assert.assertTrue(Problems.balanced(""));

    }
}

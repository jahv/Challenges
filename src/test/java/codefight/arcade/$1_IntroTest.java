package codefight.arcade;

import org.junit.Assert;
import org.junit.Test;

public class $1_IntroTest {

    @Test
    public void centuryFromYearTest() {
        Assert.assertEquals(1, $1_Intro.centuryFromYear(1));
        Assert.assertEquals(1, $1_Intro.centuryFromYear(100));

        Assert.assertEquals(2, $1_Intro.centuryFromYear(101));
        Assert.assertEquals(2, $1_Intro.centuryFromYear(200));

        Assert.assertEquals(17, $1_Intro.centuryFromYear(1601));
        Assert.assertEquals(17, $1_Intro.centuryFromYear(1700));

        Assert.assertEquals(20, $1_Intro.centuryFromYear(1905));
    }

    @Test
    public void checkPalindromeTest() {
        Assert.assertTrue($1_Intro.checkPalindrome("aabaa"));
        Assert.assertTrue($1_Intro.checkPalindrome("aaaa"));
        Assert.assertTrue($1_Intro.checkPalindrome("aaa"));
        Assert.assertTrue($1_Intro.checkPalindrome("a"));

        Assert.assertFalse($1_Intro.checkPalindrome("ab"));
        Assert.assertFalse($1_Intro.checkPalindrome("abc"));
        Assert.assertFalse($1_Intro.checkPalindrome("abca"));
    }

    public void testest() {
        int[] arr = new int[]{1,2,3,4,5,6};


    }

    int countEntInArr(int[] arr, int ent) {
        int c = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == ent) {
                c++;
            }
        }
        return c;
    }
}

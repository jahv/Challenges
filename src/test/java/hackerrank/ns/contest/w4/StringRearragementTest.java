package hackerrank.ns.contest.w4;

import org.junit.Assert;
import org.junit.Test;

import hackerranck.ns.contest.w4.StringRearrangement;

/**
 * Created by ahernandez on 3/8/17.
 */
public class StringRearragementTest {

    @Test
    public void differOfOneCharTest() {
        Assert.assertTrue(StringRearrangement.differOfOneChar("ab","bb"));
        Assert.assertTrue(StringRearrangement.differOfOneChar("ab","aa"));

        Assert.assertFalse(StringRearrangement.differOfOneChar("bb","aa"));
    }

    @Test
    public void verifyDifferenceTest() {
        String[] list = new String[]{"aaa", "aab", "aac"};
        boolean result = StringRearrangement.verifyDifference(list);
        Assert.assertTrue(result);

        list = new String[]{"aa", "ab", "bb"};
        result = StringRearrangement.verifyDifference(list);
        Assert.assertTrue(result);

        list = new String[]{"q", "q", "q"};
        result = StringRearrangement.verifyDifference(list);
        Assert.assertFalse(result);
    }
}

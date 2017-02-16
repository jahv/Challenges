package hackerrank.ns.contest;

import hackerranck.ns.contest.PalindromicAnagram;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test for @{link {@link hackerranck.ns.contest.PalindromicAnagram} class
 */
public class PalindromicAnagramTest {

    /**
     * Testing isPalindrome method
     */
    @Test
    public void testPalindrome() {
        //Testing ABCD
        List<Character> data = new ArrayList<>(Arrays.asList(
                Character.valueOf('A'), Character.valueOf('B'), Character.valueOf('C'),
                Character.valueOf('D')
        ));
        Assert.assertFalse(PalindromicAnagram.isPalindrome(data));

        //Testing MADAMIMADAM
        data = new ArrayList<>(Arrays.asList(
                Character.valueOf('M'), Character.valueOf('A'), Character.valueOf('D'),
                Character.valueOf('A'), Character.valueOf('M'), Character.valueOf('I'),
                Character.valueOf('M'), Character.valueOf('A'), Character.valueOf('D'),
                Character.valueOf('A'), Character.valueOf('M')
        ));
        Assert.assertTrue(PalindromicAnagram.isPalindrome(data));
    }

    /**
     * Testing cleanData method
     */
    @Test
    public void cleanDataTest() {
        List<Character> expected = new ArrayList<>(Arrays.asList(
                Character.valueOf('M'), Character.valueOf('A'), Character.valueOf('D'),
                Character.valueOf('A'), Character.valueOf('M'), Character.valueOf('I'),
                Character.valueOf('M'), Character.valueOf('A'), Character.valueOf('D'),
                Character.valueOf('A'), Character.valueOf('M')
        ));
        String data = "Madam, I'm Adam";
        List<Character> result = PalindromicAnagram.cleanData(data);
        Assert.assertEquals(expected, result);
    }

    /**
     * Testing permutation method
     */
    @Test
    public void testPermutation() {
        String data = "abcab";
        PalindromicAnagram.permutation("", data, data);
    }

    /**
     * Testing hasPalindromicAnagram method
     */
    @Test
    public void hasPalindromicAnagramTest() {
        Assert.assertTrue(PalindromicAnagram.hasPalindromicAnagram("abab"));
        Assert.assertTrue(PalindromicAnagram.hasPalindromicAnagram("he h!"));
        Assert.assertTrue(PalindromicAnagram.hasPalindromicAnagram("Madam, I'm Adma"));

        Assert.assertFalse(PalindromicAnagram.hasPalindromicAnagram("bob"));
        Assert.assertFalse(PalindromicAnagram.hasPalindromicAnagram(""));
        Assert.assertFalse(PalindromicAnagram.hasPalindromicAnagram("abcd"));
    }
}

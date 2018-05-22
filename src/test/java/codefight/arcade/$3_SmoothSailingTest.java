package codefight.arcade;

import org.junit.Assert;
import org.junit.Test;
import utils.UtilsTests;

import java.util.HashMap;
import java.util.Map;

public class $3_SmoothSailingTest {

    @Test
    public void allLongestStringsTest() {
        String inputArray[] = new String[]{"aba", "aa", "ad", "vcd", "aba"};
        String expected[] = new String[]{"aba", "vcd", "aba"};
        String actual[] = $3_SmoothSailing.allLongestStrings(inputArray);
        UtilsTests.assertArrays(expected, actual);

        inputArray = new String[]{"abc", "eeee", "abcd", "dcd"};
        expected = new String[]{"eeee", "abcd"};
        actual = $3_SmoothSailing.allLongestStrings(inputArray);
        UtilsTests.assertArrays(expected, actual);
    }

    @Test
    public void incrementDataTest() {
        String s = "abcde";
        Map<Character, Integer> result = new HashMap<>();
        Map<Character, Integer> expected = new HashMap<>();

        expected.put('a', 1);
        $3_SmoothSailing.incrementData(0, s, result);
        Assert.assertEquals(expected, result);

        expected.clear();
        result.clear();
        expected.put('d',4);
        result.put('d',3);
        $3_SmoothSailing.incrementData(3, s, result);
        Assert.assertEquals(expected, result);

        expected.put('e',1);
        $3_SmoothSailing.incrementData(4, s, result);
        Assert.assertEquals(expected, result);

        $3_SmoothSailing.incrementData(5, s, result);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void commonCharacterCountTest() {

        Assert.assertEquals(3, $3_SmoothSailing.commonCharacterCount("aabcc","adcaa"));

    }

    @Test
    public void isLuckyTest() {
        Assert.assertTrue($3_SmoothSailing.isLucky(1230));
        Assert.assertFalse($3_SmoothSailing.isLucky(239017));
        Assert.assertTrue($3_SmoothSailing.isLucky(134008));
        Assert.assertFalse($3_SmoothSailing.isLucky(10));
        Assert.assertTrue($3_SmoothSailing.isLucky(11));
        Assert.assertTrue($3_SmoothSailing.isLucky(1010));
        Assert.assertFalse($3_SmoothSailing.isLucky(261534));
        Assert.assertFalse($3_SmoothSailing.isLucky(100000));
        Assert.assertTrue($3_SmoothSailing.isLucky(999999));
        Assert.assertTrue($3_SmoothSailing.isLucky(123321));
    }

    @Test
    public void sortByHeightTest() {
        UtilsTests.assertArrays(new int[]{-1, 150, 160, 170, -1, -1, 180, 190}, $3_SmoothSailing.sortByHeight(new int[]{-1, 150, 190, 170, -1, -1, 160, 180}));
        UtilsTests.assertArrays(new int[]{-1, -1, -1, -1, -1}, $3_SmoothSailing.sortByHeight(new int[]{-1, -1, -1, -1, -1}));
        UtilsTests.assertArrays(new int[]{2, 2, 4, 9, 11, 16}, $3_SmoothSailing.sortByHeight(new int[]{4, 2, 9, 11, 2, 16}));
    }

    @Test
    public void reverseParenthesesTest() {
        Assert.assertEquals("acbde",$3_SmoothSailing.reverseParentheses("a(bc)de"));
        Assert.assertEquals("apmnolkjihgfedcbq",$3_SmoothSailing.reverseParentheses("a(bcdefghijkl(mno)p)q"));
        Assert.assertEquals("cosfighted",$3_SmoothSailing.reverseParentheses("co(de(fight)s)"));
        Assert.assertEquals("CodeegnlleahC",$3_SmoothSailing.reverseParentheses("Code(Cha(lle)nge)"));
        Assert.assertEquals("Where are the parentheses?",$3_SmoothSailing.reverseParentheses("Where are the parentheses?"));
        Assert.assertEquals("abcabcabcabc",$3_SmoothSailing.reverseParentheses("abc(cba)ab(bac)c"));
        Assert.assertEquals("The god quick nworb xof jumps over the lazy",$3_SmoothSailing.reverseParentheses("The ((quick (brown) (fox) jumps over the lazy) dog)"));
    }
}

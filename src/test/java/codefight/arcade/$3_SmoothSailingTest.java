package codefight.arcade;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class $3_SmoothSailingTest {

    @Test
    public void allLongestStringsTest() {
        String inputArray[] = new String[]{"aba", "aa", "ad", "vcd", "aba"};
        String expected[] = new String[]{"aba", "vcd", "aba"};
        String actual[] = $3_SmoothSailing.allLongestStrings(inputArray);
        assertArrays(expected, actual);

        inputArray = new String[]{"abc", "eeee", "abcd", "dcd"};
        expected = new String[]{"eeee", "abcd"};
        actual = $3_SmoothSailing.allLongestStrings(inputArray);
        assertArrays(expected, actual);
    }

    private void assertArrays(String expected[], String actual[]) {
        Assert.assertEquals(expected.length, actual.length);
        for(int i=0; i<expected.length; i++) {
            Assert.assertTrue(expected[i].equals(actual[i]));
        }
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
}

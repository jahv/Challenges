package hackerrank.ns.contest.w5;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import hackerranck.ns.contest.w5.RepeatString;

/**
 * Created by ahernandez on 3/15/17.
 */
public class RepeatStringTest {

//    @Test
//    public void allDifferentTest() {
//        Assert.assertTrue(RepeatString.allDifferent("abc"));
//        Assert.assertTrue(RepeatString.allDifferent(""));
//        Assert.assertTrue(RepeatString.allDifferent(" "));
//
//        Assert.assertFalse(RepeatString.allDifferent("abca"));
//        Assert.assertFalse(RepeatString.allDifferent("aa"));
//        Assert.assertFalse(RepeatString.allDifferent("  "));
//    }
//
//    @Test
//    public void preparePatternTest() {
//        String r = RepeatString.preparePattern("a");
//        Assert.assertEquals(".*a.*", r);
//
//        r = RepeatString.preparePattern("ab");
//        Assert.assertEquals(".*a.*.*b.*", r);
//
//        r = RepeatString.preparePattern("abc");
//        Assert.assertEquals(".*a.*.*b.*.*c.*", r);
//    }

//    @Test
//    public void lengthLongestSquareStringTest() {
//        RepeatString.lengthLongestSquareString("abc");
//        RepeatString.lengthLongestSquareString("x");
//        RepeatString.lengthLongestSquareString("aababbababbabbbbabbabb");
//
//    }

    @Ignore
    @Test
    public void analizeTest() {
        RepeatString.find("flflabcdeghijk");
        RepeatString.find("frankfurt");
        RepeatString.find("single");
        RepeatString.find("singing");
        RepeatString.find("aababbababbabbbbabbabb");
        RepeatString.find("x");
    }

    @Test
    public void analize2Test() {
        RepeatString.analize2("flflabcdeghijk");
        RepeatString.analize2("frankfurt");
        RepeatString.analize2("single");
        RepeatString.analize2("singing");
        RepeatString.analize2("aababbababbabbbbabbabb");
        RepeatString.analize2("x");
    }

    @Ignore
    @Test
    public void analize3Test() {
//        RepeatString.analize3("flflabcdeghijk");
//        RepeatString.analize3("frankfurt");
//        RepeatString.analize3("single");
//        RepeatString.analize3("singing");
//        String s = "aababbababbabbbbabbabb";
        String s = "frankfurt";
        int i=0;
        StringBuffer start = new StringBuffer(s.substring(0, i + 1));
        StringBuffer end = new StringBuffer((s.substring(i +1)));
        RepeatString.analize3(start, end, 0);
//        RepeatString.analize3("x");
    }

    @Test
    public void analize4Test() {
        RepeatString.trues=0;
        RepeatString.analized.clear();
        StringBuilder head = new StringBuilder("f");
        StringBuilder tail = new StringBuilder("rankfurt");
        RepeatString.analize4(head, tail, 0);
        System.out.println("Max: " + RepeatString.trues);

        RepeatString.trues=0;
        RepeatString.analized.clear();
        head = new StringBuilder("s");
        tail = new StringBuilder("ingle");
        RepeatString.analize4(head, tail, 0);
        System.out.println("Max: " + RepeatString.trues);

        RepeatString.trues=0;
        RepeatString.analized.clear();
        head = new StringBuilder("s");
        tail = new StringBuilder("inging");
        RepeatString.analize4(head, tail, 0);
        System.out.println("Max: " + RepeatString.trues);

        RepeatString.trues=0;
        RepeatString.analized.clear();
        head = new StringBuilder("a");
        tail = new StringBuilder("ababbababbabbbbabbabb");
        RepeatString.analize4(head, tail, 0);
        System.out.println("Max: " + RepeatString.trues);

        RepeatString.trues=0;
        RepeatString.analized.clear();
        head = new StringBuilder("x");
        tail = new StringBuilder("");
        RepeatString.analize4(head, tail, 0);
        System.out.println("Max: " + RepeatString.trues);

        RepeatString.trues=0;
        RepeatString.analized.clear();
        head = new StringBuilder("a");
        tail = new StringBuilder("wbcdeflwefl");
        RepeatString.analize4(head, tail, 0);
        System.out.println("Max: " + RepeatString.trues);

        RepeatString.trues=0;
        RepeatString.analized.clear();
        head = new StringBuilder("a");
        tail = new StringBuilder("bcdaefghd");
        RepeatString.analize4(head, tail, 0);
        System.out.println("Max: " + RepeatString.trues);
    }

    @Test
    public void hasDuplicatedWildCardsTest() {
        Assert.assertFalse(RepeatString.hasDuplicatedWildCards(new StringBuilder("")));
        Assert.assertFalse(RepeatString.hasDuplicatedWildCards(new StringBuilder("a")));
        Assert.assertFalse(RepeatString.hasDuplicatedWildCards(new StringBuilder("ab")));
        Assert.assertFalse(RepeatString.hasDuplicatedWildCards(new StringBuilder("abc")));
        Assert.assertFalse(RepeatString.hasDuplicatedWildCards(new StringBuilder("abcd")));
        Assert.assertFalse(RepeatString.hasDuplicatedWildCards(new StringBuilder("abcde")));
        Assert.assertFalse(RepeatString.hasDuplicatedWildCards(new StringBuilder(".*")));
        Assert.assertFalse(RepeatString.hasDuplicatedWildCards(new StringBuilder(".*a")));
        Assert.assertFalse(RepeatString.hasDuplicatedWildCards(new StringBuilder(".*a.*")));

        Assert.assertTrue(RepeatString.hasDuplicatedWildCards(new StringBuilder(".*.*.*aaa")));
        Assert.assertTrue(RepeatString.hasDuplicatedWildCards(new StringBuilder(".*a.*.*")));
    }

    @Test
    public void removeDuplicatedWildCardsTest() {
        Assert.assertEquals(new StringBuilder("a.*b").toString(), RepeatString.removeDuplicatedWildCards(new StringBuilder("a.*.*b")).toString());
        Assert.assertEquals(new StringBuilder("a.*s.*b").toString(), RepeatString.removeDuplicatedWildCards(new StringBuilder("a.*.*s.*.*b")).toString());
    }


    @Test
    public void isHeadInTailTest() {
//        Assert.assertTrue(RepeatString.isHeadInTail(new StringBuilder("a"), new StringBuilder("a")));
//        Assert.assertTrue(RepeatString.isHeadInTail(new StringBuilder("babbababb"), new StringBuilder("abbbbabbabb")));
        Assert.assertTrue(RepeatString.isHeadInTail(new StringBuilder("a"), new StringBuilder("ababbababbabbbbabbabb")));

    }


//    public void getMa
}

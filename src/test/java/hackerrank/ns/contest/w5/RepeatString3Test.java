package hackerrank.ns.contest.w5;

import org.junit.Test;

import hackerranck.ns.contest.w5.RepeatString3;

/**
 * Created by ahernandez on 3/16/17.
 */
public class RepeatString3Test {

    @Test
    public void maximalLengthTest() {
        System.out.println(RepeatString3.maximalLength("frankfurt"));
        System.out.println(RepeatString3.maximalLength("single"));
        System.out.println(RepeatString3.maximalLength("singing"));
        System.out.println(RepeatString3.maximalLength("aababbababbabbbbabbabb"));
        System.out.println(RepeatString3.maximalLength("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }
}

package regular.java.code;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherPatternTest {

    private static final String NUMBER_WITH_WORDS_EXPR;
    private static final String NUMBER_WITH_WORDS_ALPHA_SEPARATED_EXPR;
    private static final Pattern PCI_PATTERN_WITH_WORDS;

    static {
        NUMBER_WITH_WORDS_EXPR = String.format("%s|%s", "one|two|three|four|five|six|seven|eight|nine|zero", "[0-9]");
        NUMBER_WITH_WORDS_ALPHA_SEPARATED_EXPR = String.format("((%s)(\\P{Alnum}{0,5}|\\p{Alpha})){5,}(%s)", NUMBER_WITH_WORDS_EXPR, NUMBER_WITH_WORDS_EXPR);

        PCI_PATTERN_WITH_WORDS = Pattern.compile(NUMBER_WITH_WORDS_ALPHA_SEPARATED_EXPR, 2);
    }

    @Test
    public void matcherTest() {

        String input = "Min LOS:1, Max LOS:60, Min booking:1, Date Ranges start Date - End Date 04/05/2018 -  04/10/2018 start 04/15/2018 - end 04/20/2018";

        input = input.replaceAll("\\d\\d/\\d\\d/\\d\\d\\d\\d", "");

        System.out.println(input);


        System.out.println("PATTERN:");
        System.out.println(NUMBER_WITH_WORDS_ALPHA_SEPARATED_EXPR);
        Matcher matcher = PCI_PATTERN_WITH_WORDS.matcher(input);

        boolean potentialPCI = false;

        System.out.println("\nFindings:");
        while(matcher.find()) {
            potentialPCI = true;
            String match = input.substring(matcher.start(), matcher.end());
            System.out.println(match);

            String minifiedPotentialPCI = match.replaceAll("\\P{Digit}+", "");
            System.out.println("Minified: " + minifiedPotentialPCI);

            if (match.length() < 6) {
                potentialPCI = false;
            }
        }

        System.out.println(potentialPCI ? "ERROR" : "OK");
    }

    @Test
    public void replaceTest() {

        String input = "123-abc";

        String replaced = input.replaceAll("\\p{Digit}", "");
        System.out.println(replaced);

//        replaced = input.replaceAll("\\P{-}", "");
//        System.out.println(replaced);

    }

    @Test
    public void regexTest() {
//        String regex = "\\.\\*\\(AGT\\)\\.\\*\\(ACT\\)\\.\\*\\(CGT\\)\\.\\*";
//        String pattern = Pattern.compile("aaa", Pattern.CASE_INSENSITIVE);


    }

}

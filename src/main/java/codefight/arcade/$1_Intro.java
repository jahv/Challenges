package codefight.arcade;

public class $1_Intro {

    /**
     * Given a year, return the century it is in. The first century spans from the year 1 up to and including the year 100, the second - from the year 101 up to and including the year 200, etc.
     * <p>
     * Example
     * <p>
     * For year = 1905, the output should be
     * centuryFromYear(year) = 20;
     * For year = 1700, the output should be
     * centuryFromYear(year) = 17.
     * Input/Output
     * <p>
     * [time limit] 3000ms (java)
     * [input] integer year
     * <p>
     * A positive integer, designating the year.
     * <p>
     * Guaranteed constraints:
     * 1 ≤ year ≤ 2005.
     * <p>
     * [output] integer
     * <p>
     * The number of the century the year is in.
     */
    public static int centuryFromYear(int year) {
        int century = (year / 100) + 1;

        if (year % 100 == 0) {
            century--;
        }
        return century;
    }

    /**
     * Given the string, check if it is a palindrome.
     * <p>
     * Example
     * <p>
     * For inputString = "aabaa", the output should be
     * checkPalindrome(inputString) = true;
     * For inputString = "abac", the output should be
     * checkPalindrome(inputString) = false;
     * For inputString = "a", the output should be
     * checkPalindrome(inputString) = true.
     * Input/Output
     * <p>
     * [time limit] 3000ms (java)
     * [input] string inputString
     * <p>
     * A non-empty string consisting of lowercase characters.
     * <p>
     * Guaranteed constraints:
     * 1 ≤ inputString.length ≤ 105.
     * <p>
     * [output] boolean
     * <p>
     * true if inputString is a palindrome, false otherwise.
     */
    public static boolean checkPalindrome(String inputString) {
        for (int i = 0; i < inputString.length() / 2; i++) {
            if (inputString.charAt(i) != inputString.charAt(inputString.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}

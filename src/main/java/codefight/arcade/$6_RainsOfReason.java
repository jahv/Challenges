package codefight.arcade;

public class $6_RainsOfReason {

    /**
     * occurrences of elemToReplace with substitutionElem.
     *
     * Example
     *
     * For inputArray = [1, 2, 1], elemToReplace = 1, and substitutionElem = 3, the output should be
     * arrayReplace(inputArray, elemToReplace, substitutionElem) = [3, 2, 3].
     *
     * Input/Output
     *
     * [execution time limit] 3 seconds (java)
     *
     * [input] array.integer inputArray
     *
     * Guaranteed constraints:
     * 2 ≤ inputArray.length ≤ 10,
     * 0 ≤ inputArray[i] ≤ 10.
     *
     * [input] integer elemToReplace
     *
     * Guaranteed constraints:
     * 0 ≤ elemToReplace ≤ 10.
     *
     * [input] integer substitutionElem
     *
     * Guaranteed constraints:
     * 0 ≤ substitutionElem ≤ 10.
     *
     * [output] array.integer
     * @param inputArray
     * @param elemToReplace
     * @param substitutionElem
     * @return
     */
    public static int[] arrayReplace(int[] inputArray, int elemToReplace, int substitutionElem) {
        for(int i=0; i<inputArray.length; i++) {
            if(inputArray[i] == elemToReplace) {
                inputArray[i] = substitutionElem;
            }
        }
        return inputArray;
    }

    /**
     * Check if all digits of the given integer are even.
     *
     * Example
     *
     * For n = 248622, the output should be
     * evenDigitsOnly(n) = true;
     * For n = 642386, the output should be
     * evenDigitsOnly(n) = false.
     * Input/Output
     *
     * [execution time limit] 3 seconds (java)
     *
     * [input] integer n
     *
     * Guaranteed constraints:
     * 1 ≤ n ≤ 109.
     *
     * [output] boolean
     *
     * true if all digits of n are even, false otherwise.
     *
     * @param n
     * @return
     */
    public static boolean evenDigitsOnly(int n) {
        for(char c : String.valueOf(n).toCharArray()) {
            if(c % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Correct variable names consist only of English letters, digits and underscores and they can't start with a digit.
     *
     * Check if the given string is a correct variable name.
     *
     * Example
     *
     * For name = "var_1__Int", the output should be
     * variableName(name) = true;
     * For name = "qq-q", the output should be
     * variableName(name) = false;
     * For name = "2w2", the output should be
     * variableName(name) = false.
     * Input/Output
     *
     * [execution time limit] 3 seconds (java)
     *
     * [input] string name
     *
     * Guaranteed constraints:
     * 1 ≤ name.length ≤ 10.
     *
     * [output] boolean
     *
     * true if name is a correct variable name, false otherwise.
     */
    public static boolean variableName(String name) {
        return name.matches("^[a-zA-Z](\\w|_)*$");
    }

    /**
     * Given a string, replace each of its character by the next one in the English alphabet (z would be replaced by a).
     *
     * Example
     *
     * For inputString = "crazy", the output should be
     * alphabeticShift(inputString) = "dsbaz".
     *
     * Input/Output
     *
     * [execution time limit] 3 seconds (java)
     *
     * [input] string inputString
     *
     * Non-empty string consisting of lowercase English characters.
     *
     * Guaranteed constraints:
     * 1 ≤ inputString.length ≤ 1000.
     *
     * [output] string
     *
     * The result string after replacing all of its characters.
     * @param inputString
     * @return
     */
    public static String alphabeticShift(String inputString) {
        StringBuilder result = new StringBuilder();
        for(char c : inputString.toCharArray()) {
            if(c == 'z') {
                result.append('a');
            } else {
                result.append((char)(c+1));
            }
        }
        return result.toString();
    }
}

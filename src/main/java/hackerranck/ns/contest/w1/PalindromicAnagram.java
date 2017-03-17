package hackerranck.ns.contest.w1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * A palindrome is a string that reads the same left-to-right and right-to-left.
 * For example,
 *      "Madam, I'm Adam" and "Poor Dan is in a droop" are both palindromes.
 * Note that letter case and non-alphanumeric characters should be ignored when deciding whether a
 * string is a palindrome or not.
 *
 * А string x is an anagram of another string y if you can obtain y by rearranging the letters of x.
 * For example,
 *      "cinema" is an anagram of "iceman", and vice versa.
 * Note that the string and its anagram must have the same length.
 * By definition, the string is not considered as an anagram of itself.
 * In anagrams, non-alphanumeric characters and letter case are important.
 * For instance, "Oo" is not the same as "oO", making "Oo" an anagram of "oO" and vice versa.
 *
 * Given a message, your task is to determine whether there is an anagram of the message that is
 * also a palindrome.

 * Example
 * For message = "abab", the output should be hasPalindromicAnagram(message) = true.
 * Among the anagrams of "abab", there are two strings that are also palindromes ("abba" and "baab"),
 * so the answer is true.
 *
 * For message = "bob", the output should be hasPalindromicAnagram(message) = false.
 * The only rearrangement of the letters in the string "bob" that is a palindrome is the word itself,
 * but this is not an anagram as defined above. Therefore, the answer is false.
 *
 * For message = "heh!", the output should be hasPalindromicAnagram(message) = true.
 * "!heh", "h!eh" and "he!h" are all palindromes and all of them are anagrams of "heh!".
 * Remember that according to the rules laid out above, non-alphanumeric characters are ignored in
 * palindromes but need to be considered in anagrams.
 *
 * Input Format
 *
 * A string that will be checked to determine if there is an anagram of that string that is also a
 * palindrome
 *
 * Constraints
 *
 * A string containing at least one alphanumeric character.
 * 0 < message.length ≤ 20
 *
 * Output Format
 * You should print "true" or "false" if there is an anagram of the given string that is also a palindrome
 *
 * Sample Input 0: abab
 * Sample Output 0: true
 * Sample Input 1: bob
 * Sample Output 1: false
 * Sample Input 2: heh!
 * Sample Output 2: true
 *
 * @author ahernandez
 * Date 16-Feb-2017
 */
public class PalindromicAnagram {

    private static Boolean flag_stop = false;
    private static Boolean result = false;

    /**
     * Remove all non-alphanumeric characters for palindrome validation
     *
     * @param data
     * @return
     */
    public static List<Character> cleanData(String data) {
        char[] chars = data.toCharArray();
        List<Character> characterList = new ArrayList<>();
        for(char c : chars) {
            if(Character.isAlphabetic(c) || Character.isDigit(c)) {
                characterList.add(Character.toUpperCase(c));
            }
        }
        return  characterList;
    }

    /**
     * Verify if data is equals in reverse order to validate if is palindrome
     *
     * @param data
     * @return
     */
    public static boolean isPalindrome(List<Character> data) {
        List<Character> reverse = new ArrayList<>(data);
        Collections.reverse(reverse);
        return data.equals(reverse);
    }

    /**
     * Generate all possible permutations for original, and every new permutation verify that is
     * different from the original and if accomplish the isPalindrome test, if so, set the global
     * result flag as true, and the flag_stop as true also, to avoid the recursion, if no
     * keep performing the permutation and validating
     *
     * @param prefix
     * @param str
     * @param original
     */
    public static void permutation(String prefix, String str, String original) {
        if(!flag_stop) {
            if (str.equals("")) {
                if (!original.equals(prefix) && isPalindrome(cleanData(prefix))) {
                    flag_stop=true;
                    result=true;
                    return;
                }
            } else {
                int n = str.length();
                for (int i = 0; i < n; i++) {
                    String newPrefix = prefix + str.charAt(i);
                    String newStr = str.substring(0, i) + str.substring(i + 1, n);
                    permutation(newPrefix, newStr, original);
                }
            }
        }
    }

    /**
     * Entry point for verify if data has an anagram which accomplish the isPalindrome test
     *
     * @param data
     * @return
     */
    public static boolean hasPalindromicAnagram(String data) {
        result = false;
        flag_stop = false;
        if(data.length() < 0 || data.length() > 20) {
            throw new RuntimeException("Out of range");
        }
        permutation("", data, data);
        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String data = scan.nextLine();
        System.out.println(hasPalindromicAnagram(data));
    }

}

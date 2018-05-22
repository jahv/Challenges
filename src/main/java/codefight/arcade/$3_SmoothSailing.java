package codefight.arcade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class $3_SmoothSailing {


    /**
     * Given an array of strings, return another array containing all of its longest strings.

     Example

     For inputArray = ["aba", "aa", "ad", "vcd", "aba"], the output should be
     allLongestStrings(inputArray) = ["aba", "vcd", "aba"].

     Input/Output

     [execution time limit] 3 seconds (java)

     [input] array.string inputArray

     A non-empty array.

     Guaranteed constraints:
     1 ≤ inputArray.length ≤ 10,
     1 ≤ inputArray[i].length ≤ 10.

     [output] array.string

     Array of the longest strings, stored in the same order as in the inputArray.

     * @param inputArray
     * @return
     */
    public static String[] allLongestStrings(String[] inputArray) {
        List<Integer> longStringsIndex = new ArrayList<>();

        int maxLength = inputArray[0].length();
        longStringsIndex.add(0);
        for(int i=1; i<inputArray.length; i++) {
            if(inputArray[i].length() > maxLength) {
                longStringsIndex.clear();
                longStringsIndex.add(i);
                maxLength = inputArray[i].length();
            } else if(inputArray[i].length() == maxLength) {
                longStringsIndex.add(i);
            }
        }

        String longStrings[] = new String[longStringsIndex.size()];
        int i=0;
        for(int index : longStringsIndex) {
            longStrings[i++] = inputArray[index];
        }

        return longStrings;
    }

    /**
     * Given two strings, find the number of common characters between them.

     Example

     For s1 = "aabcc" and s2 = "adcaa", the output should be
     commonCharacterCount(s1, s2) = 3.

     Strings have 3 common characters - 2 "a"s and 1 "c".

     Input/Output

     [execution time limit] 3 seconds (java)

     [input] string s1

     A string consisting of lowercase latin letters a-z.

     Guaranteed constraints:
     1 ≤ s1.length ≤ 15.

     [input] string s2

     A string consisting of lowercase latin letters a-z.

     Guaranteed constraints:
     1 ≤ s2.length ≤ 15.

     [output] integer
     * @param s1
     * @param s2
     * @return
     */
    public static int commonCharacterCount(String s1, String s2) {
        Map<Character, Integer> result1 = new HashMap<>();
        Map<Character, Integer> result2 = new HashMap<>();

        int longest = s1.length() > s2.length() ? s1.length() : s2.length();

        for(int i=0; i<longest; i++) {
            incrementData(i, s1, result1);
            incrementData(i, s2, result2);
        }

        Set<Character> allData = new HashSet<>();
        allData.addAll(result1.keySet());
        allData.addAll(result2.keySet());

        int sum = 0;
        for(Character character : allData) {
            Integer counter1 = result1.get(character);
            Integer counter2 = result2.get(character);
            if(counter1 != null && counter2 != null) {
                if(counter1 > counter2) {
                    sum += counter2;
                } else {
                    sum += counter1;
                }
            }
        }

        return sum;
    }

    public static void incrementData(int i, String s, Map<Character, Integer> result) {
        if(i < s.length()) {
            Integer count = result.get(s.charAt(i));
            if(count == null) {
                result.put(s.charAt(i), 1);
            } else {
                result.put(s.charAt(i), count+1);
            }
        }
    }

    /**
     * Ticket numbers usually consist of an even number of digits. A ticket number is considered lucky if the sum of
     * the first half of the digits is equal to the sum of the second half.

     Given a ticket number n, determine if it's lucky or not.

     Example

     For n = 1230, the output should be
     isLucky(n) = true;
     For n = 239017, the output should be
     isLucky(n) = false.
     Input/Output

     [execution time limit] 3 seconds (java)

     [input] integer n

     A ticket number represented as a positive integer with an even number of digits.

     Guaranteed constraints:
     10 ≤ n < 106.

     [output] boolean

     true if n is a lucky ticket number, false otherwise.
     * @param n
     * @return
     */
    public static boolean isLucky(int n) {
        char[] number = String.valueOf(n).toCharArray();

        int firstHalf = 0;
        for(int i=0; i<number.length/2; i++) {
//            System.out.print(number[i]);
            firstHalf += Integer.valueOf(number[i]);
        }
        System.out.println();
        int secondHalf = 0;
        for(int i=number.length/2; i<number.length; i++) {
//            System.out.print(number[i]);
            secondHalf += Integer.valueOf(number[i]);
        }

        return firstHalf == secondHalf;
    }

    /**
     * Some people are standing in a row in a park. There are trees between them which cannot be moved.
     * Your task is to rearrange the people by their heights in a non-descending order without moving the trees.

     Example

     For a = [-1, 150, 190, 170, -1, -1, 160, 180], the output should be
     sortByHeight(a) = [-1, 150, 160, 170, -1, -1, 180, 190].

     Input/Output

     [execution time limit] 3 seconds (java)

     [input] array.integer a

     If a[i] = -1, then the ith position is occupied by a tree. Otherwise a[i] is the height of a person standing
     in the ith position.

     Guaranteed constraints:
     5 ≤ a.length ≤ 15,
     -1 ≤ a[i] ≤ 200.

     [output] array.integer

     Sorted array a with all the trees untouched.
     * @param a
     * @return
     */
    public static int[] sortByHeight(int[] a) {
        List<Integer> people = new ArrayList<>();
        for(int i=0; i<a.length; i++) {
            if(a[i] > -1) {
                people.add(a[i]);
            }
        }
        Collections.sort(people);
        for(int i=0; i<a.length; i++) {
            if(a[i] > -1) {
                a[i] = people.remove(0);
            }
        }
        return a;
    }

    /**
     * You have a string s that consists of English letters, punctuation marks, whitespace characters, and brackets.
     * It is guaranteed that the parentheses in s form a regular bracket sequence.

     Your task is to reverse the strings contained in each pair of matching parentheses, starting from the innermost
     pair. The results string should not contain any parentheses.

     Example

     For string s = "a(bc)de", the output should be
     reverseParentheses(s) = "acbde".

     * @param s
     * @return
     */
    public static String reverseParentheses(String s) {
        List<Integer> index = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            }
            if(s.charAt(i) == ')') {
                index.add(stack.pop());
                index.add(i);
            }
        }

        while(index.size() > 0) {
            int start = index.remove(0);
            int end = index.remove(0);

            StringBuilder middle = new StringBuilder(s.substring(start, end+1)).reverse();
            String first = s.substring(0, start);
            String last = s.substring(end+1, s.length());
            s = first+middle+last;
        }
        return s.replaceAll("\\(","").replaceAll("\\)", "");
    }
}

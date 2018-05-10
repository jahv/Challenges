package codefight.arcade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
}

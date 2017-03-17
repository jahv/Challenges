package hackerranck.ns.contest.w5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by ahernandez on 3/16/17.
 */
public class RepeatString3 {

    public static int maximalLength(String s) {
        int maximalLength = 0;
        s = removeCharactersWithOneIncidence(s);
        for (String substring : substringSet(s)) {
            if (substring.length() > maximalLength && isSquare(substring)) {
                maximalLength = Math.max(substring.length(), maximalLength);
            }
        }
        return maximalLength;
    }

    /**
     * Remove character with single occurrence.
     * @param s - String to be checked.
     * @return
     */
    private static String removeCharactersWithOneIncidence(String s) {
        Map<Character, Integer> characterFrequency = new HashMap<>();
        for(Character c: s.toCharArray()) {
            if(characterFrequency.get(c) == null) {
                characterFrequency.put(c, 1);
            } else {
                characterFrequency.put(c, characterFrequency.get(c) + 1);
            }
        }
        for(Character c: s.toCharArray()) {
            if(characterFrequency.get(c) == 1) {
                s = s.replace("" + c, "");
            }
        }
        return s;
    }

    private static boolean isSquare(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() / 2 + i)) {
                return false;
            }
        }
        return true;
    }

    private static Set<String> substringSet(String s) {
        Set<String> substringSet = new HashSet<>();
        if (s.length() <= 1) {
            substringSet.add(s);
            return substringSet;
        }
        Set<String> s1Set = substringSet(s.substring(0, 1));
        Set<String> s2Set = substringSet(s.substring(1));
        substringSet.addAll(s1Set);
        substringSet.addAll(s2Set);
        for (String s1 : s1Set) {
            for (String s2 : s2Set) {
                substringSet.add(s1 + s2);
            }
        }
        return substringSet;
    }



    public  static int maximalLength1(String s) {
        Set<Character> u = new HashSet<>();
        Set<Character> d = new HashSet<>();
        int[] c = new int[26];
        StringBuilder sb = new StringBuilder();
        int count = 0;
        char prev = ' ';
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            c[a- 'a']++;
            if (!u.add(s.charAt(i))) {
                count++;
                d.add(s.charAt(i));
                sb.append(s.charAt(i));
            } else {

            }
            prev = a;
        }
        System.out.println(sb.toString());
        Arrays.sort(c);
        System.out.println(Arrays.toString(c)+ " " + s.length());
        System.out.println("---------------------");


        return count*2;
    }

    public static int maximalLength0(String s) {
        Set<Character> u = new HashSet<>();
        Set<Character> d = new HashSet<>();
        int[] c = new int[26];
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            c[a- 'a']++;
            if (!u.add(s.charAt(i))) {
                count++;
                d.add(s.charAt(i));
                sb.append(s.charAt(i));
            } else {

            }
        }
//        System.out.println(sb.toString());
//        System.out.println(Arrays.toString(c));
//        System.out.println("---------------------");


        return count*2;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String data = scan.nextLine();
        System.out.println(maximalLength(data));
    }
}

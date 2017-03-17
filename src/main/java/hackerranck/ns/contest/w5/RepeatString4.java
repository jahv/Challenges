package hackerranck.ns.contest.w5;

import java.util.Scanner;

/**
 * Created by ahernandez on 3/16/17.
 */
public class RepeatString4 {
    public static int maximalLength(String s) {
        if (s.length() == 1) return 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            max = Math.max(max, lcs(s.substring(0, i + 1), s.substring(i + 1, s.length())));
        }
        return max * 2;
    }

    private static int lcs(String x, String y) {
//        System.out.printf("%s  %s\n", x, y);
        for(char c : x.toCharArray()) {
            System.out.printf("%2s", c);
        }
        System.out.println();

        for(char c : x.toCharArray()) {
            char sx = ' ';
            System.out.printf("%2s", sx);
        }
        for(char c : y.toCharArray()) {
            System.out.printf("%2s", c);
        }
        System.out.println("\n--------------------------------");

        int[][] dp = new int[x.length() + 1][y.length() + 1];
        int max = 0;
        for (int i = 1; i <= x.length(); i++) {
            for (int j = 1; j <= y.length(); j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        for (int i = 1; i <= x.length(); i++) {
            for (int j = 1; j <= y.length(); j++) {
                System.out.printf("%2d", dp[i][j]);
            }
            System.out.println();
        }
        System.out.println("=================================");
        return max;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String data = scan.nextLine();
        System.out.println(maximalLength(data));
    }

}

package main.java.hackerramck.A_30_DaysOfCodeChallenge;

import java.util.Scanner;

/**
 * Created by ahernandez on 7/14/16.
 */
public class Day_3_IntroConditional {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        String ans = "";

        // if 'n' is NOT evenly divisible by 2 (i.e.: n is odd)
        if (n % 2 == 1) {
            ans = "Weird";
        } else {
            if(n >= 2 && n <= 5) {
                ans = "Not Weird";
            } else if(n >= 6 && n <= 20) {
                ans = "Weird";
            } else {
                ans = "Not Weird";
            }
        }
        System.out.println(ans);
    }
}

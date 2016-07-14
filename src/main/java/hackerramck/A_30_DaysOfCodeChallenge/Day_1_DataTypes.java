package main.java.hackerramck.A_30_DaysOfCodeChallenge;

import java.util.Scanner;

/**
 * Created by ahernandez on 7/14/16.
 */
public class Day_1_DataTypes {

    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";
        Scanner scan = new Scanner(System.in);

        int i2;
        double d2;
        String s2;


        i2 = scan.nextInt();
        d2 = scan.nextDouble();
        scan.nextLine();
        s2 = scan.nextLine();
        scan.close();

        System.out.println(i + i2);
        System.out.println(d + d2);
        System.out.println(s + s2);

    }
}

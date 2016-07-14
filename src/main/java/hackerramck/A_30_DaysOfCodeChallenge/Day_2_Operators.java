package main.java.hackerramck.A_30_DaysOfCodeChallenge;

import java.util.Scanner;

/**
 * Created by ahernandez on 7/14/16.
 */
public class Day_2_Operators {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double mealCost = scan.nextDouble(); // original meal price
        int tipPercent = scan.nextInt(); // tip percentage
        int taxPercent = scan.nextInt(); // tax percentage
        scan.close();

        double tip = mealCost * tipPercent / 100;
        double tax = mealCost * taxPercent / 100;

        double totalCostPrev = mealCost + tip + tax;
        int totalCost = (int) Math.round(totalCostPrev);

        System.out.println("The total meal cost is " + totalCost + " dollars.");

    }
}

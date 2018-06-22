package hackerranck.tutorials;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TenDaysStatistics {

    private static final String Q1 = "Q1";
    private static final String Q2 = "Q2";
    private static final String Q3 = "Q3";

    public static double mean(int[] numbers) {
        double mean = 0.0;
        for(int i=0; i<numbers.length; i++) {
            mean += numbers[i];
        }
        return mean / numbers.length;
    }

    public static double median(int[] numbers) {
        Arrays.sort(numbers);
        int mid = numbers.length/2;
        if(numbers.length % 2 == 0) {
            return (numbers[mid] + numbers[mid-1]) / 2.0;
        } else {
            return numbers[mid];
        }
    }

    public static int mode(int[] numbers) {
        Arrays.sort(numbers);
        int mode = numbers[0];
        int c1 = 1;
        int c2 = 1;
        for (int i=1; i<numbers.length; i++) {
            if(numbers[i] == numbers[i-1]) {
                c2++;
            } else {
                c2 = 1;
            }

            if(c2 > c1) {
                c1 = c2;
                mode = numbers[i];
            }
        }
        return mode;
    }

    public static double meanWeight(int numbers[], int weights[]) {
        double numbersByWeightsSum = 0.0;
        double weightsSum = 0.0;
        for(int i=0; i<numbers.length; i++) {
            numbersByWeightsSum += numbers[i] * weights[i];
            weightsSum += weights[i];
        }

        return numbersByWeightsSum / weightsSum;
    }

    public static Map<String, Double> quartiles(int numbers[]) {
        double q2 = median(numbers);
        int mid = numbers.length/2;
        int halfDown[];
        int halfUp[];

        if(numbers.length % 2 == 0) {
            halfDown = Arrays.copyOfRange(numbers, 0, mid);
            halfUp = Arrays.copyOfRange(numbers, mid, numbers.length);
        } else {
            halfDown = Arrays.copyOfRange(numbers, 0, mid);
            halfUp = Arrays.copyOfRange(numbers, mid + 1, numbers.length);
        }

        double q1 = median(halfDown);
        double q3 = median(halfUp);

        Map<String, Double> results = new HashMap<>();
        results.put(Q1, q1);
        results.put(Q2, q2);
        results.put(Q3, q3);

        return results;
    }

    public static double interquartileRange(int numbers[]) {
        Map<String, Double> quartiles = quartiles(numbers);
        double q1 = quartiles.get(Q1);
        double q3 = quartiles.get(Q3);
        return q3 - q1;
    }

    public static double standardDeviation(int numbers[]) {
        double mean = mean(numbers);

        double avgSquaredDistance = 0.0;
        for(int i=0; i<numbers.length; i++) {
            avgSquaredDistance += Math.pow(numbers[i]-mean, 2);
        }

        avgSquaredDistance = avgSquaredDistance / numbers.length;
        return Math.sqrt(avgSquaredDistance);
    }

    public static void day0_mean_median_mode() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        String numbersStr = scan.nextLine();
        scan.close();

        int numbers[] = Arrays.stream(numbersStr.split(" ")).mapToInt(Integer::parseInt).toArray();

        double mean = mean(numbers);
        double median = median(numbers);
        int mode = mode(numbers);

        System.out.printf("%.1f\n", mean);
        System.out.printf("%.1f\n", median);
        System.out.printf("%d", mode);
    }

    public static void day0_weightedMean() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        String numbersStr = scan.nextLine();
        String weightsStr = scan.nextLine();
        scan.close();

        int numbers[] = Arrays.stream(numbersStr.split(" ")).mapToInt(Integer::parseInt).toArray();
        int weights[] = Arrays.stream(weightsStr.split(" ")).mapToInt(Integer::parseInt).toArray();

        double meanWeight = meanWeight(numbers, weights);

        System.out.printf("%.1f\n", meanWeight);
    }

    public static void day1_quartiles() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        String numbersStr = scan.nextLine();
        scan.close();

        int numbers[] = Arrays.stream(numbersStr.split(" ")).mapToInt(Integer::parseInt).toArray();

        Map<String, Double> quartiles = quartiles(numbers);

        System.out.printf("%.0f\n", quartiles.get(Q1));
        System.out.printf("%.0f\n", quartiles.get(Q2));
        System.out.printf("%.0f\n", quartiles.get(Q3));
    }

    public static void day1_interquartile_range() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        String numbersStr = scan.nextLine();
        String frequencyStr = scan.nextLine();
        scan.close();

        int numbers[] = Arrays.stream(numbersStr.split(" ")).mapToInt(Integer::parseInt).toArray();
        int frequency[] = Arrays.stream(frequencyStr.split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> finalNumbers = new ArrayList<>();

        for(int i=0; i<numbers.length; i++) {
            for(int j=0; j<frequency[i]; j++) {
                finalNumbers.add(numbers[i]);
            }
        }

        double interquartileRange = interquartileRange(finalNumbers.stream().mapToInt(i -> i).toArray());

        System.out.printf("%.1f\n", interquartileRange);
    }

    public static void day1_standard_deviation() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        String numbersStr = scan.nextLine();
        scan.close();

        int numbers[] = Arrays.stream(numbersStr.split(" ")).mapToInt(Integer::parseInt).toArray();

        double standardDeviation = standardDeviation(numbers);

        System.out.printf("%.1f", standardDeviation);
    }

    public static void main(String[] args) {
//        day0_mean_median_mode();
//        day0_weightedMean();
//        day1_quartiles();
//        day1_interquartile_range();
        day1_standard_deviation();
    }
}

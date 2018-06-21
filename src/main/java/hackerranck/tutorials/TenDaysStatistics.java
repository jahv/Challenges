package hackerranck.tutorials;

import java.util.Arrays;
import java.util.Scanner;

public class TenDaysStatistics {

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

    public static void day0_mean_median_mode() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        String numbersStr = scan.nextLine();
        scan.close();

        int[] numbers = Arrays.stream(numbersStr.split(" ")).mapToInt(Integer::parseInt).toArray();

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

        int[] numbers = Arrays.stream(numbersStr.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] weights = Arrays.stream(weightsStr.split(" ")).mapToInt(Integer::parseInt).toArray();

        double meanWeight = meanWeight(numbers, weights);

        System.out.printf("%.1f\n", meanWeight);
    }

    public static void main(String[] args) {
//        day0_mean_median_mode();
        day0_weightedMean();
    }
}

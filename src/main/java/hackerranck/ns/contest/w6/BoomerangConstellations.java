package hackerranck.ns.contest.w6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by ahernandez on 3/22/17.
 */
public class BoomerangConstellations {

    public static double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1, 2));
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        scan.nextLine();

        int[][] constellation = new int[N][2];

        for(int i=0; i<N; i++) {
            String data = scan.nextLine();
            String[] numbers = data.split(" ");
            int xi = Integer.valueOf(numbers[0]);
            int yi = Integer.valueOf(numbers[1]);
            constellation[i][0] = xi;
            constellation[i][1] = yi;
        }

        int[] x = new int[N];
        int[] y = new int[N];
        Map<String, Double> counter2 = new HashMap<>();
        Map<Double, Integer> counter = new HashMap<>();
        for(int i=0; i<N; i++) {
            System.out.printf("Working: %d,%d\n",constellation[i][0], constellation[i][1]);
            x[i] = constellation[i][0];
            y[i] = constellation[i][1];
            for(int j=i+1; j<N; j++) {
                double distance = getDistance(constellation[i][0], constellation[i][1], constellation[j][0], constellation[j][1]);
                System.out.printf("\t Distance to: %d,%d: %f\n", constellation[j][0], constellation[j][1],distance);

                String key = constellation[i][0] + "," + constellation[i][1] + "," + constellation[j][0] + "," + constellation[j][1];
                counter2.put(key, distance);



                System.out.println(key);
//                Integer count = counter.get(distance);
//                if(count == null) {
//                    counter.put(distance, 1);
//                } else {
//                    counter.put(distance, count+1);
//                }

                Integer count = counter.get(distance);
                if(count == null) {
                    counter.put(distance, 1);
                } else {
                    counter.put(distance, count+1);
                }

            }
        }

        System.out.println(N);
        for(int i=0; i<N; i++) {
            System.out.printf("%d %d\n", constellation[i][0], constellation[i][1]);
        }

        System.out.println(counter);

        List<Integer> totals = new ArrayList<>(counter.values());
        System.out.println(totals);
        Collections.sort(totals);
        System.out.println(totals);
        System.out.println(totals.get(totals.size()-1));
        System.out.println(counter2);
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));

        for (int i=0; i<N; i++) {
            String pattern = x[i]+","+y[i];
            for(String key : counter2.keySet()) {
                if(key.contains(pattern)) {

                }
            }
        }

    }

}

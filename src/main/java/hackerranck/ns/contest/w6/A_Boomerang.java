package hackerranck.ns.contest.w6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * Created by ahernandez on 3/22/17.
 */
public class A_Boomerang {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();
        int x[] = new int[N];
        int y[] = new int[N];
        for (int i=0; i<N; i++) {
            x[i] = scan.nextInt();
            y[i] = scan.nextInt();
            scan.nextLine();
        }
        long total = 0;
        for (int i=0; i<N; i++) {
            Map<Double, Integer> counter = new HashMap<>();
//            System.out.printf("Working: %d,%d\n", x[i], y[i]);
            for (int j=0; j<N; j++) {
                if (i != j) {
//                    System.out.printf("\t Distance to: %d,%d", x[j], y[j]);
                    int dx = x[i] - x[j];
                    int dy = y[i] - y[j];
                    double dist = Math.sqrt(dx*dx + dy*dy);
//                    System.out.printf(": %d\n", dist);

                    if(counter.get(dist)==null) {
                        counter.put(dist, 1);
                    } else {
                        counter.put(dist, counter.get(dist) + 1);
                    }

//                    System.out.println("\t"+counter);
                    Integer count = counter.get(dist);
                    if (count>1) {
//                        System.out.println("\tCount: "+count);
//                        System.out.println("\tTotal 1: "+total);
                        total -= (count-2) * (count-1);
//                        System.out.println("\tTotal 2: "+total);
                        total += count * (count-1);
//                        System.out.println("\tTotal 3: "+total);
//                        total += count;
                    }
                }
            }

        }
        total /= 2;
        System.out.println(total);
    }
}

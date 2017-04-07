package hackerranck.ns.contest.w6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by ahernandez on 3/22/17.
 */
public class BoomerangConstelation2 {

    public static double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1, 2));
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int x[] = new int[N];
        int y[] = new int[N];
        scan.nextLine();
        for(int i=0; i<N; i++) {
            x[i] = scan.nextInt();
            y[i] = scan.nextInt();
            scan.nextLine();
        }

        for(int i=0; i<N; i++) {

        }

    }




}

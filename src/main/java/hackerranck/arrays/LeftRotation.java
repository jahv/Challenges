package hackerranck.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class LeftRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();

        System.out.println(n);
        System.out.println(d);

        int[] array = new int[n];

        for(int i=0; i<n; i++) {
            array[i] = in.nextInt();
        }

        System.out.println(Arrays.toString(array));

        for(int i=0; i<n; i++) {
            System.out.print(array[(i + d) % (n)] + " ");
        }


    }
}

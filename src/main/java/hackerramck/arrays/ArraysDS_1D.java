package main.java.hackerramck.arrays;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/arrays-ds
 *
 * Created by ahernandez on 7/6/16.
 */
public class ArraysDS_1D {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }

        for(int i = arr.length-1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}

package main.java.hackerramck.arrays;

/**
 * https://www.hackerrank.com/challenges/2d-array
 *
 * Created by ahernandez on 7/6/16.
 */
public class ArrayDS_2D {
    final static private int MIN_INDEX = 1;
    final static private int MAX_INDEX = 6;

    final static private int MIN_VAL = -9;
    final static private int MAX_VAL = 9;

    public static void main(String[] args) {

        final int i = MIN_INDEX + (int)(Math.random() * MAX_INDEX);
        final int j = MIN_INDEX + (int)(Math.random() * MAX_INDEX);
        System.out.println("A[" + i + "][" + j + "]");

        final int[][] matrix = new int[i][j];

        for(int k = 0; k <= matrix.length-1; k++) {
            for(int l = 0; l <= matrix[k].length-1; l++) {
                matrix[k][l] = MIN_VAL + (int)(Math.random() * (MAX_VAL - MIN_VAL + 1));
                System.out.print(matrix[k][l] + "\t");
            }
            System.out.println();
        }



    }

}

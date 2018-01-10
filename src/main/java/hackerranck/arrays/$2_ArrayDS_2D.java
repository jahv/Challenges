package hackerranck.arrays;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/2d-array/problem
 *
 * Created by ahernandez on 7/6/16.
 */
public class $2_ArrayDS_2D {
    final static private int MIN_INDEX = 1;
    final static private int MAX_INDEX = 6;

    final static private int MIN_VAL = -9;
    final static private int MAX_VAL = 9;

    public static void main(String[] args) {

//        final int I = MIN_INDEX + (int)(Math.random() * MAX_INDEX);
//        final int J = MIN_INDEX + (int)(Math.random() * MAX_INDEX);

        Scanner in = new Scanner(System.in);
        int I = 6;//in.nextInt();
        int J = 6;//in.nextInt();
//        System.out.println("A[" + I + "][" + J + "]");

        int[][] matrix = new int[I][J];

        for(int k = 0; k <= matrix.length-1; k++) {
            for(int l = 0; l <= matrix[k].length-1; l++) {
//                matrix[k][l] = MIN_VAL + (int)(Math.random() * (MAX_VAL - MIN_VAL + 1));
                matrix[k][l] = in.nextInt();
//                System.out.print(matrix[k][l] + "\t");
            }
//            System.out.println();
        }

        int max = 0;
        boolean firstRun = true;
        if(I>2 && J>2) {

            for(int i=0; i<I-2; i++) {
                for(int j=0; j<J-2; j++) {
                    int aux = matrix[i][j] + matrix[i][j+1] + matrix[i][j+2];
                    aux += matrix[i+1][j+1];
                    aux += matrix[i+2][j] + matrix[i+2][j+1] + matrix[i+2][j+2];
                    if(firstRun || aux > max) {
                        max = aux;
                        firstRun = false;
                    }
                }
            }
        }

        System.out.println(max);


    }

}

package hackerranck.arrays;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/dynamic-array/problem
 */
public class $3_DynamicArray_notWorked {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int Q = in.nextInt();

//        System.out.println(N);
//        System.out.println(Q);

        int queries[][] = new int[Q][3];
        int sequences[][] = new int[N][Q];
        int seqIndexes[] = new int[N];

        for(int i=0; i<Q; i++) {
            for (int j=0; j<3; j++) {
                queries[i][j] = in.nextInt();
            }
        }

        int lastAnswer = 0;


        //Utils.printMatrix(queries);

        for(int i = 0; i < Q; i++) {
            int queryType = queries[i][0];
            int x = queries[i][1];
            int y = queries[i][2];

            if(queryType == 1) {
                query1(x, y, lastAnswer, N, seqIndexes, sequences);
            } else {
                lastAnswer = query2(x, y, lastAnswer, N, sequences);
                System.out.println(lastAnswer);
            }

        }


    }

    public static void query1(int x, int y, int lastAnswer, int N, int seqIndexes[], int sequences[][]) {
        int seqIndex = (x ^ lastAnswer) % N;
        int currentSeqIndex = seqIndexes[seqIndex];
        sequences[seqIndex][currentSeqIndex] = y;
        seqIndexes[seqIndex] = currentSeqIndex + 1;
    }

    public static int query2(int x, int y, int lastAnswer, int N, int sequences[][]) {
        int seqIndex = (x ^ lastAnswer) % N;
        int indexInSeq = y % 3;
        int value = sequences[seqIndex][indexInSeq];
        return value;

    }


}

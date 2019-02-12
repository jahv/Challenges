package hackerranck.practice.data_structures;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Arrays {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the matchingStrings function below.
    private static int[] matchingStrings(String[] strings, String[] queries) {
        int []results = new int[queries.length];

        int i=0;
        for(String query : queries) {
            int matches = 0;
            for(String string : strings) {
                if(query.equals(string)) {
                    matches++;
                }
            }
            results[i] = matches;
            i++;
        }

        return results;
    }

    static void sparseArrays(String[] args) throws Exception {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] strings = new String[stringsCount];

        for (int i = 0; i < stringsCount; i++) {
            String stringsItem = scanner.nextLine();
            strings[i] = stringsItem;
        }

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] queries = new String[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = scanner.nextLine();
            queries[i] = queriesItem;
        }

        int[] res = matchingStrings(strings, queries);

        for (int i = 0; i < res.length; i++) {
            System.out.println(String.valueOf(res[i]));

            if (i != res.length - 1) {
                System.out.println("\n");
            }
        }

        System.out.println();;


        scanner.close();
    }

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long results[] = new long[n];

        for(int i=0; i<queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            int k = queries[i][2];

            results[a-1] += k;
            if(b < n) {
                results[b] -= k;
            }
        }

        long max = 0;
        long tmp = 0;

        for(int i=0; i<n; i++) {
            tmp += results[i];
            if(tmp > max) {
                max = tmp;
            }
        }

        return max;
    }

    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }

    static void arrayManipulation(String[] args) {
        System.out.println("Init: " + getCurrentTimeStamp());
        String[] nm = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[][] queries = new int[m][3];

        System.out.println("Read: " + getCurrentTimeStamp());
        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        System.out.println("call: " + getCurrentTimeStamp());
        long result = arrayManipulation(n, queries);
        System.out.println("end: " + getCurrentTimeStamp());
        System.out.println(String.valueOf(result));
        scanner.close();
    }

    public static void main(String[] args) throws Exception {
//        sparseArrays(args);

        arrayManipulation(args);
    }
}

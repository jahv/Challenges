package codefight.arcade;

public class $4_ExploringTheWaters {

    /**
     * Several people are standing in a row and need to be divided into two teams. The first person goes into team 1,
     * the second goes into team 2, the third goes into team 1 again, the fourth into team 2, and so on.

     You are given an array of positive integers - the weights of the people. Return an array of two integers, where
     the first element is the total weight of team 1, and the second element is the total weight of team 2 after the
     division is complete.

     Example

     For a = [50, 60, 60, 45, 70], the output should be
     alternatingSums(a) = [180, 105].

     * @param a
     * @return
     */
    public static int[] alternatingSums(int[] a) {
        int wA = 0;
        int wB = 0;

        for(int i=0; i<a.length; i++) {
            if(i%2==0) {
                wA += a[i];
            } else {
                wB += a[i];
            }
        }

        return new int[]{wA, wB};
    }

    /**
     * Given a rectangular matrix of characters, add a border of asterisks(*) to it.

     Example

     For

     picture = [    "abc",
                    "ded"]

     the output should be

     addBorder(picture) = [ "*****",
                            "*abc*",
                            "*ded*",
                            "*****"]
     * @param picture
     * @return
     */
    public static String[] addBorder(String[] picture) {
        String bordered[] = new String[picture.length+2];
        bordered[0] = String.format("%" + (picture[0].length()+2) + "s", "*" ).replace(" ", "*");
        bordered[bordered.length-1] = bordered[0];
        for(int i=0; i<picture.length; i++) {
            bordered[i+1] = "*" + picture[i] + "*";
        }
        return bordered;
    }

    /**
     * Two arrays are called similar if one can be obtained from another by swapping at most one pair of elements in one of the arrays.
     *
     * Given two arrays a and b, check whether they are similar.
     *
     * Example
     *
     * For a = [1, 2, 3] and b = [1, 2, 3], the output should be
     * areSimilar(a, b) = true.
     *
     * The arrays are equal, no need to swap any elements.
     *
     * For a = [1, 2, 3] and b = [2, 1, 3], the output should be
     * areSimilar(a, b) = true.
     *
     * We can obtain b from a by swapping 2 and 1 in b.
     *
     * For a = [1, 2, 2] and b = [2, 1, 1], the output should be
     * areSimilar(a, b) = false.
     *
     * Any swap of any two elements either in a or in b won't make a and b equal.
     *
     * Input/Output
     *
     * [execution time limit] 3 seconds (java)
     *
     * [input] array.integer a
     *
     * Array of integers.
     *
     * Guaranteed constraints:
     * 3 ≤ a.length ≤ 105,
     * 1 ≤ a[i] ≤ 1000.
     *
     * [input] array.integer b
     *
     * Array of integers of the same length as a.
     *
     * Guaranteed constraints:
     * b.length = a.length,
     * 1 ≤ b[i] ≤ 1000.
     *
     * [output] boolean
     *
     * true if a and b are similar, false otherwise.
     * @param a
     * @param b
     * @return
     */
    public static boolean areSimilar(int[] a, int[] b) {
        boolean swap = false;
        for(int i=0; i<a.length; i++) {

            if(a[i] != b[i]) {
                if(swap) {
                    return false;
                }
                swap = true;
                if(!similarBySwap(a, b, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean similarBySwap(int[] a, int[] b, int i) {
        if(i == a.length-1) {
            return false;
        }

        return a[i] == b[i+1] && a[i+1] == b[i];
    }


}

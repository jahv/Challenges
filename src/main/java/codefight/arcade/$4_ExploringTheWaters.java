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
}

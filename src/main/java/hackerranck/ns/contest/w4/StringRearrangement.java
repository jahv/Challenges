package hackerranck.ns.contest.w4;


import java.util.Arrays;
import java.util.Scanner;

public class StringRearrangement {

    public static boolean keepPermuting = true;
    public static boolean finalResult = false;

    public static boolean differOfOneChar(String str1, String str2) {
        if(str1.length() != str2.length()) {
            return false;
        }
        int difference = 0;
        for(int i=0; i<str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                difference++;
            }
            if(difference > 1) {
                return false;
            }
        }
        if(difference==0) {
            return false;
        }
        return true;
    }

    public static boolean verifyDifference(String[] list) {
        for(int i=0; i<list.length-1; i++) {
            if(!differOfOneChar(list[i], list[i+1])) {
                return false;
            }
        }
        return true;
    }

    static void permute(String[] arr, int k){
        if(keepPermuting) {
            for (int i = k; i < arr.length; i++) {
                swap(arr, i, k);
                permute(arr, k + 1);
                swap(arr, k, i);
            }
            if (k == arr.length - 1) {
                //System.out.println(Arrays.toString(arr));
                if (verifyDifference(arr)) {
                    keepPermuting = false;
                    finalResult = true;
                    System.out.println(true);
                }
            }
        }
    }

    public static void swap(String[] list, int i, int k) {
        String bkp = list[i];
        list[i] = list[k];
        list[k] = bkp;
    }


    public static void main(String[] args) {
        //permute(new String[]{"aa", "ab"} , 0);
        Scanner scan = new Scanner(System.in);
        String data = scan.nextLine();
        String[] list = data.split(",");
        //System.out.println(Arrays.toString(list));
        Arrays.sort(list);
        //System.out.println(Arrays.toString(list));
        //System.out.println(verifyDifference(list));
        permute(list, 0);
        if(!finalResult) {
            System.out.println(false);
        }
    }
}

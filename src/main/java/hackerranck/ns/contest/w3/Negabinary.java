package hackerranck.ns.contest.w3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Negabinary {

    public static int getValue(String negabinary) {
        char[] digit = negabinary.toCharArray();
        double result = 0;
        for(int i=0; i<digit.length; i++) {
            //System.out.println(Integer.valueOf(digit[i])+ "*" + ((digit.length - i)-1));
            int exp = (digit.length - i) - 1;
            if(digit[i]=='1') {
                result += (Integer.valueOf(digit[i]) - 48) * Math.pow(-2, exp);
            }
        }
        return (int)result;
    }

    public static String oddOccurrence(List<String> elements) {
        Map<String, Long> occurrence = elements.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for(String key : occurrence.keySet()) {
            if(occurrence.get(key) % 2 != 0) {
                return key;
            }
        }
        return null;
    }

    public static String getNegabinary(int d) {
        if(d==0) {
            return "0";
        }

        String result = "";
        while(d != 0) {
            int remainder = d % -2;
            d = d / -2;
            if(remainder < 0) {
                remainder += 2;
                d += 1;
            }
                result = remainder + result;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String data = scan.nextLine();
        //if(!data.isEmpty() && data.length() < Math.pow(10, 5)) {
            List<String> elements = new ArrayList<>();
            String[] elementsArray = data.split(" ");
            for (String element : elementsArray) {
                elements.add(element);
            }
            //if (!elements.isEmpty() && elements.size() < Math.pow(10, 5)) {
                String oddOccurrence = oddOccurrence(elements);
                if (oddOccurrence != null) {
                    int value = getValue(oddOccurrence);
                    String negabinary = getNegabinary(-value);
                    System.out.println(negabinary);
                }
            //}
        //}
    }
}

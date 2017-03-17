package hackerranck.ns.contest.w5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ahernandez on 3/15/17.
 */
public class RepeatString {

    public static int trues = 0;
    public static List<String> analized = new ArrayList<>();

    public static int find(String s) {
        int startIndex = 0;
        int max = 0;
        int index = 0;

        StringBuffer beginning = new StringBuffer(s.substring(0, startIndex + 1));
        StringBuffer ending = new StringBuffer((s.substring(startIndex +1)));

        while(startIndex < s.length()-1) {

            Pattern p = Pattern.compile(beginning.toString());
            Matcher m = p.matcher(ending.toString());
            boolean b = m.find();
            System.out.println(beginning + "->" + ending + ":" + b + ", " + startIndex + ", " + index);

            char charAt0 = ending.charAt(0);

            if (b) {
                index++;
                max = startIndex;
                beginning.append(charAt0);
                ending.deleteCharAt(0);
            }else {

                System.out.println(index);
                beginning.insert(index-1, ".*");
                char end = beginning.charAt(beginning.length()-1);
                ending.insert(0, end);
                beginning.deleteCharAt(beginning.length()-1);
                System.out.println(end);
                System.out.println(">> " + beginning);
                System.out.println(">> " + ending);

//                int index = beginning.length()-1;
//                beginning.deleteCharAt(index);
//                beginning.insert(index, ".*");
//                ending.deleteCharAt(0);
//                beginning.append(charAt0);


//                if(beginning.length() == 1) {
//                    ending.deleteCharAt(0);
//                    beginning.deleteCharAt(beginning.length()-1).append(".*").append(charAt0);
//                } else {
//                    beginning.insert(beginning.length() - 1, ".*");
//                }


            }

            startIndex++;
        }
        System.out.println("max: " + max*2);
        System.out.println("################");
        return max*2;

    }

    public static void analize2(String s) {
        int startIndex = 0;
        int max = 0;
        int index = 0;
        int counterFalse = 0;

        StringBuffer beginning = new StringBuffer(s.substring(0, startIndex + 1));
        StringBuffer ending = new StringBuffer((s.substring(startIndex +1)));

        while(startIndex < s.length()-2) {
            Pattern p = Pattern.compile(beginning.toString());
            Matcher m = p.matcher(ending.toString());
            boolean b = m.find();
            System.out.println(beginning + "->" + ending + ":" + b);

            char charAt0 = ending.charAt(0);

            if (b) {
                index++;
                max = index;
                beginning.append(charAt0);
                ending.deleteCharAt(0);
                counterFalse=0;
            } else {

                if (beginning.length() == 1) {
                    beginning = new StringBuffer().append(charAt0);
                    ending.deleteCharAt(0);
                } else {
                    if(counterFalse==0) {
                        beginning.insert(beginning.length() - 1, ".*");
                    } else {
                        beginning.deleteCharAt(beginning.length() - 1).append(".*").append(charAt0);
                        ending.deleteCharAt(0);
                    }
                }
                counterFalse++;
            }

            System.out.println("Max: " + max);
            startIndex++;
        }

        System.out.println(max*2);
        System.out.println("#############");
    }

//    public static void analize3(String s) {
    public static void analize3(StringBuffer start, StringBuffer end, int i) {
        System.out.println("JAHV: " + trues);
//        int i = 0;
//        int falseCounter = 0;
//        StringBuffer start = new StringBuffer(s.substring(0, i + 1));
//        StringBuffer end = new StringBuffer((s.substring(i +1)));

        while(end.length() >= 1) {
//            if (falseCounter > 2) {
//                break;
//            }
            int lastStart = start.lastIndexOf("*");
//            frankfurt

            Pattern p = Pattern.compile(start.toString());
            Matcher m = p.matcher(end.toString());
            boolean b = m.find();
            System.out.format("%s -> %s: %s\n", start, end, b);

            char next = end.charAt(0);
            if (b) {
                start.append(next);
                end.deleteCharAt(0);
                System.out.println();
                i++;
                if(i>trues) {
                    trues=i;
                }

            } else {

                if(start.length()==1) {
                    start.append(next).deleteCharAt(0);
                    end.deleteCharAt(0);
                } else {
                        start.insert(start.length() - 1, ".*");
                        System.out.println("trabajar: ");
                        System.out.println(">>" + start);
                        System.out.println(">>" + end);
                        analize3(start, end, i);

                        char endChar = start.charAt(start.length()-1);
                        start.delete(start.length()-3, start.length());
                        start.append(endChar);
                        start.append(next);
                        end.deleteCharAt(0);
                    System.out.println("trabajar: ");
                    System.out.println(">>" + start);
                    System.out.println(">>" + end);
                    analize3(start, end, i);
                }
                break;
            }
        }

    }

    public static void analize4(StringBuilder head, StringBuilder tail, int counter) {
        if((tail.length() > 0)){
            head = removeDuplicatedWildCards(head);
            if(analized.contains(head.toString())) {
                System.out.println(head + "Already procesed");
               return;
            }
            analized.add(head.toString());
//            if((head.length() > 2) && head.charAt(head.length()-2)=='*' && head.charAt(head.length()-4)=='*') {
//                return;
//            }


            Pattern p = Pattern.compile(head.toString());
            Matcher m = p.matcher(tail.toString());
            boolean b = m.find();

            System.out.format("%s -> %s: %s - %d - %d\n", head, tail, b, counter, trues);

            char next = tail.charAt(0);

            if(b) {
                counter++;
                if(counter > trues) {
                    trues=counter;
                }
                head.append(next);
                tail.deleteCharAt(0);
                analize4(head, tail, counter);
            } else {
                if(head.length()==1) {
                    head.append(next).deleteCharAt(0);
                    tail.deleteCharAt(0);
                    analize4(head, tail, counter);
                } else {
                    StringBuilder head1 = new StringBuilder(head);
                    StringBuilder tail1 = new StringBuilder(tail);

                    head.insert(head.length()-1, ".*");
                    analize4(head, tail, counter);

                    head1.deleteCharAt(head1.length()-1).append(".*").append(next);
                    tail1.deleteCharAt(0);
                    analize4(head1, tail1, counter);
                }
            }

        }
    }

    public static boolean hasDuplicatedWildCards(StringBuilder input) {
        return input.indexOf(".*.*") < 0 ? false : true;
    }

    public static StringBuilder removeDuplicatedWildCards(StringBuilder input) {
        while (hasDuplicatedWildCards(input)) {
            int index = input.indexOf(".*.*");
            input.deleteCharAt(index);
            input.deleteCharAt(index);
        }
        return input;
    }


    public static void getMax(StringBuilder head, StringBuilder tail, int counter) {
        while (tail.length() > 0) {
            if(isHeadInTail(head, tail)) {
                char next = tail.charAt(0);
                head.append(next);
                tail.deleteCharAt(0);
                break;
            }
        }
    }

    public static boolean isHeadInTail(StringBuilder head, StringBuilder tail) {
        StringBuilder headBkp = new StringBuilder(head);
        StringBuilder tailBkp = new StringBuilder(tail);
        int counter=0;
        for(int i=0; i<headBkp.length(); i++) {
            char c = tailBkp.charAt(0);
//            System.out.printf("Checking: %s [%s:%d] -> %s\n", headBkp,headBkp.charAt(i),i, tailBkp);
            StringBuilder checkHead = new StringBuilder(headBkp);
            StringBuilder checkTail = new StringBuilder(tailBkp);
            checkHead.insert(i, "[").insert(i+2, "]");
            checkTail.insert(0, "[").insert(2,"]");
            System.out.printf("%s (%s)->(%s) %s\n", checkHead, headBkp.charAt(i), c, checkTail);
            if(headBkp.charAt(i) == c) {
                counter++;
                if(counter == headBkp.length()) {
                    System.out.println(counter);
                    return true;
                }
            } else {
                i--;
            }
            tailBkp.deleteCharAt(0);
            if(tailBkp.length()==0) {
                break;
            }
        }
        System.out.println("sss" +counter);
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String data = scan.nextLine();
        int result = find(data);
        System.out.println(result);
    }
}

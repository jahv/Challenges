package codefigths.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DailyChallenges {

    /**
     * As you may know, Bart has recently (painstakingly) ensured that every seat at his round poker table has the same
     * number of poker chips. But unbelievably, when Bart’s back was turned, someone redistributed all the chips again
     * such each seat does not have the same amount of chips! Bart needs to restore the balance of his table—quickly.
     * Fortunately, with the practice he gained from the last incident, Bart no longer needs to move poker chips one at
     * a time. He can now move all of the desired chips from one pile to an adjacent pile in one fell swoop!
     * (He still only moves chips between adjacent seats, to be safe.) Given Bart’s impressive new skill, what is the
     * minimum number of chip moves Bart will need to make to once again distribute the chips evenly?

     Example
     For chips = [4, 5, 6, 10, 5], the output should be pokerChips2(chips) = 3.

     The array represents a circular table, so we are permitted to move chips between the last and the first index in t
     he array. Thus Bart can bring the chips back to equilibrium with the following 3 steps (1-indexed):

     move 3 chips from seat 5 to seat 1;
     move 4 chips from seat 4 to seat 5;
     move 1 chip from seat 1 to seat 2.
     After this sequence of 3 moves, each seat will have 6 chips, and there is no sequence of fewer moves doing the same.

     Input/Output

     [execution time limit] 3 seconds (java)

     [input] array.integer chips

     The chip counts of each seat.

     Guaranteed constraints:
     0 ≤ chips.length ≤ 106,
     0 ≤ chips[i] ≤ 105.

     [output] integer

     The minimum number of moves required to restore the chip counts.
     * @param chips
     * @return
     */
    public static int pokerChips2(int[] chips) {

        int sum = 0;
        int initial = 0;
        int max = chips[0];

        for(int i=0; i<chips.length; i++) {
            sum += chips[i];
            if(chips[i] > max) {
                max = chips[i];
                initial = i;
            }
        }

        System.out.println("sum: " + sum);
        int chipsPerPlace = sum / chips.length;
        System.out.println("chips per place: " + chipsPerPlace);

//        System.out.println("distance:\n");
//        int minDistance = chipsPerPlace;
//        for(int i=0; i<chips.length; i++) {
//            System.out.print(chips[i] - chipsPerPlace + ", ");
//            if (chips[i] - chipsPerPlace == 0) {
//                initial = i;
//                break;
//            }
//            if(chips[i] - chipsPerPlace > 0 && chips[i] - chipsPerPlace < minDistance) {
//                minDistance = chips[i] - chipsPerPlace;
//                initial = i;
//            }
//        }

        System.out.println("\ninitial: " + initial);
        int end = initial;

        int steps = 0;
        do {
            int dif = chips[initial] - chipsPerPlace;
            int next = initial+1 >= chips.length ? 0 : initial+1;
            if(dif != 0 ){
                if(chips[initial] < chipsPerPlace) {
                    chips[initial] += -dif;
                    chips[next] -= -dif;
                } else {
                    chips[initial] -= dif;
                    chips[next] += dif;
                }
                steps++;
            }
            initial = next;
        } while(initial != end);
        System.out.println(steps);
        return steps;
    }

    public static int pokerChips2V1(int[] chips) {

        int sum = 0;
        for(int i=0; i<chips.length; i++) {
            sum += chips[i];
        }

        System.out.println("sum: " + sum);
        int chipsPerPlace = sum / chips.length;
        System.out.println("chips per place: " + chipsPerPlace);

        System.out.println("distance:\n");

        int minDistance = chipsPerPlace;
        int initial = -1;
        for(int i=0; i<chips.length; i++) {
            System.out.print(chips[i] - chipsPerPlace + ", ");
            if (chips[i] - chipsPerPlace == 0) {
                initial = i;
                break;
            }
            if(chips[i] - chipsPerPlace > 0 && chips[i] - chipsPerPlace < minDistance) {
                minDistance = chips[i] - chipsPerPlace;
                initial = i;
            }
        }

        System.out.println("\ninitial: " + initial);
        int end = initial;

        int steps = 0;
        do {
            int dif = chips[initial] - chipsPerPlace;
            int next = initial+1 >= chips.length ? 0 : initial+1;
            if(dif != 0 ){
                if(chips[initial] < chipsPerPlace) {
                    chips[initial] += -dif;
                    chips[next] -= -dif;
                } else {
                    chips[initial] -= dif;
                    chips[next] += dif;
                }
                steps++;
            }
            initial = next;
        } while(initial != end);
        System.out.println(steps);
        return steps;
    }

    /**
     * We'd like to construct a diverse array of numbers. At each step, we'll be given two choices for the next
     * number we can add, and we'd like to select the number that appears least frequently in our array so far.
     * If both numbers appear with equal frequency, we'll choose the smaller one.

     Our choices will be given in the form of an array, choices, consisting of 2-element arrays of integers.

     Example

     For choices = [[1, 2], [3, 4], [1, 2]], the output should be leastAppearance(choices) = [1, 3, 2].

     Initially, our array is empty, so given the choice between 1 and 2, we'll pick 1 since it's smaller.

     On the next step, our array looks like [1], which doesn't contain 3 or 4, so we'll pick 3 (again, because
     it's smaller than 4).

     On the final step, our array looks like [1, 3], so we'll pick 2 since the array already contains a 1.

     Input / Output

     [execution time limit] 3 seconds (java)

     [input] array.array.integer choices

     An array containing sorted 2-element arrays of integers. Each 2-element array represents the two choices for
     the next number to add to our array of results.

     Guaranteed constraints
     0 ≤ choices.length ≤ 105
     choices[i].length = 2
     choices[i][0] ≤ choices[i][1]
     1 ≤ choices[i][j] ≤ 100

     [output] array.integer

     An array of numbers where each number appears as infrequently as possible up to the index at which it was selected.

     * @param choices
     * @return
     */
    public static int[] leastAppearance(int [][] choices) {

        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> counter = new HashMap<>();

        for(int i=0; i<choices.length; i++) {
            int a = choices[i][0];
            int b = choices[i][1];

            Integer counterA = counter.get(a);
            Integer counterB = counter.get(b);

            if(counterA == null) {
                counterA = 0;
            }

            if(counterB == null) {
                counterB = 0;
            }


            if(counterA == counterB) {
                if(a<b) {
                    result.add(a);
                    counter.put(a, counterA + 1);
                } else {
                    result.add(b);
                    counter.put(b, counterB + 1);
                }
            } else if(counterA < counterB) {
                result.add(a);
                counter.put(a, counterA + 1);
            } else {
                result.add(b);
                counter.put(b, counterB + 1);
            }



        }
        System.out.println(counter);
        System.out.println(result);
        return result.stream().mapToInt(i -> i).toArray();
    }
}

package codefight.arcade;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class $2_EdgeOfTheOcean {

    /**
     * Given an array of integers, find the pair of adjacent elements that has the largest product and return that
     * product.
     * <p>
     * Example
     * <p>
     * For inputArray = [3, 6, -2, -5, 7, 3], the output should be
     * adjacentElementsProduct(inputArray) = 21.
     * <p>
     * 7 and 3 produce the largest product.
     * <p>
     * Input/Output
     * <p>
     * [time limit] 3000ms (java)
     * [input] array.integer inputArray
     * <p>
     * An array of integers containing at least two elements.
     * <p>
     * Guaranteed constraints:
     * 2 ≤ inputArray.length ≤ 10,
     * -1000 ≤ inputArray[i] ≤ 1000.
     * <p>
     * [output] integer
     * <p>
     * The largest product of adjacent elements.
     */
    public static int adjacentElementsProduct(int[] inputArray) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < inputArray.length - 1; i++) {
            if (inputArray[i] * inputArray[i + 1] > max) {
                max = inputArray[i] * inputArray[i + 1];
            }
        }
        return max;
    }

    /**
     * Below we will define an n-interesting polygon. Your task is to find the area of a polygon for a given n.
     * <p>
     * A 1-interesting polygon is just a square with a side of length 1. An n-interesting polygon is obtained by
     * taking the n - 1-interesting polygon and appending 1-interesting polygons to its rim, side by side. You can
     * see the 1-, 2-, 3- and 4-interesting polygons in the picture below.
     * <p>
     * <p>
     * <p>
     * Example
     * <p>
     * For n = 2, the output should be
     * shapeArea(n) = 5;
     * For n = 3, the output should be
     * shapeArea(n) = 13.
     * Input/Output
     * <p>
     * [time limit] 3000ms (java)
     * [input] integer n
     * <p>
     * Guaranteed constraints:
     * 1 ≤ n < 104.
     * <p>
     * [output] integer
     * <p>
     * The area of the n-interesting polygon.
     *
     * @param n
     * @return
     */
    public static int shapeArea(int n) {
        int base = 1;
        int increment = 4;
        int acumulator = 0;
        for (int i = 1; i < n; i++) {
            acumulator += increment;
            base += acumulator;
        }
        return base;
    }

    /**
     * Ratiorg got statues of different sizes as a present from CodeMaster for his birthday, each statue having an
     * non-negative integer size. Since he likes to make things perfect, he wants to arrange them from smallest to
     * largest so that each statue will be bigger than the previous one exactly by 1. He may need some additional
     * statues to be able to accomplish that. Help him figure out the minimum number of additional statues needed.
     * <p>
     * Example
     * <p>
     * For statues = [6, 2, 3, 8], the output should be
     * makeArrayConsecutive2(statues) = 3.
     * <p>
     * Ratiorg needs statues of sizes 4, 5 and 7.
     * <p>
     * Input/Output
     * <p>
     * [time limit] 3000ms (java)
     * [input] array.integer statues
     * <p>
     * An array of distinct non-negative integers.
     * <p>
     * Guaranteed constraints:
     * 1 ≤ statues.length ≤ 10,
     * 0 ≤ statues[i] ≤ 20.
     * <p>
     * [output] integer
     * <p>
     * The minimal number of statues that need to be added to existing statues such that it contains every integer size
     * from an interval [L, R] (for some L, R) and no other sizes.
     *
     * @param statues
     * @return
     */
    public static int makeArrayConsecutive2(int[] statues) {
        List<Integer> list = Arrays.stream(statues).boxed().collect(Collectors.toList());
        Collections.sort(list);
        int start = list.get(0) + 1;
        int missing = 0;
        for (int i = 1; i < list.size(); i++) {
            if (start != list.get(i)) {
                missing++;
                i--;
            }
            start++;
        }
        return missing;
    }

    /**
     * Given a sequence of integers as an array, determine whether it is possible to obtain a strictly increasing
     * sequence by removing no more than one element from the array.
     * <p>
     * Example
     * <p>
     * For sequence = [1, 3, 2, 1], the output should be
     * almostIncreasingSequence(sequence) = false;
     * <p>
     * There is no one element in this array that can be removed in order to get a strictly increasing sequence.
     * <p>
     * For sequence = [1, 3, 2], the output should be
     * almostIncreasingSequence(sequence) = true.
     * <p>
     * You can remove 3 from the array to get the strictly increasing sequence [1, 2]. Alternately, you can remove 2 to
     * get the strictly increasing sequence [1, 3].
     * <p>
     * Input/Output
     * <p>
     * [time limit] 3000ms (java)
     * [input] array.integer sequence
     * <p>
     * Guaranteed constraints:
     * 2 ≤ sequence.length ≤ 105,
     * -105 ≤ sequence[i] ≤ 105.
     * <p>
     * [output] boolean
     * <p>
     * Return true if it is possible to remove one element from the array in order to get a strictly increasing
     * sequence, otherwise return false.
     *
     * @param sequence
     * @return
     */
    public static boolean almostIncreasingSequence(int [] sequence) {
        if (sequence.length <= 2) {
            return true;
        } else {
            Stack<Integer> stack = initStack(sequence[0], sequence[1], sequence[2]);

            if(stack.empty()) {
                return false;
            } else {

                int removed = 3 - stack.size();

                for(int i=3; i<sequence.length; i++) {
                    int last = stack.pop();
                    int oneBeforeLast = stack.pop();

                    if(sequence[i] > oneBeforeLast && sequence[i] > last) {
                        stack.push(last);
                        stack.push(sequence[i]);
                    } else if(sequence[i] > oneBeforeLast) {
                        removed++;
                        stack.push(oneBeforeLast);
                        stack.push(sequence[i]);
                    } else {
                        removed++;
                        stack.push(oneBeforeLast);
                        stack.push(last);
                    }

                    if(removed > 1) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public static Stack<Integer> initStack(int a, int b, int c) {
        Stack<Integer> stack = new Stack<>();

        if (c > b && b > a) {
            stack.push(a);
            stack.push(b);
            stack.push(c);
        } else if (c > b){
            stack.push(b);
            stack.push(c);
        } else if (c > a) {
            stack.push(a);
            stack.push(c);
        } else if (b > a) {
            stack.push(a);
            stack.push(b);
        }
        return stack;
    }

    /**
     * After they became famous, the CodeBots all decided to move to a new building and live together.
     * The building is represented by a rectangular matrix of rooms. Each cell in the matrix contains an integer that
     * represents the price of the room. Some rooms are free (their cost is 0), but that's probably because they are
     * haunted, so all the bots are afraid of them. That is why any room that is free or is located anywhere below a
     * free room in the same column is not considered suitable for the bots to live in.

     Help the bots calculate the total price of all the rooms that are suitable for them.

     Example

     For
     matrix =
     [[0, 1, 1, 2],
     [0, 5, 0, 0],
     [2, 0, 3, 3]]
     the output should be
     matrixElementsSum(matrix) = 9.

     Here's the rooms matrix with unsuitable rooms marked with 'x':

     [[x, 1, 1, 2],
     [x, 5, x, x],
     [x, x, x, x]]
     Thus, the answer is 1 + 5 + 1 + 2 = 9.

     For
     matrix =
     [[1, 1, 1, 0],
     [0, 5, 0, 1],
     [2, 1, 3, 10]]
     the output should be
     matrixElementsSum(matrix) = 9.

     Here's the rooms matrix with unsuitable rooms marked with 'x':

     [[1, 1, 1, x],
     [x, 5, x, x],
     [x, 1, x, x]]
     Note that the free room in the first row make the full column unsuitable for bots.

     Thus, the answer is 1 + 1 + 1 + 5 + 1 = 9.

     Input/Output

     [execution time limit] 3 seconds (java)

     [input] array.array.integer matrix

     A 2-dimensional array of integers representing a rectangular matrix of the building.

     Guaranteed constraints:
     1 ≤ matrix.length ≤ 5,
     1 ≤ matrix[i].length ≤ 5,
     0 ≤ matrix[i][j] ≤ 10.

     [output] integer

     The total price of all the rooms that are suitable for the CodeBots to live in.

     * @param matrix
     * @return
     */
    public static int matrixElementsSum(int[][] matrix) {
        int I = matrix.length;
        int J = matrix[0].length;
        int sum = 0;
        for(int j=0; j<J; j++) {
            for(int i=0;i<I; i++) {
                if(matrix[i][j] == 0) {
                    break;
                } else {
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }

}

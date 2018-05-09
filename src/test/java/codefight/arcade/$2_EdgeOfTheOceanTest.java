package codefight.arcade;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class $2_EdgeOfTheOceanTest {

    @Test
    public void adjacentElementsProductTest() {
        Assert.assertEquals(21, $2_EdgeOfTheOcean.adjacentElementsProduct(new int[]{3, 6, -2, -5, 7, 3}));
        Assert.assertEquals(2, $2_EdgeOfTheOcean.adjacentElementsProduct(new int[]{-1, -2}));
        Assert.assertEquals(6, $2_EdgeOfTheOcean.adjacentElementsProduct(new int[]{5, 1, 2, 3, 1, 4}));
        Assert.assertEquals(-12, $2_EdgeOfTheOcean.adjacentElementsProduct(new int[]{-23, 4, -3, 8, -12}));
    }

    @Test
    public void shapeAreaTest() {
        Assert.assertEquals(1, $2_EdgeOfTheOcean.shapeArea(1));
        Assert.assertEquals(5, $2_EdgeOfTheOcean.shapeArea(2));
        Assert.assertEquals(13, $2_EdgeOfTheOcean.shapeArea(3));
        Assert.assertEquals(25, $2_EdgeOfTheOcean.shapeArea(4));
        Assert.assertEquals(41, $2_EdgeOfTheOcean.shapeArea(5));
    }

    @Test
    public void makeArrayConsecutive2Test() {
        Assert.assertEquals(3, $2_EdgeOfTheOcean.makeArrayConsecutive2(new int[]{6, 2, 3, 8}));
        Assert.assertEquals(2, $2_EdgeOfTheOcean.makeArrayConsecutive2(new int[]{0, 3}));
        Assert.assertEquals(0, $2_EdgeOfTheOcean.makeArrayConsecutive2(new int[]{5, 4, 6}));
        Assert.assertEquals(2, $2_EdgeOfTheOcean.makeArrayConsecutive2(new int[]{6, 3}));
        Assert.assertEquals(0, $2_EdgeOfTheOcean.makeArrayConsecutive2(new int[]{1}));
    }

    @Test
    public void almostIncreasingSequenceTest() {
        Assert.assertTrue($2_EdgeOfTheOcean.almostIncreasingSequence(new int[]{0, 1}));

        Assert.assertTrue($2_EdgeOfTheOcean.almostIncreasingSequence(new int[]{0, 1}));
        Assert.assertTrue($2_EdgeOfTheOcean.almostIncreasingSequence(new int[]{-1, 0}));
        Assert.assertTrue($2_EdgeOfTheOcean.almostIncreasingSequence(new int[]{0, 3}));
        Assert.assertTrue($2_EdgeOfTheOcean.almostIncreasingSequence(new int[]{0, 0}));

        Assert.assertTrue($2_EdgeOfTheOcean.almostIncreasingSequence(new int[]{0, 1, 2}));
        Assert.assertTrue($2_EdgeOfTheOcean.almostIncreasingSequence(new int[]{0, 1, 3}));
        Assert.assertTrue($2_EdgeOfTheOcean.almostIncreasingSequence(new int[]{0, 3, 1}));
        Assert.assertTrue($2_EdgeOfTheOcean.almostIncreasingSequence(new int[]{3, 1, 2}));
        Assert.assertTrue($2_EdgeOfTheOcean.almostIncreasingSequence(new int[]{0, 2, 4}));
        Assert.assertFalse($2_EdgeOfTheOcean.almostIncreasingSequence(new int[]{0, -2, -4}));

        Assert.assertFalse($2_EdgeOfTheOcean.almostIncreasingSequence(new int[]{1, 3, 2, 1}));
        Assert.assertTrue($2_EdgeOfTheOcean.almostIncreasingSequence(new int[]{1, 3, 2}));
        Assert.assertFalse($2_EdgeOfTheOcean.almostIncreasingSequence(new int[]{1, 2, 1, 2}));
        Assert.assertFalse($2_EdgeOfTheOcean.almostIncreasingSequence(new int[]{1, 4, 10, 4, 2}));
        Assert.assertTrue($2_EdgeOfTheOcean.almostIncreasingSequence(new int[]{10, 1, 2, 3, 4, 5}));
        Assert.assertFalse($2_EdgeOfTheOcean.almostIncreasingSequence(new int[]{1, 1, 1, 2, 3}));
        Assert.assertTrue($2_EdgeOfTheOcean.almostIncreasingSequence(new int[]{0, -2, 5, 6}));

        int x = -99;
        int y = 999;

        Assert.assertTrue($2_EdgeOfTheOcean.almostIncreasingSequence(new int[]{1, 2, 3, 4}));
        Assert.assertTrue($2_EdgeOfTheOcean.almostIncreasingSequence(new int[]{x, 2, 3, 4}));
        Assert.assertTrue($2_EdgeOfTheOcean.almostIncreasingSequence(new int[]{2, x, 3, 4}));
        Assert.assertTrue($2_EdgeOfTheOcean.almostIncreasingSequence(new int[]{2, 3, x, 4}));
        Assert.assertFalse($2_EdgeOfTheOcean.almostIncreasingSequence(new int[]{2, x, y, 3}));

        Assert.assertFalse($2_EdgeOfTheOcean.almostIncreasingSequence(new int[]{1, 2, 5, 5, 5}));

        Assert.assertTrue($2_EdgeOfTheOcean.almostIncreasingSequence(new int[]{0, -2, 5, 6}));
        Assert.assertTrue($2_EdgeOfTheOcean.almostIncreasingSequence(new int[]{1, 1}));
        Assert.assertTrue($2_EdgeOfTheOcean.almostIncreasingSequence(new int[]{1, 2, 3, 4, 3, 6}));
        Assert.assertTrue($2_EdgeOfTheOcean.almostIncreasingSequence(new int[]{123, -17, -5, 1, 2, 3, 12, 43, 45}));
        Assert.assertTrue($2_EdgeOfTheOcean.almostIncreasingSequence(new int[]{1, 2, 5, 3, 5}));

    }

    @Test
    public void initStackTest() {
        Stack<Integer> expected = new Stack<>();
        expected.push(1);
        expected.push(2);
        expected.push(3);
        Assert.assertEquals(expected, $2_EdgeOfTheOcean.initStack(1,2,3));

        expected.clear();
        expected.push(2);
        expected.push(3);
        Assert.assertEquals(expected, $2_EdgeOfTheOcean.initStack(9,2,3));
        Assert.assertEquals(expected, $2_EdgeOfTheOcean.initStack(2,9,3));

        expected.clear();
        expected.push(1);
        expected.push(2);
        Assert.assertEquals(expected, $2_EdgeOfTheOcean.initStack(1,2,-9));

        Assert.assertTrue($2_EdgeOfTheOcean.initStack(1,-2,-8).empty());
    }

    @Test
    public void matrixElementsSumTest() {
        int matrix[][] = new int[][]{
                {0,1,1,2},
                {0,5,0,0},
                {2,0,3,3},
        };
        Assert.assertEquals(9, $2_EdgeOfTheOcean.matrixElementsSum(matrix));

        matrix = new int[][]{
                {1,1,1,0},
                {0,5,0,1},
                {2,1,3,10},
        };
        Assert.assertEquals(9, $2_EdgeOfTheOcean.matrixElementsSum(matrix));
    }
}

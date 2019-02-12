package bairesdev;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    public static boolean parenthesesMatching(String string) {
        boolean result = false;

        Map<Character, Character> brackets = new HashMap<>();
        brackets.put('(',')');
        brackets.put('[',']');
        brackets.put('{','}');

        Stack<Character> stack = new Stack<>();
        boolean worked = false;

        for(int i=0; i<string.length(); i++) {
            if(brackets.containsKey(string.charAt(i))) {
                stack.push(brackets.get(string.charAt(i)));
                worked = true;
            }

            if(brackets.containsValue(string.charAt(i))) {
                if(stack.empty()) {
                    break;
                } else if(!stack.peek().equals(string.charAt(i))) {
                    break;
                }
                stack.pop();
            }
        }

        if(stack.empty() && worked) {
            result = true;
        }

        return result;
    }

    public static void main(String[] args) {
        assert false == (Problems.parenthesesMatching("(a[0]+b[2c[6]]) {24 + 53}"));
        Assert.assertTrue(Problems.parenthesesMatching("f(e(d))"));
        Assert.assertTrue(Problems.parenthesesMatching("[()]{}([])"));
        Assert.assertFalse(Problems.parenthesesMatching("((b)"));
        Assert.assertFalse(Problems.parenthesesMatching("(c]"));
        Assert.assertFalse(Problems.parenthesesMatching("{(a[])"));
        Assert.assertFalse(Problems.parenthesesMatching("([)]"));
        Assert.assertFalse(Problems.parenthesesMatching(")("));
        Assert.assertFalse(Problems.parenthesesMatching(""));
    }
}

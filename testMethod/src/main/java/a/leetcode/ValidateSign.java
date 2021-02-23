package a.leetcode;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/valid-parentheses/
 **/
public class ValidateSign {
    public static void main(String[] args) {
        String str1 = "()";//true
        System.out.println(isValid(str1));

        String str2 = "()[]{}";//true
        System.out.println(isValid(str2));

        String str3 = "(]";//false
        System.out.println(isValid(str3));

        String str4 = "([)]";//false
        System.out.println(isValid(str4));

        String str5 = "{[]}";//true
        System.out.println(isValid(str5));
    }

    //do not improve
    public static boolean isValid(String s) {
        //using stack!!!!
        Stack<Character> stack = new Stack<>();
        char[] ss = s.toCharArray();
        for (char c : ss) {
            switch (c) {
                case ')' -> {
                    if (match('(', stack)) {
                        break;
                    }
                    return false;
                }
                case ']' -> {
                    if (match('[', stack)) {
                        break;
                    }
                    return false;
                }
                case '}' -> {
                    if (match('{', stack)) {
                        break;
                    }
                    return false;
                }
                default -> stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    private static boolean match(char right, Stack<Character> stack) {
        if (stack.isEmpty()) return false;
        char last = stack.pop();
        return last == right;
    }

    public static boolean isValid2(String s) {
        //using stack!!!!
        Stack<Character> stack = new Stack<>();
        char[] ss = s.toCharArray();
        for (char c : ss) {
            if (c == ')') {
                if (stack.isEmpty()) return false;
                char last = stack.pop();
                if (last != '(') return false;
            } else if (c == ']') {
                if (stack.isEmpty()) return false;
                char last = stack.pop();
                if (last != '[') return false;
            } else if (c == '}') {
                if (stack.isEmpty()) return false;
                char last = stack.pop();
                if (last != '{') return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}

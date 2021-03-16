package a.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/roman-to-integer/
 **/
public class RomeNum {
    public static void main(String[] args) {
        String s1 = "MCMXCIV";
        int r1 = 1994;

        String s2 = "LVIII";
        int r2 = 58;

        String s3 = "VIII";
        int r3 = 8;

        String s4 = "IV";
        int r4 = 4;

        System.out.println(r1 == romanToInt(s1));
        System.out.println(r2 == romanToInt(s2));
        System.out.println(r3 == romanToInt(s3));
        System.out.println(r4 == romanToInt(s4));
    }

    public static int romanToInt(String s) {
        int res = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            int current = getNum(chars[i]);
            int next = getNum(chars[i + 1]);
            if (current < next) {
                res = res - current;
            } else {
                res = res + current;
            }
        }
        return res + getNum(chars[chars.length - 1]);
    }

    private static Map<Character, Integer> num() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        return map;
    }

    private static int getNum(char roma) {
        return switch (roma) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}

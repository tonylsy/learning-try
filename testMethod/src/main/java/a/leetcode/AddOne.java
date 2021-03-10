package a.leetcode;

import java.util.Arrays;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/plus-one/
 **/
public class AddOne {
    public static void main(String[] args) {
        int[] arr = new int[]{9};
        int[] rs = new int[]{1, 0};
        System.out.println(Arrays.equals(plusOne(arr), rs));
    }
    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        for(int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if(digits[i]!=0)
                return digits;
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }

    public static int[] plusOne2(int[] digits) {
        if (digits.length == 0) {
            return digits;
        }
        boolean biggerTen = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (biggerTen) {
                int res = digits[i] + 1;
                biggerTen = res >= 10;
                if (biggerTen) {
                    digits[i] = (digits[i] + 1) % 10;
                } else {
                    digits[i] = digits[i] + 1;
                }
            } else {
                break;
            }
        }
        if (biggerTen) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            System.arraycopy(digits, 0, res, 1, res.length - 1);
            return res;
        }
        return digits;
    }
}

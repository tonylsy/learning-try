package a.leetcode;

/**
 * @author Siyuan Li
 * @version 1.0.0
 **/
public class ReverseInt {

    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }


    public int reverse2(int x) {
        StringBuffer sb = new StringBuffer();
        if (x < 0) {
            sb.append("-");
            x = Math.abs(x);
        }
        while (x != 0) {
            int num = x % 10;
            sb.append(num);
            x = x / 10;
        }

        int rs = 0;
        try {
            rs = Integer.parseInt(sb.toString());
        } catch (Exception exception) {
            return 0;
        }

        return rs;
    }
}

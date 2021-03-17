package a.leetcode.medium;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/integer-to-roman/
 **/
public class IntToRome {
    public static void main(String[] args) {
        System.out.println("III".equals(intToRoman(3)));
        System.out.println("IV".equals(intToRoman(4)));
        System.out.println("LVIII".equals(intToRoman(58)));
        System.out.println("MCMXCIV".equals(intToRoman(1994)));
    }


    public static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < values.length && num>=0; i++) {
            while(num - values[i] >= 0){
                sb.append(symbols[i]);
                num = num - values[i];
            }
        }
        return sb.toString();
    }
}

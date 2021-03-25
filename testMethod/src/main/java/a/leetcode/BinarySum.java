package a.leetcode;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/add-binary/
 **/
public class BinarySum {
    public static void main(String[] args) {
        System.out.println("100".equals(addBinary("11", "1")));//true
        System.out.println("10000".equals(addBinary("1111", "1")));//true
        System.out.println("10101".equals(addBinary("1010", "1011")));//true
    }

    public static String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        char carry = '0';
        int i = a.length() - 1, j= b.length() - 1;
        for (; i >= 0 || j >= 0; i--,j--) {
            int res = carry;
            res += i >= 0? a.charAt(i) : '0';
            res += j >= 0? b.charAt(j) : '0';

            if (res == 145 || res == 147) {
                //{0,0,1},{1,0,0},{0,1,0},{1,1,1}
                sb.append('1');
            } else {
                //{0,0,0},{0,1,1},{1,1,0},{1,1,0}
                sb.append('0');
            }

            //{0,1,1},{1,1,0},{1,1,0},{1,1,1}
            if (res >= 146) {
                carry = '1';
            } else {
                carry = '0';
            }
        }
        if(carry == '1'){
            sb.append('1');
        }
        sb.reverse();
        return sb.toString();
    }
}

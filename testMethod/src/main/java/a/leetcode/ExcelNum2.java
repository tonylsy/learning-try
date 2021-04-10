package a.leetcode;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/excel-sheet-column-title/
 **/
public class ExcelNum2 {
    public static void main(String[] args) {
        System.out.println("A".equals(convertToTitle(1)));
        System.out.println("AB".equals(convertToTitle(28)));
        System.out.println("ZY".equals(convertToTitle(701)));
        System.out.println("AZ".equals(convertToTitle(52)));
    }

    public static String convertToTitle(int n) {
        if (n <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char) (n % 26 + 'A'));
            n =n / 26;
        }
        return sb.reverse().toString();
    }
}

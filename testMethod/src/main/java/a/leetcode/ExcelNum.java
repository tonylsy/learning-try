package a.leetcode;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/excel-sheet-column-number/
 **/
public class ExcelNum {
    public static void main(String[] args) {
        System.out.println(titleToNumber("A") == 1);
        System.out.println(titleToNumber("AB") == 28);
        System.out.println(titleToNumber("ZY") == 701);
    }

    public static int titleToNumber(String columnTitle) {
        int len = columnTitle.length();
        int res = 0;
        int up = 1;
        for (int i = len - 1; i >= 0 ; i--) {
            res += (columnTitle.charAt(i) - 'A' + 1) * up;
            up *= 26;
        }
        return res;
    }
}

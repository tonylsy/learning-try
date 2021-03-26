package a.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/pascals-triangle-ii/
 **/
public class TriangleOfYangHui2 {
    public static void main(String[] args) {
        List<Integer> res = Arrays.asList(1, 3, 3, 1);
        List<Integer> r2 = getRow(3);
        for (int i = 0; i < res.size(); i++) {
            if (!res.get(i).equals(r2.get(i))) {
                System.out.println("fail!");
                break;
            }
        }
        System.out.println("pair end!");
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            list.add(0);
            for (int j = i; j >= 1; j--) {
                list.set(j, list.get(j) + list.get(j - 1));
            }
        }
        return list;
    }
}

package a.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/pascals-triangle/
 **/
public class YanghuiTriangle {
    public static void main(String[] args) {
        System.out.println(generate(1));
        System.out.println(generate(2));
        System.out.println(generate(3));
        System.out.println(generate(4));
        System.out.println(generate(5));
        System.out.println(generate(6));
    }



    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> context = new ArrayList<>();
        context.add(1);
        list.add(context);
        if (numRows == 1) {
            return list;
        }
        if(numRows == 2){
            context = new ArrayList<>();
            context.add(1);
            context.add(1);
            list.add(context);
            return list;
        }

        int i = 1;
        while(i!=numRows){
            List<Integer> next = new ArrayList<>();
            next.add(1);
            List<Integer> last = list.get(i-1);
            for (int j = 1; j < last.size(); j++) {
                int data = last.get(j - 1) + last.get(j);
                next.add(data);
            }
            next.add(1);
            list.add(next);
            i++;
        }
        return list;
    }
}

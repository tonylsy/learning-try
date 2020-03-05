package a.dataStructures.princeton.symbolTable;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.jupiter.api.Assertions;

/**
 * RedBlackTree234 Tester.
 *
 * @author <Authors name>
 * @version 1.0
 */
public class RedBlackTree234Test {

    @Test
    public void testInsert() throws Exception {
        int[] arr = {10, 20, -10, 15, 17, 40, 50, 60};
        int[] arr2 = {7, 30, 10, 5, -5, 20, 38, 35};
        int[] arr3 = {20, 7, 30, 5, -5, 38, 35, 10};
        RedBlackTree234<Integer, Integer> rbt = new RedBlackTree234<>();
        RedBlackTree234<Integer, Integer> rbt2 = new RedBlackTree234<>();
        RedBlackTree234<Integer, Integer> rbt3 = new RedBlackTree234<>();
        for (int value : arr) {
            rbt.insert(value, value);
        }
        for (int value : arr2) {
            rbt2.insert(value, value);
        }
        for (int value : arr3) {
            rbt3.insert(value, value);
        }

        System.out.println("the end:" + rbt.toString());
        Assertions.assertEquals("17[black] 10[black] -10[black] 15[black] 40[black] 20[black] 50[black] 60[red] ", rbt.toString());

        System.out.println("the end:" + rbt2.toString());
        Assertions.assertEquals("10[black] 5[red] -5[black] 7[black] 30[red] 20[black] 38[black] 35[red] ", rbt2.toString());

        System.out.println("the end:" + rbt2.toString());
        Assertions.assertEquals("20[black] 5[red] -5[black] 7[black] 10[red] 35[red] 30[black] 38[black] ", rbt3.toString());
    }


}

package a.dataStructures.princeton.symbolTable;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.jupiter.api.Assertions;

/**
 * RedBlackTree Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>2ÔÂ 13, 2020</pre>
 */
public class RedBlackTreeTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: rotateLeft(Node<Key, Value> x)
     */
    @Test
    public void testRotateLeft() throws Exception {
        RedBlackTree<String, String> rbt = new RedBlackTree<>();
        rbt.root = new Node<>(null, "root", "root");
        rbt.root.left = new Node<>(rbt.root, "x", "x");
        rbt.root.left.right = new Node<>(rbt.root.left, "rightNode", "rightNode");
        rbt.root.left.right.left = new Node<>(rbt.root.left.right, "rightNode's left", "rightNode's left");
        rbt.rotateLeft(rbt.root.left);

        //result
        printRotateNode(rbt.root);
        printRotateNode(rbt.root.left);
        printRotateNode(rbt.root.left.left);
        printRotateNode(rbt.root.left.left.right);
    }


    /**
     * Method: rotateRight(Node<Key, Value> x)
     */
    @Test
    public void testRotateRight() throws Exception {
        RedBlackTree<String, String> rbt = new RedBlackTree<>();
        rbt.root = new Node<>(null, "root", "root");
        rbt.root.left = new Node<>(rbt.root, "x", "x");
        rbt.root.left.left = new Node<>(rbt.root.left, "leftNode", "leftNode");
        rbt.root.left.left.right = new Node<>(rbt.root.left.left, "leftNode's right", "leftNode right");
        rbt.rotateRight(rbt.root.left);

        //result
        printRotateNode(rbt.root);
        printRotateNode(rbt.root.left);
        printRotateNode(rbt.root.left.right);
        printRotateNode(rbt.root.left.right.left);
    }

    //to show the node result
    private void printRotateNode(Node node) {
        StringBuilder sb = new StringBuilder();
        if (node == null) {
            System.out.println("null");
            return;
        }
        sb.append(node.left == null ? "null" : node.left.value)
                .append("-").append(node).append("-")
                .append(node.right == null ? "null" : node.right.value)
                .append("- parent:").append(node.parent == null ? "null" : node.parent);
        System.out.println(sb.toString());
    }

    @Test
    public void insertTest() {
        int[] arr = {10, 20, -10, 15, 17, 40, 50, 60};
        int[] arr2 = {7, 30, 10, 5, -5, 20, 38, 35};
        int[] arr3 = {20, 7, 30, 5, -5, 38, 35, 10};
        RedBlackTree<Integer, Integer> rbt = new RedBlackTree<>();
        RedBlackTree<Integer, Integer> rbt2 = new RedBlackTree<>();
        RedBlackTree<Integer, Integer> rbt3 = new RedBlackTree<>();
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

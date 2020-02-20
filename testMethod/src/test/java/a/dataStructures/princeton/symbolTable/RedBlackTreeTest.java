package a.dataStructures.princeton.symbolTable;

import com.sun.source.tree.Tree;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.jupiter.api.Assertions;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

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

    @Test
    public void deleteTest() {
        //test balanceCase1
        int[] arr2 = {7};
        RedBlackTree<Integer, Integer> rbt2 = new RedBlackTree<>();
        for (int value : arr2) {
            rbt2.insert(value, value);
        }
        rbt2.delete(7);
        Assertions.assertEquals("null[black] ", rbt2.toString());


        RedBlackTree<Integer, Integer> rbt = new RedBlackTree<>();
        rbt.root = getTestTree();
        Assertions.assertEquals("15[black] 10[black] -10[black] 11[black] 44[red] 40[black] 20[black] 41[black] 60[black] 50[black] 65[black] 75[red] ", rbt.toString());

        //double black node situation
        //test balanceCase3,2,4
        rbt.delete(10);
        Assertions.assertEquals("44[black] 15[black] 11[black] -10[red] 40[red] 20[black] 41[black] 60[black] 50[black] 65[black] 75[red] ", rbt.toString());

        //test balanceCase6
        rbt.delete(50);
        Assertions.assertEquals("44[black] 15[black] 11[black] -10[red] 40[red] 20[black] 41[black] 65[black] 60[black] 75[black] ", rbt.toString());

        //test balanceCase5
        rbt.insert(70, 70);
        rbt.delete(60);
        Assertions.assertEquals("44[black] 15[black] 11[black] -10[red] 40[red] 20[black] 41[black] 70[black] 65[black] 75[black] ", rbt.toString());


        //test toBeDeletedNode is black, replacement node is red
        rbt.delete(11);
        Assertions.assertEquals("44[black] 15[black] -10[black] 40[red] 20[black] 41[black] 70[black] 65[black] 75[black] ", rbt.toString());

        //test toBeDeletedNode is red, while child is black
        rbt.delete(40);
        Assertions.assertEquals("44[black] 15[black] -10[black] 41[black] 20[red] 70[black] 65[black] 75[black] ", rbt.toString());

        //test toBeDeletedNode is red, while child is red
        rbt.insert(16, 16);
        rbt.insert(30, 30);
        Assertions.assertEquals("44[black] 15[black] -10[black] 20[red] 16[black] 41[black] 30[red] 70[black] 65[black] 75[black] ", rbt.toString());
        rbt.delete(20);
        Assertions.assertEquals("44[black] 15[black] -10[black] 30[red] 16[black] 41[black] 70[black] 65[black] 75[black] ", rbt.toString());
    }

    private static Node<Integer, Integer> getTestTree() {

        Node<Integer, Integer> node15 = new Node<>(15, 15);
        node15.color = Node.BLACK;

        Node<Integer, Integer> node10 = new Node<>(10, 10);
        node10.color = Node.BLACK;
        node10.parent = node15;
        node15.left = node10;

        Node<Integer, Integer> nodeN10 = new Node<>(-10, -10);
        nodeN10.color = Node.BLACK;
        nodeN10.parent = node10;
        node10.left = nodeN10;

        Node<Integer, Integer> node11 = new Node<>(11, 11);
        node11.color = Node.BLACK;
        node11.parent = node10;
        node10.right = node11;

        Node<Integer, Integer> node44 = new Node<>(44, 44);
        node44.color = Node.RED;
        node44.parent = node15;
        node15.right = node44;

        Node<Integer, Integer> node40 = new Node<>(40, 40);
        node40.color = Node.BLACK;
        node40.parent = node44;
        node44.left = node40;

        Node<Integer, Integer> node20 = new Node<>(20, 20);
        node20.color = Node.BLACK;
        node20.parent = node40;
        node40.left = node20;

        Node<Integer, Integer> node41 = new Node<>(41, 41);
        node41.color = Node.BLACK;
        node41.parent = node40;
        node40.right = node41;

        Node<Integer, Integer> node60 = new Node<>(60, 60);
        node60.color = Node.BLACK;
        node60.parent = node44;
        node44.right = node60;

        Node<Integer, Integer> node50 = new Node<>(50, 50);
        node50.color = Node.BLACK;
        node50.parent = node60;
        node60.left = node50;

        Node<Integer, Integer> node65 = new Node<>(65, 65);
        node65.color = Node.BLACK;
        node65.parent = node60;
        node60.right = node65;

        Node<Integer, Integer> node75 = new Node<>(75, 75);
        node75.color = Node.RED;
        node75.parent = node65;
        node65.right = node75;

        return node15;
    }
}

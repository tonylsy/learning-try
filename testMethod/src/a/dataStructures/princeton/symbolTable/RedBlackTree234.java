package a.dataStructures.princeton.symbolTable;


import java.util.Stack;

/*
 * red black tree implements the 2-3-4 tree
 * node class to have parent parameter
 */
public class RedBlackTree234<Key extends Comparable<Key>, Value> {
    public Node<Key, Value> root;

    public void insert(Key key, Value value) {

    }

    public void delete(Key key) {

    }


    /**
     * change parent's right to left
     * p.s:
     * question: the grandparent node no need to change?
     * answer: is unnecessary to change because just change all the link
     * it means when use rotateLeft, use the Node node = rotateLeft(node);
     *
     * @param parent parent node
     * @return the node with new relationship
     */
    public void rotateLeft(Node<Key, Value> parent) {

    }

    /**
     * change the right node and its parent node
     *
     * @param root          root node
     * @param isChangeColor whether the node need to change the color
     */
    public void rotateRight(Node<Key, Value> root, boolean isChangeColor) {
        if (root == null || root.parent == null) return;

        Node<Key, Value> parent = root.parent;
        Node<Key, Value> grandparent = parent.parent;
        Node<Key, Value> rightNode = root.right;

        //change the link of root
        root.right = parent;
        root.parent = grandparent;

        //change the link of parent
        parent.left = rightNode;
        parent.parent = root;

        // change the link of grand parent
        if (grandparent != null) {
            grandparent.left = root;
        }

        //change the link of right node
        if (rightNode != null) {
            rightNode.parent = parent;
        }

        if (isChangeColor) {
            root.color = Node.BLACK;
            parent.color = Node.RED;
        }

    }


    @Override
    public String toString() {
        Stack<Node<Key, Value>> stack = new Stack<>();
        Node<Key, Value> current = root;
        StringBuilder sb = new StringBuilder();
        stack.push(current);
        while (current != null && !stack.isEmpty()) {

            current = stack.pop();

            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
            sb.append(current).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        /*int[] arr = {10, 20, -10, 15, 17, 40, 50, 60};
        int[] arr2 = {7, 30, 10, 5, -5, 20, 38, 35};
        RedBlackTree234<Integer, Integer> rbt = new RedBlackTree234<>();
        for (int value : arr) {
            rbt.insert(value, value);
        }
        //the end:17[black] 10[red] -10[black] 15[black] 40[red] 20[black] 50[black] 60[red]
        System.out.println("the end:" + rbt.toString());
        */

        //test rotateRight method
        Node<Character, Character> x = new Node<>('x', 'x');
        Node<Character, Character> y = new Node<>(x, 'y', 'y');
        Node<Character, Character> z = new Node<>(y, 'z', 'z');
        Node<Character, Character> l = new Node<>(z, 'l', 'l');
        Node<Character, Character> m = new Node<>(z, 'm', 'm');
        Node<Character, Character> n = new Node<>(y, 'n', 'n');
        x.left = y;
        y.left = z;
        y.right = n;
        z.left = l;
        z.right = m;
        Node[] nodes = {x, y, z, l, m, n};


        RedBlackTree234<Character, Character> rbt = new RedBlackTree234<>();
        rbt.rotateRight(z, false);
        StringBuilder sb = new StringBuilder();
        for (Node node : nodes) {
            sb.append("  ");
            sb.append(node.left == null ? "null" : node.left.value);
            sb.append(" - ");
            sb.append(node.value);
            sb.append(" - ");
            sb.append(node.right == null ? "null" : node.right.value);
            sb.append(" >>> parent is: ");
            sb.append(node.parent == null ? "null" : node.parent.value);
            sb.append(" >>> ");
            //sb.append("\r");
        }
        System.out.println(sb.toString());

    }
}

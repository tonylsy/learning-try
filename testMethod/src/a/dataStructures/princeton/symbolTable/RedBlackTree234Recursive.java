package a.dataStructures.princeton.symbolTable;


import java.util.Stack;

/*
 * red black tree implements the 2-3-4 tree by recursive method
 */
public class RedBlackTree234Recursive<Key extends Comparable<Key>, Value> {
    private Node<Key, Value> root;

    public void insert(Key key, Value value) {
        root = insert(root, key, value);
        root.color = Node.BLACK;
    }

    private Node<Key, Value> insert(Node<Key, Value> node, Key key, Value value) {
        if (node == null) return new Node<>(key, value, 0, Node.RED);
        int result = key.compareTo(node.key);
        if (result == 0) {
            node.value = value;
        } else if (result > 0) {
            node.right = insert(node.right, key, value);
        } else {
            node.left = insert(node.left, key, value);
        }

        insertRotate1(node);
        node = insertRotate2(node);
        insertRotate3(node);
        node.count = size(node.left) + size(node.right) + 1;
        return node;
    }

    /**
     * rotate when root is black, left is red, left's right is red
     * which means in a z situation
     *
     * @param node the root node
     */
    private void insertRotate1(Node<Key, Value> node) {
        if (isRed(node.left) && isRed(node.left.right) && isBlack(node.right)) {
            node.left = rotateLeft(node.left);
        } else if (isRed(node.right) && isRed(node.right.left) && isBlack(node.left)) {
            node.right = rotateRight(node.right);
        }
    }

    /**
     * rotate when root is black, left is red, left's left is red
     *
     * @param node the root node
     */
    private Node<Key, Value> insertRotate2(Node<Key, Value> node) {
        if (isRed(node.left) && isRed(node.left.left) && isBlack(node.right)) {
            node = rotateRight(node);
        } else if (isRed(node.right) && isRed(node.right.right) && isBlack(node.left)) {
            node = rotateLeft(node);
        }
        return node;
    }

    /**
     * chang color when the root is black, two children are red and its grandson contains a red
     *
     * @param node the root node
     */
    private void insertRotate3(Node<Key, Value> node) {
        boolean hasRedGrandSon = hasRedChild(node.left) || hasRedChild(node.right);
        if (isRed(node.left) && isRed(node.right) && hasRedGrandSon) flipColor(node);
    }

    private void flipColor(Node<Key, Value> node) {
        node.color = Node.RED;
        node.left.color = Node.BLACK;
        node.right.color = Node.BLACK;
    }

    public void delete(Key key) {

    }


    public int size() {
        return size(root);
    }

    private int size(Node<Key, Value> x) {
        if (x == null) return 0;
        return x.count;
    }

    private boolean isRed(Node<Key, Value> node) {
        if (node == null) return false;
        return node.color == Node.RED;
    }


    private boolean hasRedChild(Node<Key, Value> node) {
        if (node == null) return false;
        return isRed(node.left) || isRed(node.right);
    }


    private boolean isBlack(Node<Key, Value> node) {
        if (node == null) return true;
        return node.color == Node.BLACK;
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
    public Node<Key, Value> rotateLeft(Node<Key, Value> parent) {
        Node<Key, Value> rightNode = parent.right;

        //set parent's right node to be child's left
        parent.right = rightNode.left;

        //set child right node to be parent
        rightNode.left = parent;

        //change the color
        boolean tempColor = rightNode.color;
        rightNode.color = parent.color;
        parent.color = tempColor;

        //change count
        rightNode.count = parent.count;
        parent.count = 1 + size(parent.left) + size(parent.right);
        return rightNode;
    }

    /**
     * change parent left node to right
     *
     * @param parent the root to rotation
     * @return the node with new relationship
     */
    public Node<Key, Value> rotateRight(Node<Key, Value> parent) {
        Node<Key, Value> leftNode = parent.left;

        //set parent's right node to be child's left
        parent.left = leftNode.right;

        //set child right node to be parent
        leftNode.right = parent;

        //change the color
        boolean tempColor = leftNode.color;
        leftNode.color = parent.color;
        parent.color = tempColor;

        //change count
        leftNode.count = parent.count;
        parent.count = 1 + size(parent.left) + size(parent.right);
        return leftNode;
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
        int[] arr = {10, 20, -10, 15, 17, 40, 50, 60};
        int[] arr2 = {7, 30, 10, 5, -5, 20, 38, 35};
        //int[] arr2 = {20, 7, 30, 5, -5, 38, 35, 10};
        char[] arr3 = {'m', 'e', 'n', 'p', 'q', 'o', 'n', 'y', 'x', 'z'};
        RedBlackTree234Recursive<Integer, Integer> rbt = new RedBlackTree234Recursive<>();
        RedBlackTree234Recursive<Integer, Integer> rbt2 = new RedBlackTree234Recursive<>();
        RedBlackTree234Recursive<Character, Character> rbt3 = new RedBlackTree234Recursive<>();
        for (int value : arr) {
            rbt.insert(value, value);
        }
        for (int value : arr2) {
            rbt2.insert(value, value);
        }
        for (char value : arr3) {
            rbt3.insert(value, value);
        }

        //the end:17[black] 10[red] -10[black] 15[black] 40[red] 20[black] 50[black] 60[red] 
        System.out.println("the end:" + rbt.toString());
        System.out.println("the end:" + rbt2.toString());
        System.out.println("the end:" + rbt3.toString());
    }
}

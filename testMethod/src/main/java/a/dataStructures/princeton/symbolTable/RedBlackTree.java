package a.dataStructures.princeton.symbolTable;

/*
 * this red black tree use common method and is the 2-3-4 tree
 */
public class RedBlackTree<Key extends Comparable<Key>, Value> {
    public Node<Key, Value> root;

    public void rotateLeft(Node<Key, Value> x) {
        if (x == null || x.right == null) return;
        Node<Key, Value> right = x.right;
        Node<Key, Value> parent = x.parent;

        //alter x's grandson node to be its right node
        x.right = right.left;
        //refresh x's parent link
        x.parent = right;

        //refresh parent link belong to a node which is right's left child
        if (right.left != null) {
            right.left.parent = x;
        }

        //alter right node's left to be x
        right.left = x;
        //refresh right node's link
        right.parent = x.parent;


        //refresh parent node's link
        if (x.equals(parent.left)) {
            parent.left = right;
        } else if (x.equals(parent.right)) {
            parent.right = right;
        } else {
            root = right;
        }
    }

    public void rotateRight(Node<Key, Value> x) {
        if (x == null || x.left == null) return;
        Node<Key, Value> left = x.left;
        Node<Key, Value> parent = x.parent;

        //alter x's grandson node to be its left node
        x.left = left.right;
        //refresh x's parent link
        x.parent = left;

        //refresh parent link belong to a node which is right's left child
        if (left.right != null) {
            left.right.parent = x;
        }
        //alter right node's left to be x
        left.right = x;
        //refresh right node's link
        left.parent = x.parent;

        //refresh parent node's link
        if (x.equals(parent.left)) {
            parent.left = left;
        } else if (x.equals(parent.right)) {
            parent.right = left;
        } else {
            root = left;
        }
    }
}

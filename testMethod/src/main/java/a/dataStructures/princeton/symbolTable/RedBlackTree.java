package a.dataStructures.princeton.symbolTable;

import java.util.Stack;

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
        right.parent = parent;


        //refresh parent node's link
        if (parent == null) {
            root = right;
        } else if (x.equals(parent.left)) {
            parent.left = right;
        } else if (x.equals(parent.right)) {
            parent.right = right;
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
        left.parent = parent;

        //refresh parent node's link
        if (parent == null) {
            root = left;
        } else if (x.equals(parent.left)) {
            parent.left = left;
        } else if (x.equals(parent.right)) {
            parent.right = left;
        }
    }


    public boolean insert(Key key, Value value) {
        if (value == null || key == null) return false;
        insertNode(new Node<>(key, value));
        return true;
    }

    private void insertNode(Node<Key, Value> node) {
        if (root == null) {
            root = node;
            root.color = Node.BLACK;
            root.count = 0;
            return;
        }
        //find the parent for node
        Node<Key, Value> x = root, y = null;
        while (x != null) {
            y = x;
            int result = node.key.compareTo(x.key);
            if (result < 0) {
                x = x.left;
            } else if (result > 0) {
                x = x.right;
            } else {
                x.value = node.value;
                return;
            }
        }
        //update the parent link on node
        node.parent = y;

        //update the link on parent
        int result = node.key.compareTo(y.key);
        if (result < 0) {
            y.left = node;
        } else {
            y.right = node;
        }

        //set node as the leaf and red node
        node.color = Node.RED;
        node.count = 0;

        //fix up the relation of tree
        insertionFix(node);
    }

    private void insertionFix(Node<Key, Value> node) {
        if (node == null) return;
        //execute when node's parent is a red node
        while (node.parent != null && node.parent.color == Node.RED) {
            Node<Key, Value> parent = node.parent;
            Node<Key, Value> grandparent = parent.parent;
            if (parent.equals(grandparent.left)) {
                //parent is the left node of grandparent
                Node<Key, Value> parentBro = grandparent.right;
                //parent's brother is red node
                if (parentBro != null) {
                    if (parentBro.color == Node.RED) {
                        colorFlip(grandparent);
                        node = grandparent;
                        continue;
                    }
                }

                //node is the right node of its parent
                if (node.equals(parent.right)) {
                    rotateLeft(parent);
                    node = parent;
                    parent = node.parent;
                }

                //node is the left node of its parent
                if (node.equals(parent.left)) {
                    rotateRight(grandparent);
                }
                colorFlip(parent);
                node = parent;

            } else {
                //parent is right node of grandparent
                Node<Key, Value> parentBro = grandparent.left;
                //parent's brother is red node
                if (parentBro != null) {
                    if (parentBro.color == Node.RED) {
                        colorFlip(grandparent);
                        node = grandparent;
                        continue;
                    }
                }

                //node is the right node of its parent
                if (node.equals(parent.left)) {
                    rotateRight(parent);
                    node = parent;
                    parent = node.parent;
                }

                //node is the left node of its parent
                if (node.equals(parent.right)) {
                    rotateLeft(grandparent);
                }
                colorFlip(parent);
                node = parent;
            }
        }
        root.color = Node.BLACK;
    }

    private void colorFlip(Node<Key, Value> node) {
        if (node == null) return;
        node.color = Node.RED;
        if (node.left != null) node.left.color = Node.BLACK;
        if (node.right != null) node.right.color = Node.BLACK;
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

}

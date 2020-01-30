package a.dataStructures.princeton.symbolTable;

/*
this class is the balanced search tree
 */
public class BST<Key extends Comparable<Key>, Value> {
    private Node<Key, Value> root;

    /**
     * use recursive code so that the code become concise but tricky
     *
     * @param key   key
     * @param value value
     */
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node<Key, Value> node, Key key, Value value) {
        if (node == null) return new Node(key, value);
        int compare = key.compareTo(node.key);
        if (compare == 0) {
            node.value = value;
        } else if (compare > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.left = put(node.left, key, value);
        }
        return node;
    }

    public Value get(Key key) {
        Node<Key, Value> current = root;
        while (current != null) {
            int result = key.compareTo(current.key);
            if (result == 0) {
                return current.value;
            } else if (result > 0) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return null;
    }




    public Iterable<Key> iterator() {
        return null;
    }
}

package a.dataStructures.princeton.symbolTable;

public class Node<Key extends Comparable<Key>, Value> {
    public Node<Key, Value> right, left;
    public Key key;
    public Value value;
    public int count;//count the subtree node number

    Node(Key key, Value value) {
        this.key = key;
        this.value = value;
    }
}

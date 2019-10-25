package a.dataStructures.tree;

import java.util.Objects;

/**
 * binaryTree node
 *
 * @param <T>
 */
public class Node<T> {
    private T context;
    private Node<T> left;
    private Node<T> right;
    private boolean read;

    public Node(T context) {
        this.context = context;
    }

    public Node(T context, Node<T> left, Node<T> right) {
        this.context = context;
        this.left = left;
        this.right = right;
    }


    public T getContext() {
        return context;
    }

    public void setContext(T context) {
        this.context = context;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setRead() {
        this.read = true;
    }

    public void noRead() {
        this.read = false;
    }

    public boolean hasRead() {
        return this.read;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(context, node.context) &&
                Objects.equals(left, node.left) &&
                Objects.equals(right, node.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(context, left, right);
    }
}

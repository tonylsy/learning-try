package a.dataStructures.tree;

import java.util.Stack;

public class TreeHelper<T> {


    private Node<T> root;

    public void insert(Node<T> root) {
        this.root = root;
    }

    ;

    public boolean remove() {
        return false;
    }

    public boolean isEmpty() {
        return root == null;
    }


    public void printTree() {
        if (isEmpty()) {
            return;
        }
        //afterTraversal();
        System.out.println(">>>");
        //afterTraversal2();
        afterTraversal3();
    }

    private void preTraversal() {

    }

    private void midTraversal() {

    }

    private void afterTraversal() {
        Stack<Node<T>> stack = new Stack<>();

        //set all left into stack
        Node<T> current = root;
        while (current != null) {
            stack.push(current);
            current = current.getLeft();
        }
        while (!stack.isEmpty()) {

            //get the top one
            current = stack.pop();

            /**
             * if it has right node
             * no: print it
             * yes: put it back to stack , and go into right one
             */
            if (current.getRight() == null || current.hasRead()) {
                System.out.print(current.getContext());
            } else {
                //push back the one and record
                stack.push(current);
                current.setRead();

                //turn to right tree
                current = current.getRight();
                while (current != null) {
                    stack.push(current);
                    current = current.getLeft();
                }
            }
        }

    }
    private void afterTraversal2() {
        Stack<Node<T>> stack = new Stack<>();

        Node<T> current = root;

        do{

            //become the deepest left
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }

            /**
             * current is null: it means a lead of tree is end
             * current is not null: it means current is a right node
             */
            if(current == null) {
                current = stack.pop();
            }

            /**
             * current has right node:
             *    1.push current node back to stack
             *    2.record this node
             *    3.go into right node
             *
             * current has no right node or has been read(because some nodes are push back to stack):
             *    1.out put the context
             *    2.set current as null so that pop the top element of the stack
             */
            if (current.getRight() == null || current.hasRead()) {
                System.out.print(current.getContext());
                //stop the loop of finding left tree
                current = null;
            } else {
                //push back the one and record
                stack.push(current);
                current.setRead();

                //turn to right tree
                current = current.getRight();
            }
        }while(!stack.isEmpty());

    }
    private void afterTraversal3(){
        Stack<Node<T>> stack = new Stack<>();
        Node<T> current = root;
        do{
            if(current!=null){
                current.setRead();
                stack.push(current);
                current = current.getLeft();
            }else{
                current = stack.peek();
                if(current.hasRead()){
                    current.noRead();
                    current = current.getRight();
                }else{
                    System.out.print(current.getContext());
                    stack.pop();
                    current = null;
                }
            }
        }while(!stack.isEmpty());
    }

}

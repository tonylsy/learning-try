package a.dataStructures.tree;

public class testTree {
    public static void main(String[] args) {
        //create a tree
        Node<String> A = new Node<String>("A");
        Node<String> B = new Node<String>("B");
        Node<String> C = new Node<String>("C");
        Node<String> D = new Node<String>("D");
        Node<String> E = new Node<String>("E");
        Node<String> F = new Node<String>("F");
        Node<String> G = new Node<String>("G");
        Node<String> H = new Node<String>("H");
        Node<String> I = new Node<String>("I");
        Node<String> J = new Node<String>("J");
        Node<String> K = new Node<String>("K");
        Node<String> L = new Node<String>("L");
        Node<String> M = new Node<String>("M");
        Node<String> N = new Node<String>("N");
        Node<String> O = new Node<String>("O");
        Node<String> P = new Node<String>("P");
        Node<String> Q = new Node<String>("Q");
        Node<String> R = new Node<String>("R");
        Node<String> S = new Node<String>("S");
        Node<String> T = new Node<String>("T");

        A.setLeft(B);
        A.setRight(C);

        B.setLeft(D);
        D.setLeft(F);
        D.setRight(E);
        F.setLeft(G);
        F.setRight(M);
        E.setLeft(I);
        E.setRight(H);
        I.setLeft(J);
        I.setRight(K);
        H.setLeft(L);

        C.setLeft(N);
        C.setRight(P);
        N.setLeft(O);
        P.setLeft(Q);
        P.setRight(S);
        Q.setLeft(R);
        S.setLeft(T);

        //testMothod
        TreeHelper<String> th = new TreeHelper<>();
        th.insert(A);
        th.printTree();

    }
}

package a.dataStructures.graph;

import java.util.Arrays;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * create forest and very tree is not balanced
 **/
public class UFCreateForest extends UF {
    private final int[] counts;

    public UFCreateForest(int nodeNum) {
        this.parents = new int[nodeNum + 1];
        this.counts = new int[nodeNum + 1];
        for (int i = 0; i <= nodeNum; i++) {
            parents[i] = i;
            counts[i] = 0;
        }
    }

    @Override
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        parents[rootP] = rootQ;
        counts[rootP]++;
    }

    @Override
    public int count() {
        return Arrays.stream(counts).sum();
    }
}

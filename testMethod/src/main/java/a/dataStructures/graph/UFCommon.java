package a.dataStructures.graph;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * this class union nodes without considering the same root
 **/
public class UFCommon extends UF {
    private int count;

    public UFCommon(int nodeNum) {
        super.parents = new int[nodeNum+1];
        for (int i = 0; i <= nodeNum ; i++) {
            parents[i] = i;
        }
        this.count = 0;
    }

    @Override
    public void union(int p, int q) {
        if(isConnect(p,q)){
            return;
        }
        parents[p] = q;
        count++;
    }

    @Override
    public int count() {
        return count;
    }
}

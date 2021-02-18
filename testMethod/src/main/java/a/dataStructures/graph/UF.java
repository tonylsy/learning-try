package a.dataStructures.graph;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * <p>
 * the interface of union find(并查集)
 * very note is a integer rather than object
 **/
public abstract class UF {

    int[] parents = new int[10];

    /**
     * connect p and q
     *
     * @param p node 1
     * @param q node 2
     */
    public abstract void union(int p, int q);

    /**
     * @param p node 1
     * @param q node 2
     * @return whether the q and p are connecting
     */
    public boolean isConnect(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        return pRoot == qRoot;
    }

    /**
     * @return the number of union's connection
     */
    public abstract int count();

    /**
     * find the parent of p
     * @param p the node
     * @return the root
     */
    public int find(int p) {
        while (parents[p] != p) {
            p = parents[p];
        }
        return p;
    }

    /**
     * get the tree of data
     * @return the tree array
     */
    public int[] getParents(){
        return parents;
    }
}

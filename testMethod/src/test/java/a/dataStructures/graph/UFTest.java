package a.dataStructures.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Siyuan Li
 * @version 1.0.0
 **/
public class UFTest {

    public List<int[]> funTest() {
        List<int[]> rs = new ArrayList<>();
        //round 1
        rs.add(new int[]{10});
        rs.add(new int[]{1, 3});
        rs.add(new int[]{4, 3});
        rs.add(new int[]{3, 4});
        rs.add(new int[]{3, 1});
        rs.add(new int[]{4, 5});
        rs.add(new int[]{5, 7});
        rs.add(new int[]{7, 2});
        rs.add(new int[]{6, 9});
        return rs;
    }

    @Test
    public void testCommon() {
        List<int[]> data = new ArrayList<>();
        data.add(new int[]{10});
        data.add(new int[]{1, 3});
        data.add(new int[]{4, 3});
        data.add(new int[]{3, 4});
        data.add(new int[]{3, 1});

        UF ufC = new UFCommon(data.get(0)[0]);
        data.forEach((nodes) -> {
            if (nodes.length == 2) {
                ufC.union(nodes[0], nodes[1]);
            }
        });

        System.out.println(Arrays.toString(ufC.getParents()));
        Assert.assertTrue(ufC.isConnect(1, 3));
        Assert.assertTrue(ufC.isConnect(3, 1));
        Assert.assertTrue(ufC.isConnect(4, 3));
        Assert.assertTrue(ufC.isConnect(4, 4));
        Assert.assertFalse(ufC.isConnect(1, 2));
        Assert.assertFalse(ufC.isConnect(4, 2));
        Assert.assertFalse(ufC.isConnect(3, 2));
        Assert.assertEquals(2, ufC.count());
    }

    @Test
    public void testForest(){
        List<int[]> data = funTest();

        UF ufC = new UFCreateForest(data.get(0)[0]);
        data.forEach((nodes) -> {
            if (nodes.length == 2) {
                ufC.union(nodes[0], nodes[1]);
            }
        });

        System.out.print("[");
        for (int i = 0; i < ufC.getParents().length; i++) {
            System.out.print(i + ", ");
        }
        System.out.println("]");
        System.out.println(Arrays.toString(ufC.getParents()));
        Assert.assertTrue(ufC.isConnect(1, 3));
        Assert.assertTrue(ufC.isConnect(3, 1));
        Assert.assertTrue(ufC.isConnect(4, 3));
        Assert.assertTrue(ufC.isConnect(4, 2));
        Assert.assertTrue(ufC.isConnect(3, 2));
        Assert.assertEquals(6, ufC.count());
    }

    @Test
    public void showDifferent() {
        List<int[]> data = funTest();
        UF ufc = new UFCommon(data.get(0)[0]);
        UF ufF = new UFCreateForest(data.get(0)[0]);
        data.forEach((nodes) -> {
            if (nodes.length == 2) {
                ufc.union(nodes[0], nodes[1]);
                ufF.union(nodes[0],nodes[1]);
            }
        });
        System.out.print("[");
        for (int i = 0; i < ufc.getParents().length; i++) {
            System.out.print(i + ", ");
        }
        System.out.println("]");
        System.out.println(Arrays.toString(ufc.getParents()));
        System.out.println(Arrays.toString(ufF.getParents()));
    }

}

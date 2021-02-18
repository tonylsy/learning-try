package a.leetcode;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

/**
 * @Description
 * https://leetcode-cn.com/problems/reshape-the-matrix/
 * @author Siyuan Li
 * @version 1.0.0
 **/
public class Reshape {
    public static void main(String[] args) {
        int[][] nums1 = {{1,2},{3,4}};
        int r1 = 1,c1 = 4;
        int[][] rs1 = {{1,2,3,4}};

        int[][] rs11 = matrixReshape(nums1,r1,c1);
        for (int i = 0; i < rs1.length; i++) {
            for (int j = 0; j < rs1[i].length; j++) {
                if(rs1[i][j] != rs11[i][j]){
                    System.out.println("false is !"+"("+i+","+"j"+")");
                    break;
                }
            }
        }


        int r2 = 2,c2 = 4;
        int[][] rs2 = {{1,2},{3,4}};
        int[][] rs22 = matrixReshape(nums1,r2,c2);
        for (int i = 0; i < rs2.length; i++) {
            for (int j = 0; j < rs2[i].length; j++) {
                if(rs2[i][j] != rs22[i][j]){
                    System.out.println("false is !"+"("+i+","+"j"+")");
                    break;
                }
            }
        }
    }

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        Queue<Integer> q = new ArrayDeque<>();
        for (int[] num : nums) {
            for (int j : num) {
                q.add(j);
            }
        }
        if(q.size() < r * c){
            return nums;
        }
        int[][] res = new int[r][c];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                Integer number = q.poll();
                if(Objects.isNull(number)){
                    return nums;
                }
                res[i][j] = number;
            }
        }
        return res;
    }
}

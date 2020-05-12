// https://leetcode-cn.com/problems/sort-the-matrix-diagonally/solution/bao-li-jie-fa-by-liweiwei1419/

package algorithm.Sort.p1329;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int diagLen = m + n - 1;
        ArrayList<Integer>[] diags = new ArrayList[diagLen];
        // 每一条对角线都创建一个动态数组
        for (int i = 0; i < diagLen; i++) {
            diags[i] = new ArrayList<Integer>(m);
        }
        // 遍历原始矩阵，把原始矩阵中的元素放进对应的动态数组中
        // 主对角线上元素的特点是：纵坐标 - 横坐标 = 定值
        // 加上偏移 m - 1 是为了能够放进数组中
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diags[j - i + (m - 1)].add(mat[i][j]);
            }
        }
        for (int i = 0; i < diagLen; i++) {
            Collections.sort(diags[i]);
        }
        int[][] res = new int[m][n];
        int[] next = new int[diagLen];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = j - i + m - 1;
                res[i][j] = diags[index].get(next[index]++);
            }
        }
        return res;
    }
// 以下为1ms代码
//    public int[][] diagonalSort(int[][] mat) {
//        int m = mat.length;
//        int n = mat[0].length;
//        for(int i = 0; i < n; i++) {
//            helper(mat, m - 1, i);
//        }
//        for(int i = 0; i < m - 1; i++) {
//            helper(mat, i, n - 1);
//        }
//        return mat;
//    }
//
//    private void helper(int[][] mat, int xStart, int yStart) {
//        int[] bucket = new int[101];
//        for(int x = xStart, y = yStart; x >= 0 && y >= 0; x--, y--) {
//            int val = mat[x][y];
//            bucket[val]++;
//        }
//        int val = 100;
//        for(int x = xStart, y = yStart; x >= 0 && y >= 0; x--, y--) {
//            while(bucket[val] <= 0) {
//                val--;
//            }
//            mat[x][y] = val;
//            bucket[val]--;
//        }
//    }

    public static void main(String[] args){

    }
}

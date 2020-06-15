package algorithm.Tree.p700;

import utils.TreeNode;

/**
 * @Author Friende.Peng_You
 * @Date 2020-06-15 21:09
 * @Reference Myself https://leetcode.com/problems/search-in-a-binary-search-tree/discuss/688657/Java-beats-100-avoid-redundant-recursion
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)    {return null;}
        if (root.val == val)    {return root;}

        TreeNode node1, node2;
        node1 = searchBST(root.left, val);
        if (node1 == null) {
            node2 = searchBST(root.right, val);
            return node2;
        }
        else {
            return node1;
        }
    }
}

package algorithm.Tree.p226;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Friende.Peng_You
 * @Date 2020-06-16 14:44
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)   {return root;}

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            final TreeNode node = q.poll();
            final TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            // Do not offer a null
            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }
        }
        return root;
    }
}

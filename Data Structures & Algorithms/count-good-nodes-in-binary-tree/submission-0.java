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

class Solution {
    public int ans = 1;
    public void tmp(TreeNode root, int max) {
        if(root == null) {
            return;
        }
        if(max <= root.val) {
            ans = ans + 1;
            max = root.val; 
        }

        tmp(root.left, max);
        tmp(root.right, max);

    }
    public int goodNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        tmp(root.left, root.val);
        tmp(root.right, root.val);

        return ans;
    }
}

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
    int ind = 0;
    public int indx(int [] inorder, int ele, int left, int right) {
        for(int i = left; i <= right; i ++) {
            if(inorder[i] == ele) {
                return i;
            }
        }

        return -1;
    }
    public TreeNode fun(int[] preorder, int[] inorder, int left, int right) {
        if(left > right) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[ind]);
        int x =  indx(inorder, preorder[ind], left, right);
        ind++;
        root.left = fun(preorder, inorder, left, x - 1);
        root.right = fun(preorder, inorder, x + 1, right);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if(n == 0) {
            return null;
        }

        int left = 0;
        int right = n-1;
        return fun(preorder, inorder, left, right);
    }
}

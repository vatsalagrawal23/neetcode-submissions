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
    public class Pair {
        public TreeNode x;
        public int level;
        public Pair(TreeNode x, int level) {
            this.x = x;
            this.level = level;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        if(root == null) {
            return ans;
        }
        int prevL = 0;
        Pair p = new Pair(root, 1);
        q.add(p);
        while(!q.isEmpty()) {
            Pair tmp = q.poll();
            if(tmp.level > prevL) {
                List<Integer> tx = new LinkedList<>();
                tx.add(tmp.x.val);
                ans.add(tx);
                prevL = tmp.level;
            }
            else {
                (ans.get(ans.size() - 1)).add(tmp.x.val);
            }
            if(tmp.x.left != null) {
                Pair pTmp = new Pair(tmp.x.left, tmp.level + 1);
                q.add(pTmp);
            }
            if(tmp.x.right != null) {
                Pair pTmp = new Pair(tmp.x.right, tmp.level + 1);
                q.add(pTmp);
            }
        }

        return ans;
    }
}

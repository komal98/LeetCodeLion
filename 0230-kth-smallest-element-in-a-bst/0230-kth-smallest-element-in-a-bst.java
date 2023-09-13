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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res.get(k-1);
    }

    public void inOrder(TreeNode root, List<Integer> res){
        if(root == null) return;//base case
        inOrder(root.left, res);//recursing the left side
        res.add(root.val);//root node visited
        inOrder(root.right, res);
    }
}

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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> sublist = new ArrayList<>();

        pathSum(list,sublist,root,targetSum);
        return list;

    }

    public void pathSum(List<List<Integer>> list, List<Integer> sublist, TreeNode node, int sum){
        if(node == null) return;

        sum -= node.val;
        sublist.add(node.val);

        if(sum == 0 && node.left==null && node.right==null){
            list.add(new ArrayList<Integer>(sublist));
        }

        pathSum(list,sublist,node.left,sum);
        pathSum(list,sublist,node.right,sum);

        sublist.remove(sublist.size()-1);
    }
}
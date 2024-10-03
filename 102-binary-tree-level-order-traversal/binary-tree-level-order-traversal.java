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
    public List<List<Integer>> levelOrder(TreeNode root) {
      if(root == null) return new ArrayList<>();

      //initialize the ans
      List<List<Integer>> ans = new ArrayList<>();
      //BFS means Queue is needed
      Queue<TreeNode> nodes = new LinkedList<>();

      nodes.add(root);
      nodes.add(null); //null signfies end of a particular level

      while(!nodes.isEmpty()){
          int size = nodes.size();
          List<Integer> list = new ArrayList<>();

          //traverse all elements at a particular level
          for(int i = 0; i<size; i++){
              TreeNode node = nodes.poll();
              if(node == null) break;

              if(node.left!=null){
                  nodes.add(node.left);
              }
              if(node.right!=null){
                  nodes.add(node.right);
              }

              list.add(node.val);
          }
          ans.add(list);
          if(!nodes.isEmpty()) nodes.add(null);
      }

        return ans;
    }
}
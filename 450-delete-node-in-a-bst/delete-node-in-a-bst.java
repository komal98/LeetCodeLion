/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    // Return the minimum value node of the BST.
public TreeNode minValueNode(TreeNode root) {
    TreeNode curr = root;
    while(curr != null && curr.left != null) {
        curr = curr.left;
    }
    return curr;
}

// Remove a node and return the root of the BST.
public TreeNode deleteNode(TreeNode root, int val) {
    if (root == null) {
        return null;
    }
    if (val > root.val) {
        root.right = deleteNode(root.right, val);
    } else if (val < root.val) {
        root.left = deleteNode(root.left, val);
    } else {
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        } else {
            TreeNode minNode = minValueNode(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        }
    }
    return root;
}    

}
class Solution {
    public int numTrees(int n) {
       int[] dp = new int[n+1];
       dp[0] = 1;

       for(int i = 1; i<=n; i++){
           for(int j = 0; j<i; j++){
               dp[i] = dp[i] + dp[j]*dp[i-1-j];
           }
       } 
       return dp[n];
    }
}
/*
Number of BST = (number of ways root can be choosen) * (number of left Binary Search sub trees) * (number of right binary Search Sub trees)

We can find the number of BST recursively as :
1. Choose 1 as the root, no element in the left sub tree and n-1 elements in the right sub tree
2. Choose 2 as root, 1 element in the left sub tree and n-2 elements in the right sub tree
3. Choose 3 as root, 2 elements in the left sub tree and n-3 elements in the right sub tree
.
.
.
.
.
.
this works because n is increasing from 1,2,3... so if we chose 3 as root only two elements less than that can be in the left sub tree and the remaining greater will be in the right sub tree.

For the ith element, i-1 elements will be in the left sub tree and n-i elements will be in the right sub tree.
These sub trees are also BSTs:
C(n) = C(0)C(n-1) + C(1)C(n-2) + C(2)C(n-3).........C(n-1)C(0)
*/
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        //transpose - making columns rows 
        for(int i = 0; i < n; i++){
            for(int j = i+1; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //reverse each row of matrix
        for(int i = 0; i<n; i++){
            int start = 0, end = n-1;
            while(start<=end){
                int temp = matrix[i][end];
                matrix[i][end] = matrix[i][start];
                matrix[i][start] = temp;
                end--;
                start++; 
            }
        }
        
    }
}
/*
[1,2,3 transpose   [1,4,7  reverse row    [7,4,1
 4,5,6 -----------> 2,5,8 -------------->  8,5,2
 7,8,9              3,6,9]                 9,6,3]
 ]
*/
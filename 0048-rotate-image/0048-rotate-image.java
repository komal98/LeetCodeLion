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
            int low = 0, high = n-1;
            while(low<=high){
                int temp = matrix[i][high];
                matrix[i][high] = matrix[i][low];
                matrix[i][low] = temp;
                high--;
                low++; 
            }
        }
        
    }
}
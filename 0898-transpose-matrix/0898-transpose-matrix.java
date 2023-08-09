class Solution {
    public int[][] transpose(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] transposedMatrix = new int[m][n];
        
        for (int row=0; row<m; row++){
            for (int col=0; col<n; col++){
                
                transposedMatrix[row][col] = matrix[col][row];
        }
        }
        return transposedMatrix;
    }
}
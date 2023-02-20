class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < n-1; j++){
                if( i+j == n-1 ) break;
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][n-1-i];
                matrix[n-1-j][n-1-i] = tmp;
            }
        }
        
        for(int i = 0; i < n/2; i++){
            for(int j = 0; j < n; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = tmp;
            }
        }
        
    }
}
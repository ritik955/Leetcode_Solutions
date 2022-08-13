class Solution {
   public int[][] matrixBlockSum(int[][] mat, int K) {
    int m = mat.length;
    int n = mat[0].length;
    int[][] temp = new int[m + 1][n + 1];
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            temp[i + 1][j + 1] = temp[i+1][j] + temp[i][j+1] - temp[i][j] + mat[i][j];
        }
    }
    int[][] res = new int[m][n];
     for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            int r1 = Math.max(0, i - K);
            int c1 = Math.max(0, j - K);
            int r2 = Math.min(m, i + K + 1);
            int c2 = Math.min(n, j + K + 1);
            res[i][j] =temp[r2][c2] - temp[r2][c1] - temp[r1][c2] + temp[r1][c1];
        }
    }
    return res;
}
}
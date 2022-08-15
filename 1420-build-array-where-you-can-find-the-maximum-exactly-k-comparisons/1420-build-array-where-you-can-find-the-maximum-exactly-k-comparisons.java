class Solution {
    public int numOfArrays(int n, int m, int k) {
        int mod = (int)1e9 + 7;
        long[][][] dp = new long[n][k + 1][m + 1];
        for(int maxV = 1; maxV <= m; maxV++) {
            dp[0][1][maxV] = 1;
        }
        for(int i = 1; i < n; i++) {
            for(int j = 1; j <= k; j++) {
                for(int maxV = 1; maxV <= m; maxV++) {
                    //newly added number is not a new max value
                    dp[i][j][maxV] = (dp[i][j][maxV] + dp[i - 1][j][maxV] * maxV) % mod;
                    //newly added number is a new max value
                    for(int smallerV = 1; smallerV < maxV; smallerV++) {
                        dp[i][j][maxV] = (dp[i][j][maxV] + dp[i - 1][j - 1][smallerV]) % mod;
                    }
                }
            }
        }
        long ans = 0;
        for(int v = 1; v <= m; v++) {
            ans = (ans + dp[n - 1][k][v]) % mod;
        }
        return (int)ans;
    }
}
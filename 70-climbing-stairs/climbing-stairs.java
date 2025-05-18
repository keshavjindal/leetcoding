class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 10];
        Arrays.fill(dp , -1);
        dp[1] = 1;
        dp[2] = 2;
        return solve(n, dp);
    }

    public int solve(int i, int[] dp){
        if(i <= 2 || dp[i] != -1) return dp[i];
        return dp[i] = solve(i - 1, dp) + solve(i - 2, dp);
    }
}
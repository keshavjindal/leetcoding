class Solution {
    public int fib(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp , -1);
        return fib2(n, dp);
    }

    public int fib2(int n, int[] dp){
        if(n == 0 || n == 1) return n;

        if(dp[n] != -1) return dp[n];

        return dp[n] = fib2(n - 1, dp) + fib2(n - 2, dp);
    }
}
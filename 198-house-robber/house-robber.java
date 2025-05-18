class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 10];
        Arrays.fill(dp , -1);
        return solve(nums , n - 1, dp);
    }

    public int solve(int[] arr, int i, int[] dp){
        if(i < 0) return 0;

        if(dp[i] != -1) return dp[i];

        int robIthHouse = arr[i] + solve(arr , i - 2, dp);
        int notRobIthHouse = solve(arr , i - 1, dp);
        return dp[i] = Math.max(robIthHouse , notRobIthHouse);
    }
}
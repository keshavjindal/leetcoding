class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length + 10];
        Arrays.fill(dp , -1);
        return solve(nums , 0, dp);
    }

    public boolean solve(int[] arr, int i, int[] dp){
        if(i >= arr.length - 1) return true;
        if(dp[i] != -1){
            if(dp[i] == 0) return false;
            else return true;
        }
        int jump = arr[i];
        for(int idx=i+1; idx<=i+jump; idx++){
            boolean temp = solve(arr , idx, dp);
            if(temp == true){
                dp[i] = 1;
                return true;
            }
        }
        dp[i] = 0;
        return false;
    }
}
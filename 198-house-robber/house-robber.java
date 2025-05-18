class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        int max = nums[0];
        dp[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            dp[i] = Math.max(nums[i] + (i-2<0 ? 0 : dp[i - 2]) , dp[i - 1]);
            max = Math.max(max , dp[i]);
        }   
        return max;
    }

    /**
    
           1  2  3  1
 include.  1. 
exclude    0    
    
    
     */
}
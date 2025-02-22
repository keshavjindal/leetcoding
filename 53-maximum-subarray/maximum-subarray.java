class Solution {
    public int maxSubArray(int[] nums) {
        // bruteforce: consider all subarray sums

        int n = nums.length;
        int csum = nums[0];
        int ans = nums[0];

        for(int i=1; i<n; i++){
            // if current sum is negative, nums[i] would want to start a new train.
            // nums[i] dont want a negative bagage from its left
            if(csum < 0) csum = nums[i];  
            else csum += nums[i];

            ans = Math.max(ans, csum);
        }

        return ans;
    }
}
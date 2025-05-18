class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] include = new int[n];
        int[] exclude = new int[n];

        int max = nums[0];
        include[0] = nums[0];
        exclude[0] = 0;
        for(int i=1; i<nums.length; i++){
            include[i] = nums[i] + exclude[i - 1];
            exclude[i] = Math.max(include[i - 1] , exclude[i - 1]);
            max = Math.max(include[i] , exclude[i]);
        }
        return max;
    }

    /**
    
           1  2  3  1
 include.  1. 
exclude    0    
    
    
     */
}
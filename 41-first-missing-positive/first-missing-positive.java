class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean isOnePresent = false;
        int n = nums.length;

        System.out.println(Arrays.toString(nums));

        for(int i=0; i<n; i++){
            if(nums[i] == 1){
                isOnePresent = true;
            }

            if(nums[i] <= 0 || nums[i] > n){
                nums[i] = 1;
            }

        }

        if(!isOnePresent) return 1;

        System.out.println(Arrays.toString(nums));

        for(int i=0; i<n; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0) continue;
            nums[index] *= -1;
        }

        for(int i=0; i<n; i++){
            if(nums[i] > 0) return i + 1;
        }

        return n + 1;
    }
}
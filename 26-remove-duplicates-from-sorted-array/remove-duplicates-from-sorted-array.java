class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int reader = 1;
        int writer = 1;
        while(reader < nums.length){
            if(nums[reader] == nums[reader - 1]){
                reader++;
            }
            else{
                count++;
                nums[writer] = nums[reader];
                writer++;
                reader++;
            }
        }

        return count;
    }
}
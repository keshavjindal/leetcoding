class Solution {
    public int removeDuplicates(int[] nums) {
        int reader = 1;
        int writer = 1;
        int currCount = 1;
        int count = 1;

        while(reader < nums.length){
            if(nums[reader] == nums[reader - 1]){
                currCount++;
                if(currCount <= 2){
                    // write
                    count++;
                    nums[writer] = nums[reader];
                    writer++;
                    reader++;
                }
                else{
                    reader++;
                }
            }
            else{
                count++;
                currCount = 1;
                nums[writer] = nums[reader];
                writer++;
                reader++;
            }
        }

        return count;
    }
}
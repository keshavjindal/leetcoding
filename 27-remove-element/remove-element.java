class Solution {
    public int removeElement(int[] nums, int val) {
        // Approach: Two pointers: Leetcode editorial
        // Using reader - writer pointers
        // Values of original elements is NOT conserved!

        int reader = 0;
        int writer = 0;

        int count = 0;

        while(reader < nums.length){
            if(nums[reader] != val){
                count++;

                nums[writer] = nums[reader];

                reader++;
                writer++;
            }else{
                reader++;
            }
        }

        return count;
    }
}
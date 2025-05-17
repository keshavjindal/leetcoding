class Solution {
    public int removeElement(int[] nums, int val) {
        // Approach: Two pointers: Subhesh Sir method
        // Using Swapping
        // Values of original elements is conserved

        int i = 0;
        int j = 0; // unknown

        int count = 0;
        while(j < nums.length){
            if(nums[j] == val){
                j++;
            }else{
                count++;

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i++;
                j++;
            }
        }

        return count;
    }
}
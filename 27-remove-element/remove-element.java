class Solution {
    public int removeElement(int[] nums, int val) {
        // brute force ghatiya tarika

        int[] temp = new int[nums.length];
        int idx = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != val){
                temp[idx] = nums[i];
                idx++;
            }
        }

 

        for(int i=0; i<idx; i++){
            nums[i] = temp[i];
        }

        return idx;
    }
}
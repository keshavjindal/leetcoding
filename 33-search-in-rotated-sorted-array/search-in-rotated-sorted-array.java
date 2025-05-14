class Solution {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while(lo <= hi){
            int mid = lo + (hi - lo)/2;

            if(target == nums[mid]){
                return mid;
            }
            else if(nums[mid] >= nums[lo]){
                // left sorted
                if(nums[lo] <= target && target <= nums[mid]) hi = mid - 1;
                else lo = mid + 1;
            }
            else{
                // right sorted
                if(nums[mid] <= target && target <= nums[hi]) lo = mid + 1;
                else hi = mid - 1;
            }
        }

        return -1;
    }
}
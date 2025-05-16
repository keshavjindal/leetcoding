class Solution {
    public int searchInsert(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;

        int mid = 0;
        while(lo <= hi){
            mid = lo + (hi - lo)/2;

            if(arr[mid] == target) return mid;
            else if(target > arr[mid]) lo = mid + 1;
            else hi = mid - 1;
        }

        // element not found
        if(target > arr[mid]) return mid + 1;
        else return mid;
    }

    /**
           0 1 2 3 
    arr -> 1 3 5 6
    target -> 2
    ans -> 1

    lo -> 0
    hi -> 3
    mid -> 1
    
     */
}
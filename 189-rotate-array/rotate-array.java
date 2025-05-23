class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
       

        k = k % n; // k -> 0 to n - 1

        reverse(nums , 0 , n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0 , n - 1);
        
    }

    public void reverse(int[] arr, int si, int ei){
        // reverse the array from i to j index
        int i = si;
        int j = ei;

        // if(i < 0 || j < 0 || i >= arr.length || j >= arr.length) return;

        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }
        
    }

    /**
        k = 3
        n = 8.  
        n - k.     k


          i.       j
       7 6 2 3 4 5 1 0



        4 3 2 1 0 7 6 5
        5 6 7 0 1 2 3 4
     */
}
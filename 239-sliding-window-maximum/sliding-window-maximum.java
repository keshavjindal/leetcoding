class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        /*
        divide the array into k-k size boxes
                    
                    0 1  2    3 4 5
                    1 3 -1   -3 5 3    6 7 
          leftmax   1 3 3    -3 5 5    6 7 
         rightmax   3 3-1     5 5 3    7 7   
        
            ans -> 3 3 5
            
            ans[i] -> max(left[i + k - 1] , right[i])
        */
        
        int n = arr.length;
        
        int[] leftmax = new int[n];
        for(int i=0; i<n; i++){
            if(i % k == 0){
                // i is the starting point of a box
                leftmax[i] = arr[i];
            }
            else{
                leftmax[i] = Math.max(leftmax[i - 1] , arr[i]);
            }
        }
        
        int[] rightmax = new int[n];
        for(int i=n-1; i>=0; i--){
            if((i + 1) % k == 0){
                // i is the endpoint of a box
                rightmax[i] = arr[i];
            }
            else{
                rightmax[i] = Math.max(arr[i] , i + 1 >= n ? Integer.MIN_VALUE : rightmax[i + 1]);
            }
        }
        
        
        int[] ans = new int[n - k + 1];
        for(int i=0; i<ans.length; i++){
            ans[i] = Math.max(rightmax[i] , leftmax[i + k - 1]);
        }
        return ans;
    }
}
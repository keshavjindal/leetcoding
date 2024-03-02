class Solution {
    public int maxSubArray(int[] arr) {
        int csum = arr[0];
        int ans = arr[0];
        
        for(int i=1; i<arr.length; i++){
            if(csum < 0) csum = arr[i];
            else csum += arr[i];
            
            ans = Math.max(ans , csum);
        }
        
        return ans;
    }
    
    /*
        -2 1 -3 4 -1 2 1 -5 4
        
        csum -> 6
        ans -> 6
    
    */
}
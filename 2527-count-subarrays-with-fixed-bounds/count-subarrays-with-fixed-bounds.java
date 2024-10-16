class Solution {
    public long countSubarrays(int[] arr, int minK, int maxK) {
        int n = arr.length;
        long ans = 0;
        int minidx = -1;
        int maxidx = -1;
        int invalid = -1;
        
        for(int i=0; i<n; i++){
            if(arr[i] == minK) minidx = i;   
            
            if(arr[i] == maxK) maxidx = i;
            
            if(arr[i] < minK || arr[i] > maxK) invalid = i;
            
            ans += Math.max(0 , Math.min(minidx , maxidx) - invalid);
        }
        
        
        return ans;
    }
}
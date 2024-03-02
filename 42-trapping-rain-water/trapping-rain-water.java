class Solution {
    public int trap(int[] height) {
        // gen leftmax
        int n = height.length;
        int[] lm = new int[n];
        lm[0] = height[0];
        for(int i=1; i<n; i++){
            lm[i] = Math.max(lm[i - 1] , height[i]);
        }
        
        // gen rightmax
        int[] rm = new int[n];
        rm[n - 1] = height[n - 1];
        for(int i=n-2; i>=0; i--){
            rm[i] = Math.max(rm[i + 1] , height[i]);
        }
        
        // gen ans
        int ans = 0;
        
        for(int i=1; i<=n-2; i++){
            int val = Math.min(lm[i] , rm[i]);
            
            if(height[i] < val){
                ans += (val - height[i]);
            }
        }
        
        return ans;
    }
}
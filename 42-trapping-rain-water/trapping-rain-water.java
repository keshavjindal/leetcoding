class Solution {
    public int trap(int[] arr) {
        int ans = 0;
        int n = arr.length;
        
        int i = 0;
        int j = n - 1;
        
        int lm = 0;
        int rm = 0;
        
        while(i <= j){
            if(arr[i] <= arr[j]){
                // lm is less than rm
                if(lm > arr[i]) ans += (lm - arr[i]);
                else lm = arr[i];
                
                i++;
            }
            else{
                // rm is less than lm
                if(rm > arr[j]) ans += (rm - arr[j]);
                else rm = arr[j];
            
                j--;
            }
        }
        
        return ans;
    }
}
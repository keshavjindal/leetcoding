class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        
        int ans = 0;
        int leftmax = 0;
        int rightmax = 0;
        int i = 0;
        int j = n-1;
        
        while(i < j)
        {
            if(arr[i] <= arr[j])
            {
                if(leftmax > arr[i]) ans += leftmax - arr[i];
                else leftmax = arr[i];
                
                i++;
            }
            else
            {
                if(rightmax > arr[j]) ans += rightmax - arr[j];
                else rightmax = arr[j];
                
                j--;
            }
        }
        
        return ans;
    }
}
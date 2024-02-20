class Solution {
    public void moveZeroes(int[] arr) {
        int i = 0;
        int j = 1;
        
        /*
            0 1 2 3 4
            0 1 0 3 12
            
            
        */
        
        while(i < arr.length){
            if(arr[i] == 0){
                i++;
            }
            else{
                int temp = arr[i];
                arr[i] = arr[j - 1];
                arr[j - 1] = temp;
                
                i++;
                j++;
            }
        }
        
        
    }
}
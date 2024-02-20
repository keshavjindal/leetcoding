class Solution {
    public void moveZeroes(int[] arr) {
        int i = 0;
        int j = 0;
        
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
                arr[i] = arr[j];
                arr[j] = temp;
                
                i++;
                j++;
            }
        }
        
        
    }
}
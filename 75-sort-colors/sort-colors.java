class Solution {
    public void sortColors(int[] arr) {
        /*
            0's????????1's
            00000 1111?????2222
                  j.  i.  k 
            
            i -> unknown
            j -> pehle 1 pe
            k -> pehle 2 pe
        
        */
        int i = 0;
        int j = 0;
        int k = arr.length - 1;
        
        while(i <= k){
            if(arr[i] == 1){
                i++;
            }
            else if(arr[i] == 0){
                swap(arr , i , j);
                i++;
                j++;
            }
            else if(arr[i] == 2){
                swap(arr , i , k);
                k--;
            }
        }
    }
    
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
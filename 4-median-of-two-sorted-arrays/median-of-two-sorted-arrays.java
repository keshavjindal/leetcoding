class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /*
            1 , 3
            2
            
            merge the two sorted arrays O(m + n)
            return the median
        */ 
        
        int[] arr = mergeTwoSortedArrays(nums1 , nums2);
        
        if(arr.length % 2 == 0){
            int n = arr.length;
            return ((double)arr[n/2] + (double)arr[(n/2) - 1]) / 2.0;    
        
        }
        else{
            return (double)arr[arr.length / 2];
        }
    }
    
    public int[] mergeTwoSortedArrays(int[] a , int[] b){
        int[] arr = new int[a.length + b.length];
        
        int i = 0;
        int j = 0;
        int k = 0;
        
        while(i < a.length && j < b.length){
            if(a[i] <= b[j]){
                arr[k] = a[i];
                i++;
            }
            else{
                arr[k] = b[j];
                j++;
            }
            
            k++;
        }
        
        while(i < a.length){
            arr[k] = a[i];
            i++;
            k++;
        }
        
        while(j < b.length){
            arr[k] = b[j];
            j++;
            k++;
        }
        
        return arr;
    }
}
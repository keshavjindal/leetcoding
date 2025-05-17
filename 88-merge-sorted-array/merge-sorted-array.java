class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // nums1 -> m + n (length)
        // nums2 -> n (length)

        int i = m - 1;
        int j = n - 1;
        int k = (m + n) - 1;

        while(i >= 0 && j >= 0){
            int one = nums1[i];
            int two = nums2[j];

            if(one > two){
                int temp = nums1[i];
                nums1[i] = nums1[k];
                nums1[k] = temp;

                k--;
                i--;
            }
            else{
                int temp = nums2[j];
                nums2[j] = nums1[k];
                nums1[k] = temp;

                j--;
                k--;
            }
        }

        while(i >= 0){
            int temp = nums1[i];
            nums1[i] = nums1[k];
            nums1[k] = temp;

            k--;
            i--;
        }

        while(j >= 0){
            int temp = nums2[j];
            nums2[j] = nums1[k];
            nums1[k] = temp;

            j--;
            k--;
        }
    }
}
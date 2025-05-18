class Solution {
    public boolean canJump(int[] arr) {
        // using greedy
        // very good logic
        // good index -> i is a good index if we can reach from i to last
        // we need to find leftmost good index
        // return leftmost_good_index == 0(start)

        int n = arr.length;
        int leftMostGoodIndex = n - 1; // where we want to reach
        for(int i=n-1; i>=0; i--){
            if(i + arr[i] >= leftMostGoodIndex){
                leftMostGoodIndex = i;
            }
        }

        return leftMostGoodIndex == 0;

    }
}
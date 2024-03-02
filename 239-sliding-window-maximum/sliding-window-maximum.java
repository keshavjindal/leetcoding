class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        
        for(int i=0; i<k; i++){
            while(deque.size() > 0 && arr[i] >= arr[deque.getLast()]){
                deque.removeLast();
            }

            deque.addLast(i);
        }

        int[] ans = new int[arr.length - k + 1];

        ans[0] = arr[deque.getFirst()];

        for(int i=k; i<arr.length; i++){
            while(deque.size() > 0 && deque.getFirst() <= i - k){
                deque.removeFirst();
            }

            while(deque.size() > 0 && arr[i] >= arr[deque.getLast()]){
                deque.removeLast();
            }

            deque.addLast(i);

            ans[i - k + 1] = arr[deque.getFirst()];
        }

        return ans;
    }
}
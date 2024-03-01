class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        PriorityQueue<pair> pq = new PriorityQueue<>(); // max-heap
        
        int n = arr.length;
        int[] ans = new int[n - k + 1];
        
        for(int i=0; i<k; i++){
            pq.add(new pair(arr[i] , i));
        }
        
        ans[0] = pq.peek().val;
        
        for(int i=k; i<arr.length; i++){
            pq.add(new pair(arr[i] , i));
            
            while(pq.peek().idx <= i - k){
                pq.remove();
            }
            
            ans[i - k + 1] = pq.peek().val;
        }
        
        return ans;
    }
    
    public class pair implements Comparable<pair>
    {
        int val;
        int idx;
        
        pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
        
        public int compareTo(pair o){
            return o.val - this.val;
        }
    }
}
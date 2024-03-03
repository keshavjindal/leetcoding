/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        for(int i=0; i<lists.length; i++){
            if(lists[i] != null) pq.add(lists[i]);
        }
        
        if(pq.size() == 0) return null;
        
        ListNode ans = new ListNode(-1);
        ListNode helper = ans;
        
        while(pq.size() > 0){
            ListNode rem = pq.remove();
        
            ans.next = rem;
            ans = rem;
            
            if(rem.next != null) pq.add(rem.next);
        }
        
        return helper.next;   
    }
}
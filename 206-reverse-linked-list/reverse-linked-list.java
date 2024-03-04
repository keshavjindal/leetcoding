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
    public ListNode reverseList(ListNode head) {
        /*
         1 -> 2 -> 3 -> 4
         
         1.  2 -> 3 -> 4
         
         curr -> 2 
         prev -> None
         temp -> 3
        
        */
        
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr != null){
            ListNode temp = curr.next;
            
            curr.next = prev;
            
            prev = curr;
            curr = temp;
        }
        
        return prev;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        
        // we want that lenA is greater than lenB
        if(lenB > lenA){
            return getIntersectionNode(headB, headA);
        }
        
        ListNode currA = headA;
        for(int i=0; i<(lenA-lenB); i++){
            currA = currA.next;
        }
        
        ListNode currB = headB;
        
        while(currA != currB){
            currA = currA.next;
            currB = currB.next;
        }
        
        return currA;
    }
    
    public int getLength(ListNode node){
        ListNode curr = node;
        int len = 0;
        while(curr != null){
            len += 1;
            curr = curr.next;
        }
        return len;
    }
}
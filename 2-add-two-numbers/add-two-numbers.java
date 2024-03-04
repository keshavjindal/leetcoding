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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode one = l1;
        ListNode two = l2;
        
        ListNode ans = new ListNode(-1);
        ListNode temp = ans;
        
        int carry = 0;
        
        while(one != null && two != null){
            int sum = one.val + two.val + carry;
            carry = 0;
            
            if(sum <= 9){
                ListNode node = new ListNode(sum);
                temp.next = node;
                temp = node;
            }
            else{
                ListNode node = new ListNode(sum % 10);
                temp.next = node;
                temp = node;
                
                carry = 1;
            }
            
            one = one.next;
            two = two.next;
        }
        
        while(one != null){
            int sum = one.val + carry;
            carry = 0;
            
            if(sum <= 9){
                ListNode node = new ListNode(sum);
                temp.next = node;
                temp = node;
            }
            else{
                ListNode node = new ListNode(sum % 10);
                temp.next = node;
                temp = node;
                
                carry = 1;
            }
            
            one = one.next;
        }
        
        while(two != null){
            int sum = two.val + carry;
            carry = 0;
            
            if(sum <= 9){
                ListNode node = new ListNode(sum);
                temp.next = node;
                temp = node;
            }
            else{
                ListNode node = new ListNode(sum % 10);
                temp.next = node;
                temp = node;
                
                carry = 1;
            }
            
            two = two.next;
        }
        
        if(carry == 1){
            ListNode node = new ListNode(1);
            temp.next = node;
            temp = node;
        }
        
        return ans.next;
    }
}
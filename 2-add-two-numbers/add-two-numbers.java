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
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        int carry = 0;
        ListNode head = new ListNode(-1);
        ListNode temp = head;

        while(temp1 != null && temp2 != null){
            int a = temp1.val;
            int b = temp2.val;

            int sum = a + b + carry;

            int dig = sum % 10;
            carry = sum / 10;

            ListNode newnode = new ListNode(dig);
            temp.next = newnode;
            temp = temp.next;

            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        while(temp1 != null){
            int a = temp1.val;

            int sum = a + carry;

            int dig = sum % 10;
            carry = sum / 10;

            ListNode newnode = new ListNode(dig);
            temp.next = newnode;
            temp = temp.next;

            temp1 = temp1.next;
        }

        while(temp2 != null){
            int b = temp2.val;

            int sum = b + carry;

            int dig = sum % 10;
            carry = sum / 10;

            ListNode newnode = new ListNode(dig);
            temp.next = newnode;
            temp = temp.next;

            temp2 = temp2.next;
        }

        if(carry != 0){
            ListNode newnode = new ListNode(carry);
            temp.next = newnode;
            temp = temp.next;
        }

        return head.next;
    }
}
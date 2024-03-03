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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        // find middle of linked list
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        
        while(fast.next != null && fast.next.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        /*
        odd -> 1 2 3 4 5
        s -> 1 2 3
        f -> 1 3 5
        slow -> 3 (middle)
        
        
        even -> 1 2 3 4 5 6
        s -> 1 2 3
        f -> 1 3 5
        slow -> 3 (middle)
        
        */
        
        // System.out.println(slow.val);
        TreeNode node = new TreeNode(slow.val);
        if(prev != null) prev.next = null;
        if(prev == null){
            node.right = sortedListToBST(slow.next); 
        }
        else{
            node.left = sortedListToBST(head);
            node.right = sortedListToBST(slow.next); 
        }
        
        
        return node;
    }
}
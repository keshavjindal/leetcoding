/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        Node temp = head;
        while(temp != null){
            Node newnode = new Node(temp.val);
            
            Node next = temp.next;
            
            temp.next = newnode;
            newnode.next = next;
            
            temp = next;
        }
        
        temp = head;
        while(temp != null){
            if(temp.random != null){
                temp.next.random = temp.random.next;
            }
            
            temp = temp.next.next;
        }
        
        temp = head;
        Node itr = temp.next;
        Node ans = temp.next;
        
        while(temp != null){
            temp.next = itr.next;
            itr.next = itr.next == null ? null : itr.next.next;
            
            temp = temp.next;
            itr = itr.next;
        }
        
        return ans;
    }
}
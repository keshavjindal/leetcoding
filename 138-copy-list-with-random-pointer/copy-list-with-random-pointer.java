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
        HashMap<Node,Node> map = new HashMap<>();
        
        Node temp = head;
        Node ans = new Node(-1);
        Node finalans = ans;
        
        while(temp != null){
            Node newnode = new Node(temp.val);
            
            map.put(temp , newnode);
            
            ans.next = newnode;
            ans = newnode;
            
            temp = temp.next;
        }
        
        temp = head;
        
        while(temp != null){
            if(temp.random != null){
                map.get(temp).random = map.get(temp.random);
            }
            
            temp = temp.next;
        }
        
        return finalans.next;
    }
}
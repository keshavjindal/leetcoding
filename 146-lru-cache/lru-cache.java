class LRUCache {

    public int cap;
    public HashMap<Integer,Node> map;
    public Node head;
    public Node tail;
    
    public class Node{
        int key;
        int val;
        Node prev;
        Node next;
        
        Node(int key, int val){
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
        
        Node(int key, int val, Node prev, Node next){
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
    
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        
        this.head.next = tail;
        this.tail.prev = head;
        
        // printlist();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        
        int ans = map.get(key).val;
        
        removeNode(map.get(key));
        Node newnode = new Node(key,ans);
        insertInLast(newnode);
        map.put(key , newnode);
        
        // printlist();
        
        return ans;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.get(key).val = value;
            removeNode(map.get(key));
            Node newnode = new Node(key,value);
            insertInLast(newnode);
            map.put(key , newnode);
            
            return;
        }
        else{
            if(map.size() == cap){
                map.remove(this.head.next.key);
                removeNode(this.head.next);
            }
            
            Node node = new Node(key,value);
            map.put(key , node);
        }
        
        insertInLast(map.get(key));
        
        // printlist();
    }
    
    public void printlist(){
        Node temp = this.head;
        
        while(temp != null){
            System.out.print(temp.key + " ");
            temp = temp.next;
        }
        
        System.out.println();
    }
    
    public void removeNode(Node node){
        Node prev = node.prev;
        Node next = node.next;
        
        prev.next = next;
        next.prev = prev;
        
        node.next = null;
        node.prev = null;
    }
    
    public void insertInLast(Node node){
        Node prev = this.tail.prev;
        
        prev.next = node;
        this.tail.prev = node;
        
        node.prev = prev;
        node.next = this.tail;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
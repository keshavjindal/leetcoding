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
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        
        int ans = map.get(key).val;
        moveToLast(map.get(key));
        return ans;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.get(key).val = value;
            moveToLast(map.get(key));
            return;
        }
        else{
            if(map.size() == cap){
                map.remove(this.head.next.key);
                removeNode(this.head.next);
            }
            
            Node node = new Node(key,value);
            map.put(key , node);
            addNode(map.get(key));
        }
    }
       
    public void removeNode(Node node){
        Node prev = node.prev;
        Node next = node.next;
        
        prev.next = next;
        next.prev = prev;
        
        node.next = null;
        node.prev = null;
    }
    
    // adds in Last
    public void addNode(Node node){
        Node prev = this.tail.prev;
        
        prev.next = node;
        this.tail.prev = node;
        
        node.prev = prev;
        node.next = this.tail;
    }
    
    public void moveToLast(Node node){
        removeNode(node);
        addNode(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
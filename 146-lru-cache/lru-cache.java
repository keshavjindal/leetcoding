class LRUCache {
    class Node{
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    HashMap<Integer,Node> map;
    int cap;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        cap = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            int valToReturn = map.get(key).val;
            Node node = map.get(key);
            deleteNode(node);
            insertAfterHead(node);
            return valToReturn;
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)){
            if(map.size() == cap){
                Node nodeToRemove = tail.prev;
                deleteNode(nodeToRemove);
                map.remove(nodeToRemove.key);
            }

            Node newNode = new Node(key,value);
            map.put(key , newNode);
            insertAfterHead(newNode);
        }
        else{
            map.get(key).val = value;    
            deleteNode(map.get(key));   
            insertAfterHead(map.get(key));
        }        
    }

    public void deleteNode(Node node){
        Node prev = node.prev;
        prev.next = node.next;
        node.next.prev = prev;

        node.next = null;
        node.prev = null;
    }

    public void insertAfterHead(Node node){
        Node next = head.next;

        head.next = node;
        next.prev = node;

        node.prev = head;
        node.next = next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
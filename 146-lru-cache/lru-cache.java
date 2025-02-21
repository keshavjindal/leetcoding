class LRUCache {
    // HashMap and Doubly Linked List
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
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);

        this.head.next = this.tail;
        this.tail.prev = this.head;

        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        else{
            // put the corrosponding node in the last (at tail) (MOST RECENTLY USED)
            Node node = map.get(key);

            deleteNode(node);
            addAtTail(node);

            return node.val;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            // update the value
            Node node = map.get(key);
            node.val = value;

            // put the corrosponding node in the last (at tail) (MOST RECENTLY USED)
            deleteNode(node);
            addAtTail(node);
        }
        else{
            // if cache size is full, delete from HEAD (Least Recently Used)
            if(this.capacity == this.map.size()){
                Node deletedNode = deleteAtHead();
                map.remove(deletedNode.key);
            }

            // create new node
            Node node = new Node(key, value);
            map.put(key , node);

            // put the corrosponding node in the last (at tail) (MOST RECENTLY USED)
            addAtTail(node);
        }
    }

    // TAIL: Most Recently Used
    public void addAtTail(Node node){
        this.tail.prev.next = node;
        node.prev = this.tail.prev;

        this.tail.prev = node;
        node.next = this.tail;
    }

    // HEAD: Least Recently Used
    public Node deleteAtHead(){
        return deleteNode(this.head.next);
    }

    public Node deleteNode(Node node){
        Node temp = node;

        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = null;
        node.prev = null;

        return temp;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
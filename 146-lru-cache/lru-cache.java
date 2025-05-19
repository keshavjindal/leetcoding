class LRUCache {
    HashMap<Integer,Integer> map;
    ArrayList<Integer> list;
    int cap;

    public LRUCache(int capacity) {
        list = new ArrayList<>();
        map = new HashMap<>();
        cap = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            putJustUsedKeyInLeft(list , key);
            return map.get(key);
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)){
            if(list.size() == cap){
                int keyToRemove = list.remove(cap - 1);
                map.remove(keyToRemove);
            }
        }
        
        map.put(key , value);
        putJustUsedKeyInLeft(list , key);
    }

    public void putJustUsedKeyInLeft(ArrayList<Integer> list, int key){
        // put the key in leftmost index (MRU)
        for(int i=0; i<list.size(); i++){
            if(list.get(i) == key){
                list.remove(i);
                break;
            }
        }

        list.add(0 , key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
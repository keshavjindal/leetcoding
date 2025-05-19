class LFUCache {

    HashMap<Integer,Integer> keyValMap;
    HashMap<Integer,Integer> keyFreqMap;
    HashMap<Integer,LinkedHashSet<Integer>> freqKeysMap;
    int cap;
    int min;

    public LFUCache(int capacity) {
        keyValMap = new HashMap<>();
        keyFreqMap = new HashMap<>();
        freqKeysMap = new HashMap<>();
        freqKeysMap.put(1 , new LinkedHashSet<>());
        cap = capacity;
        min = 0;
    }
    
    public int get(int key) {
        if(!keyValMap.containsKey(key)) return -1;

        int currFreq = keyFreqMap.get(key);

        freqKeysMap.get(currFreq).remove(key);
        if(currFreq == min && freqKeysMap.get(currFreq).size() == 0){
            min++;
        }

        int newFreq = currFreq + 1;
        if(!freqKeysMap.containsKey(newFreq)){
            freqKeysMap.put(newFreq , new LinkedHashSet<>());
        }
        freqKeysMap.get(newFreq).add(key);

        keyFreqMap.put(key , newFreq);
        return keyValMap.get(key);
    }
    
    public void put(int key, int value) {
        if(!keyValMap.containsKey(key)){
            if(cap == keyValMap.size()){
                // remove LRU
                int keyToRemove = freqKeysMap.get(min).iterator().next();
                freqKeysMap.get(min).remove(keyToRemove);
                keyFreqMap.remove(keyToRemove);
                keyValMap.remove(keyToRemove);
            }
                
            keyValMap.put(key , value);
            keyFreqMap.put(key , 1);
            min = 1;
            freqKeysMap.get(1).add(key);
        }
        else{
            keyValMap.put(key , value);
            get(key);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
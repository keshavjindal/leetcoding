class Trie {
    // brute force way to implement a trie!
    HashSet<String> set;

    public Trie() {
        set = new HashSet<>();
    }
    
    public void insert(String word) {
        set.add(word);
    }
    
    public boolean search(String word) {
        return set.contains(word);
    }
    
    public boolean startsWith(String prefix) {
        for(String s : set){
            int i = 0;
            int j = 0;

            boolean unequalChar = false;
            while(i < prefix.length() && j < s.length()){
                if(prefix.charAt(i) != s.charAt(j)){
                    unequalChar = true;
                    break;
                }

                i++;
                j++;
            }

            if(i == prefix.length() && unequalChar == false){
                return true;
            }
        }

        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
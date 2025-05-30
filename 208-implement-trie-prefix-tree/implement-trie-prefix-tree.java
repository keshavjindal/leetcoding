class Trie {
    // prefix tree

    class Node{
        Node[] children;
        boolean ends;

        Node(){
            children = new Node[26];
            ends = false;
        }
    }  

    Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;

        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            if(curr.children[ch - 'a'] == null){
                curr.children[ch - 'a'] = new Node();
            }

            curr = curr.children[ch - 'a'];
        }

        curr.ends = true;
    }
    
    public boolean search(String word) {
        Node curr = root;

        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            if(curr.children[ch - 'a'] == null) return false;
            else {
                curr = curr.children[ch - 'a'];
            }            
        }

        return curr.ends;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;

        for(int i=0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);

            if(curr.children[ch - 'a'] == null) return false;
            else {
                curr = curr.children[ch - 'a'];
            }            
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
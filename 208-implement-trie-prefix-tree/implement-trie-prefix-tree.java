class Trie {
    
    public Node root;
    
    public class Node{
        Node[] arr;
        boolean ends;
        
        Node(){
            this.arr = new Node[26];
            this.ends = false;
        }
    }

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = this.root;
        
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            
            if(curr.arr[ch - 'a'] == null){
                curr.arr[ch - 'a'] = new Node();
            }
            
            curr = curr.arr[ch - 'a'];
        }
        
        curr.ends = true;
    }
    
    public boolean search(String word) {
        Node curr = this.root;
        
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            
            if(curr.arr[ch - 'a'] == null){
                return false;
            }
            
            curr = curr.arr[ch - 'a'];
        }
        
        if(curr.ends == true) return true;
        else return false;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = this.root;
        
        for(int i=0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            
            if(curr.arr[ch - 'a'] == null){
                return false;
            }
            
            curr = curr.arr[ch - 'a'];
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
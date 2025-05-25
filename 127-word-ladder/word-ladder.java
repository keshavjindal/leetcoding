class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<pair> queue = new LinkedList<>();
        queue.add(new pair(beginWord , 1));

        HashSet<String> visited = new HashSet<>();
        HashSet<String> set = new HashSet<>(wordList);
        
        while(queue.size() > 0){
            pair rem = queue.remove();
            String word = rem.s;

            if(word.equals(endWord)){
                return rem.val;
            }

            if(visited.contains(word)) continue;

            visited.add(word);
    
            for(int i=0; i<word.length(); i++){
                for(char ch='a'; ch<='z'; ch++){
                    if(ch == word.charAt(i)) continue;

                    String newword = word.substring(0 , i) + ch + word.substring(i + 1);

                    if((set.contains(newword)) && (!visited.contains(newword))){
                        queue.add(new pair(newword , rem.val + 1));
                    }
                }
            }

        }

        return 0; // not possible case
    }

    public class pair{
        String s;
        int val;

        pair(String s, int val){
            this.s = s;
            this.val = val;
        }
    }
}
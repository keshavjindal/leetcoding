class Solution {
    public int lengthOfLongestSubstring(String s) {
        // optimal - O(n)
        // using frequency map and Acquire-Release strategy

        HashMap<Character,Integer> map = new HashMap<>();
        int ans = 0;
        int n = s.length();

        int i = -1;
        int j = -1;

        while(true){
            boolean f1 = false;
            boolean f2 = false;

            // acquire
            while(i < n - 1){
                f1 = true;
                i++;
                char ch = s.charAt(i);
                map.put(ch , map.getOrDefault(ch , 0) + 1);

                if(map.get(ch) == 2){
                    break;
                }
                else{
                    ans = Math.max(ans , i - j);
                }
            }

            // release
            while(j < i){
                f2 = true;
                j++;
                char ch = s.charAt(j);
                map.put(ch , map.getOrDefault(ch , 0) - 1);

                if(map.get(ch) == 1){
                    break;
                }
            }

            if(f1 == false && f2 == false){
                break;
            }
        }

        return ans;
    }
}
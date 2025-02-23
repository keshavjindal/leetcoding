class Solution {
    public int lengthOfLongestSubstring(String s) {
        // bruteforce
        // consider all substrings in O(n^2)

        int n = s.length();
        int ans = 1;

        if(n == 0) return 0;

        for(int i=0; i<n; i++){
            HashSet<Character> set = new HashSet<>();
            for(int j=i; j<n; j++){
                char ch = s.charAt(j);
                if(!set.contains(ch)){
                    set.add(ch);
                }
                else{
                    break;
                }

                ans = Math.max(ans , set.size());
            }
        }

        return ans;
    }
}
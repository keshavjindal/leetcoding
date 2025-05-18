class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans = "";

        String firstString = strs[0]; // flower

        // ["flower","flow","flight"]

        // flower
        for(int i=0; i<firstString.length(); i++){
            // f
            char ch = firstString.charAt(i);

            for(int j=1; j<strs.length; j++){
                // olow
                String temp = strs[j];
                if(temp.length() < (i + 1)) return ans;
                if(ch != temp.charAt(i)){
                    return ans;
                }
            }

            ans += ch;
        }

        return ans;
    }
}
class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0; // s
        int j = 0; // t

        while(i < s.length() && j < t.length()){
            char one = s.charAt(i);
            char two = t.charAt(j);

            if(one == two){
                i++;
                j++;
            }
            else{
                j++;
            }
        }

        if(i == s.length()){
            return true;
        }
        else return false;
    }
}

/***

s = abc
t = hhabgdc

true

 */
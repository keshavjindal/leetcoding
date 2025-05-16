class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while(i <= j){
            char left = Character.toLowerCase(s.charAt(i));
            char right = Character.toLowerCase(s.charAt(j)); 

            if(!isAlphaNumeric(left)){
                i++;
                continue;
            }

            if(!isAlphaNumeric(right)){
                j--;
                continue;
            }

            if(left != right) return false;

            i++;
            j--;
        }

        return true;
    }

    public boolean isAlphaNumeric(char ch){
        if('a' <= ch && ch <= 'z'){
            return true;
        }
        else if('0' <= ch && ch <= '9'){
            return true;
        }
        else return false;
    }

    /**
    
    A man, a plan, a canal: Panama
    amanaplanacanalpanama




    
     */
}
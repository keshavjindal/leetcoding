class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0; // name
        int j = 0; // typed

        while(i < name.length() && j < typed.length()){
            if(name.charAt(i) == typed.charAt(j)){
                i++;
                j++;
            }
            else if(j-1>=0 && typed.charAt(j) == typed.charAt(j - 1)){
                j++;
            }
            else{
                return false;
            }
        }

        while(i < name.length()){
            if(j<typed.length() && name.charAt(i) == typed.charAt(j)){
                i++;
                j++;
            }
            else{
                return false;
            }
        }

        while(j < typed.length()){
            if(j-1>=0 && typed.charAt(j) == typed.charAt(j - 1)){
                j++;
            }
            else{
                return false;
            }
        }

        return true;
        

    }

    /**

        alexd
           i
           j
        ale
         
     */
}
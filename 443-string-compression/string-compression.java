class Solution {
    public int compress(char[] chars) {
        int update = 0;
        int ans = 0;
        
        char curr_char = chars[0];
        int len = 1;
        
        for(int i=1; i<chars.length; i++){
            char ch = chars[i];
            
            if(ch == curr_char){
                len++;
            }
            else{
                chars[update] = curr_char;
                update++;
                ans++;
                
                String len_str = Integer.toString(len);
                
                for(char dig : len_str.toCharArray()){
                    if(len_str.equals("1")) break;
                    
                    chars[update] = dig;
                    update++;
                    ans++;
                }
                
                curr_char = ch;
                len = 1;
            }
        }
        
        chars[update] = curr_char;
        update++;
        ans++;
        String len_str = Integer.toString(len);                 
        for(char dig : len_str.toCharArray()){
            if(len_str.equals("1")) break;
                    
            chars[update] = dig;
            update++;
            ans++;
        }
        
        return ans; 
    }
}
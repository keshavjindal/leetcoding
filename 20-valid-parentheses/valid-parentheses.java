class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }
            else{
                char peekOfStack = stack.size() != 0 ? stack.peek() : '-';

                if(ch == ')' && peekOfStack != '('){
                    return false;
                }

                if(ch == '}' && peekOfStack != '{'){
                    return false;
                }

                if(ch == ']' && peekOfStack != '['){
                    return false;
                }

                stack.pop();
            }
        }

        if(stack.size() != 0) return false;
        return true;
    }

    /***

        (())[][[[
        true

        |       |
        |       |
        |       |
        |       |
        |       |
        _________
    
    
    
    
     */
}
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        HashMap<Character,Character> map = new HashMap<>();
        map.put(')' , '(');
        map.put(']' , '[');
        map.put('}' , '{');

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '(' || ch == '[' || ch == '{'){
                // opening bracket -> push in stack
                stack.push(ch);
            }
            else{
                // closing bracket
                // check stack top. if invalid, return false
                // if valid. pop it and go to next character in string
                if(stack.size() != 0 && stack.peek() == map.get(ch)){
                    stack.pop();
                }
                else return false;
            }
        }   

        return stack.size() == 0;
    }
}
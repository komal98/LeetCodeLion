class Solution {
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }
    
    public String build(String b){
        
        Stack<Character> ans = new Stack();
        
        //iterating through each char
        for(char c : b.toCharArray()){
            
            //if not a backspace keystroke add to stack
            if(c != '#'){
                ans.push(c);
            }
            
            //stack not empty and also it is # then pop the char on top in the stack
            else if(!ans.empty()){
                ans.pop();
            }
            
        }
        
        return String.valueOf(ans);
    }
}
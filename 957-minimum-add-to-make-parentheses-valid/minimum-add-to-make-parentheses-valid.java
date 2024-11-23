class Solution {
    public int minAddToMakeValid(String s) {
        Set<Integer> set = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }if(s.charAt(i) == ')'){
                if(stack.isEmpty()){
                    set.add(i);
                }else{
                    stack.pop();
                }
            }
        }

        while(!stack.isEmpty()){
            set.add(stack.pop());
        }

        return set.size();
        
    }
}
/*
- need to identify unbalanced brackets
- loop through, keep set to keep track of unbalanced bracket indexes
- stack to check balance
*/
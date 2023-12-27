class Solution {
    public boolean isValid(String exp) {
         Stack<Character> stack = new Stack();

         for(char ch : exp.toCharArray()){
             switch(ch){
                 case '{':
                 case '[':
                 case '(':
                    stack.push(ch);
                    break;
                case '}':
                    if(stack.isEmpty() || '{'!=stack.pop())
                        return false;
                    break;
                case ']':
                    if(stack.isEmpty() || '['!=stack.pop())
                        return false;
                    break;
                case ')':
                    if(stack.isEmpty() || '('!=stack.pop())
                        return false;
                    break;
             }
         }
         if(!stack.isEmpty())
            return false;
        return true;
    }
}
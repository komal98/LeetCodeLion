class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
  for(int i = 0; i <s.length(); i++){
            if(!stack.isEmpty() && stack.peek()==s.charAt(i)){
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }
    StringBuilder sb=new StringBuilder();
        for(int i=0;i<stack.size();i++){
            sb.append(stack.get(i));
        }

        return sb.toString();
    }
}

/*
c a
*/
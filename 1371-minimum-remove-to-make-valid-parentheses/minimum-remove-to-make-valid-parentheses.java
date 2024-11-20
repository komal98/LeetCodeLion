class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> indexesToRemove = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            } if(s.charAt(i) == ')'){
                if(stack.isEmpty()){
                    indexesToRemove.add(i);
                }else{
                    stack.pop();
                }
            }
        }

        while(!stack.isEmpty()){
            indexesToRemove.add(stack.pop());
        }

        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            if(!indexesToRemove.contains(i)){
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();

    }


}

/*
- Every open parathesis should have a closing paranthesis
- Empty String is also valid
- Loop through the string, identify the open braces and push them into the stack
- When we encounter a close brace, check if there is an opening brace is present, if not remove that

- In the end if the stack only consists of opening brace, start from the reverse and remove opening braces in the string till stack is empty

Edge Cases:
- Can there be other charachters other than lower case characters?

*/
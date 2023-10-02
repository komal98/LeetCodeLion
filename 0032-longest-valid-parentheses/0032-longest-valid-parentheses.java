class Solution {
    public int longestValidParentheses(String s) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0, pv=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                stack.push(pv);
            }
            else if(!stack.isEmpty()){
                pv = stack.pop();
                res=  Math.max(res, i - pv +1);
                continue;
            }
            pv = i+1;
        }
        return res;
    }
}
/*
Keeping track of last valid index
- Initialize a stack of type integer
- res is the maximum valid paranthesis
- loop through the string using pointer i
- initialise another pointer pv = 0 which keeps track of the previos valid
- if an opening bracket is found store that index in the stack
- if it is a closing bracket, update result to max of res and i - pv + 1
- pv = i+1 but only in the case when closing bracket is not established

Running through an example: "(()"
i=0, pv =0
at index i = 0:
opening bracket encountered, push the index 0 onto the stack 
pv = i+1 =1;

at index i =1
i =1, pv =1
opening bracket is encountered again, push the index 1 to the stack
so 1 is on the top
pv = i+1 = 2

at index i=2
i=2, pv =2
closing bracket is encountered, Math.max(res:0, i-(pv=stack.pop())+1)
3-1
pv=1
continue without increasing pv

*/

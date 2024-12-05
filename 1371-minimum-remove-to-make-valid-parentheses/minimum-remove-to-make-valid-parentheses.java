class Solution {
    public String minRemoveToMakeValid(String s) {
        int openSeen = 0;
        int balance = 0;

        StringBuilder sb = new StringBuilder("");

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                openSeen++;
                balance++;
            }if(s.charAt(i) == ')'){
                if(balance == 0) continue;
                balance --;
            }

            sb.append(s.charAt(i));
        }

        StringBuilder result = new StringBuilder();
        int openToKeep = openSeen - balance;
        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) == '('){
                openToKeep --;
                if(openToKeep < 0) continue;
            }

            result.append(sb.charAt(i));
        }

        return result.toString();

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
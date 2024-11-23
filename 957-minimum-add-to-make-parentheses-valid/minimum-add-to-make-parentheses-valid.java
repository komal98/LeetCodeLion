class Solution {
    public int minAddToMakeValid(String s) {
        int openBrackets = 0;
        int minAddsRequired = 0;

        for(char c : s.toCharArray()){
            if(c == '('){
                openBrackets++;
            }else{
                if(openBrackets > 0){
                    openBrackets--;
                }else{
                    minAddsRequired++;
                }
            }
        }

        return openBrackets + minAddsRequired;
    }
}
/*
- keep two trackers
- one to keep track of open brackets
- one if open brackets are zero will keep track of minAddsRequired
*/
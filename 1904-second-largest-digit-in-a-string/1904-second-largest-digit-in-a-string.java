class Solution {
    public int secondHighest(String s) {
        int max = -1;
        int secondMax = -1;

        char[] characters = s.toCharArray();

        for(int i = 0; i < characters.length; i++){
            if(characters[i]>='0' && characters[i]<='9'){
                int val = characters[i]-'0';
                if(val>max){
                    secondMax = max;
                    max = val;
                }
                else if(val>secondMax && val!=max){
                    secondMax = val;
                }
            }
        }
        if(secondMax == max){
            return -1;
        }
        return secondMax;
        
    }
}
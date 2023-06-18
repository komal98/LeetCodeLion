class Solution {
    public int secondHighest(String s) {
        int max = -1;
        int secondMax = -1;

        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                if(Character.getNumericValue(s.charAt(i))>max){
                    secondMax = max;
                    max = Character.getNumericValue(s.charAt(i));
                }
                else if(Character.getNumericValue(s.charAt(i))>secondMax && 
                Character.getNumericValue(s.charAt(i))!=max){
                    secondMax = Character.getNumericValue(s.charAt(i));
                }
            }
        }
        if(secondMax == max){
            return -1;
        }
        return secondMax;
        
    }
}
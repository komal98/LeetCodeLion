class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        //maxLength that we have to return
        int maxLength = 0;

        //loop through each char in the string to check its substrings
        for(int right = 0, left = 0; right < s.length(); right++){
            int indexOfFirstApperanceInSubString = s.indexOf(s.charAt(right),left);
            if(indexOfFirstApperanceInSubString != right){
                left = indexOfFirstApperanceInSubString + 1;
            }
            maxLength = Math.max(maxLength, (right-left)+1);

        }
        
        return maxLength;
    }
}
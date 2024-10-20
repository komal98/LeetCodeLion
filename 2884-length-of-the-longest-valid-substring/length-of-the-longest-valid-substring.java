class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        int maxLength = 0;
        
        // If we find a forbidden word in a given window, the max bound of characters we look for should be shrinked. 
        //This pointer keeps track of that boundary.
        int maxRight = word.length() - 1;
        
        // .contains operation on a Set takes O(1) complexity vs a List
        Set<String> forbiddenSet = new HashSet<>();
        for(String fbWord: forbidden) forbiddenSet.add(fbWord);

        for(int left = word.length() - 1; left >= 0; left--) {
            //To avoid TLE, make use of the constraint that a given forbidden word can be a maximum of 10 chars. 
            //So, just iterate to a max of 10 chars of maxRight is more than 10
            for(int right = left; right <= Math.min(left +10, maxRight); right++) {
                if(forbiddenSet.contains(word.substring(left, right + 1))) {
                    //Since forbidden word is a part of the current window, shrink the size of max window size
                    maxRight = right - 1;
                    break;
                }
            }
            maxLength = Math.max(maxLength, maxRight - left + 1);
        }
        return maxLength;
    }
}
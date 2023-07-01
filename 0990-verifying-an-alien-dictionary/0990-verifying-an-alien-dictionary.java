class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] pos = new int[order.length()];
        //store rank in an array
        for(int i = 0; i < order.length(); i++){
            pos[order.charAt(i) - 'a'] = i;
        }

        //loop through array of words
        for(int i = 1; i < words.length; i++){
            //we have to compare the strings loop through smaller length
            String prev = words[i-1], curr = words[i];
            int len = Math.min(prev.length(), curr.length());
            int countEqual = 0;

            //loop through smaller length
            for(int j = 0; j<len; j++){
                char p = prev.charAt(j), c=curr.charAt(j);

                //if the char at prev is greater then unsorted
                if(pos[p-'a'] > pos[c-'a']) return false;

                //keeping track of equal encountered because if all equal 
                //and prev length is greater then unsorted
                else if(pos[p-'a'] == pos[c-'a']) countEqual++;

                //if the previous is smaller then it is sorted
                else break;
            }
            if(countEqual == len && prev.length() > curr.length()) return false;
        }

        return true;
    }

}
/*
The question is a bit skewed. The words are written in alien language. The order of the alphabet. So in normal english we have abcdef.... similarly this order is given for the alien langauge. We have to detrmine if the words given are lexicographically arranged according to the alien sequence.

So basically we are doing string compare between the strings in the words based on the new order that we have been given.
*/
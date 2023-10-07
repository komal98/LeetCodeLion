class Solution {
    public int strStr(String haystack, String needle) {
       int nl = needle.length();
       int hl = haystack.length();
       if(nl==hl){
           if(haystack.equals(needle))
            {
                return 0;
            }
            return -1;
       }
       if(nl > hl){
           return -1;
       }
       int i= 0, j = i+nl;
       while(j<=haystack.length()){
           if(needle.equals(haystack.substring(i,j))){
               return i;
           }
           i++;
           j++;
       }
       return -1;
      
    }
}
class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String smallest = strs[0];
        String largest = strs[strs.length -1];
        
        int count = 0;

        while(count < smallest.length() && count < largest.length()){
            if(smallest.charAt(count) == largest.charAt(count)){
                count++;
            }
            else{
                break;
            }
        }
        return smallest.substring(0,count);
    }
}
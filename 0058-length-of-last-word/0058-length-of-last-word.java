class Solution {
    public int lengthOfLastWord(String s) {
      String words[] = s.split(" ");
      int size = words.length-1;  
      return words[size].length();
    }
}
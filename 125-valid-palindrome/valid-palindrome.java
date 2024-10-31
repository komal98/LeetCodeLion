class Solution {
    public boolean isPalindrome(String s) {
        String sL = s.toLowerCase().replaceAll("[^A-Za-z0-9]", "");
        int i = 0;
        int j = sL.length() - 1;

        while (i < j) {  
            if (sL.charAt(i) != sL.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}

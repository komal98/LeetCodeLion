class Solution {
    public boolean makePalindrome(String s) {
        int count = 0;
        int left = 0;
        int right = s.length()-1;

        while(left<right){
            if(count>2)return false;
            if(s.charAt(left)!=s.charAt(right))count+=1;
            left++;
            right--;
        }

        if(count>2)return false;

        return true;
    }
}
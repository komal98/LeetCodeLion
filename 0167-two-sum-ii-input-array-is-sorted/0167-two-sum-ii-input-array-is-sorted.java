class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        int[] ans = new int[2];

        while(left<numbers.length-1 && right>0){
            int sum = numbers[left] + numbers[right];
            if( sum == target) {
                ans[0] = left + 1;
                ans[1] = right + 1;
                return ans;
            }
            else if(sum > target){
                right--;
            }
            else if(sum <target){
                left++;
            }
        }
        return ans;
    }
}
class Solution {
    public int missingNumber(int[] nums) {
        int expectedSum = nums.length*(nums.length+1)/2;
        int actualSum = 0;
        for(int i = 0; i < nums.length; i++){
            actualSum += nums[i];
        }

        return expectedSum - actualSum;
    }
}
/*
O(n log n) -> sort and then check each value matches index or not
O(n) -> sum formula

*/
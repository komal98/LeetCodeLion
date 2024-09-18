class Solution {
    public int minimumSwaps(int[] nums) {
        int min = 0;
        int max = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]>=nums[max]) max = i;
            if(nums[i]<nums[min]) min = i;
        }
        if(max < min) return (nums.length - 1 - max) + (min - 1);
        else return  (nums.length - 1 - max) + min;
    }
}
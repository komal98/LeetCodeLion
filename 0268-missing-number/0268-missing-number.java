class Solution {
    public int missingNumber(int[] nums) {
        int[] trace = new int[nums.length + 1 ];
        for(int i = 0; i<nums.length; i++){
            trace[i] = 1;
        }

        for(int i = 0; i<nums.length; i++){
            trace[nums[i]] = 0;
        }

        for(int i = 0; i<trace.length; i++){
            if(trace[i] == 1) return i;
        }

        return nums.length;
    }
}
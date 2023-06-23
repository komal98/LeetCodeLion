class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        //if there exists 0 0 in the contiguous subarray return true
        for(int i = 1; i< nums.length; i++){
            if(nums[i] == 0 && nums[i-1] == 0) return true;
        }
        //add the sums starting from 1
        for(int i = 1; i<nums.length; i++){
            nums[i] = nums[i] + nums[i-1];
            if(nums[i] % k == 0) return true;
            //run j from i till 0 to check sums without each preceding element
            //until 2 elements left
            int j = i;
            while(j>1 && nums[i]>k){
                if((nums[i] - nums[j-2]) % k == 0){
                    return true;
                }
                j--;
            }
        }
        return false;
        }
    }
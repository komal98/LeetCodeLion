class Solution {
    public int minSubArrayLen(int target, int[] nums) {
     int start = 0;
     int sum = 0;
     int res = Integer.MAX_VALUE;
     for(int end = 0; end < nums.length; end++){
            sum = sum + nums[end];
            while(sum >= target){
                res = Math.min(end - start +1, res);
                sum = sum - nums[start];
                start++;
            }
            
     }  
     if( res == Integer.MAX_VALUE) return 0;
     return res;  
    }
}
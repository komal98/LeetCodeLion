class Solution {
    public boolean canJump(int[] nums) {
     
        int reach = 0;
        
        //at every step calculate the reachability and keep updating it till we reach end 
        
        for(int i = 0; i < nums.length; ++i){
            
            if(reach < i)
                return false;
            
            reach = Math.max(reach, i + nums[i]);
            
            if(reach == nums.length)
                return true;
        }
        
        return true;
        
    }
}
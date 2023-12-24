class Solution {
    public void rotate(int[] nums, int k) {
        int[] ans = new int[nums.length];
        for(int i= 0; i<nums.length; i++){
            int pos = i+k;
            if(pos<nums.length){
                ans[pos] = nums[i];
            }else{
                pos = pos%nums.length;
                ans[pos] = nums[i];
            }
        }
        for(int i = 0; i<nums.length; i++){
            nums[i] = ans[i];
        }
    }
}
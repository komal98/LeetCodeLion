class Solution {
    public void moveZeroes(int[] nums) {
        int countZero = 0;
        int j = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                countZero++;//counting the number of zeros
            }else{
                nums[j++] = nums[i]; //if it is zero then add in count else place it there in the order
            }
        }

        for(int i =0; i<countZero; i++){
            nums[j++] =0;
        }
    
    }
}
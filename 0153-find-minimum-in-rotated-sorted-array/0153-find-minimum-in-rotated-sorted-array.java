class Solution {
    public int findMin(int[] nums) {
        //O(n) case is parsing the array and finding the finding the findMin
        //O(logN) would need Binary Seacrh

        //edge cases
        //If only one element is there, if the first element is smaller than the last element then it is sorted array
        int n = nums.length;
        if(n == 1 || nums[0] < nums[n-1]){
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right-left)/2;

            //Inflection point when to the left is bigger or the number to the right is smaller
            //left is bigger then mid is the smallest
            //right is smaller then right is the smallest

            if(nums[mid+1]< nums[mid]){
              return nums[mid+1];
            }
            else if(nums[mid - 1] > nums[mid]){
                return nums[mid];
            }

            int leftNum = nums[left];
            //applying binary Seacrh
            //if middle number is greater than left number
            if(nums[mid] > leftNum)
            {
                left = mid + 1;
            } 
            else{
                right = mid - 1;
            }

        }
return 0;
        
    }
}
class Solution {
    public int search(int[] nums, int target) {
        if(nums==null || nums.length == 0){
            return -1;
        }
        //find pivot
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int midpoint = left + (right-left)/2;
            if(nums[midpoint] > nums[right]){
                left = midpoint + 1;
            }else{
                right = midpoint;
            }
        }
//left is our pivot
int start = left;
left = 0;
right = nums.length - 1;

//now we have to check if the target is on the left side of pivot or right
if(target >= nums[start] && target <=nums[right]){
    left = start;
}else{
    right = start;
}

//performing simple binary search now
while(left<=right){
    int midpoint = left + (right -left)/2;
    if(nums[midpoint] == target){
        return midpoint;
    }
    else if(nums[midpoint] < target){
        left = midpoint + 1;
    }else{
        right = midpoint - 1;
 
    }
}
return -1;
    }
}

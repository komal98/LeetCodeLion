class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        for(int i = 0, j= 0; j < n; i++){
            if(i %2 == 0){
                ans[i] = nums[j];
            }else{
                ans[i] = nums[j+n];
                j++;
            }
        }
        return ans;
        }
    }

//[0 1 2 3 4 5]
//[2 5 1 3 4 7]
//[2 3 5 4 1 7]
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k==0) return 0;
        int n = nums.length;
        int count = 0;
        for(int i = 0; i< n; i++){
            int prod = 1;
            for(int j = i; j< n; j++){
                 prod=prod*nums[j];
                 if(prod<k) count++;
                 else
                 break;
            }
        }
        return count;
    }
}
/*
[10,5,2,6]
{10}
{10,5}
{10,5,2}
{10,5,2,6}

{5}
{5,2}
{5,2,6}

{2}
{2,6}

{6}
*/
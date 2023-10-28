class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k <= 1) return 0;
        int left = 0, right = 0, count = 0, product = 1;
        while (right < nums.length) {
            product *= nums[right];
            while (product >= k) product /= nums[left++];
            count += 1 + (right - left);
            right++;
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
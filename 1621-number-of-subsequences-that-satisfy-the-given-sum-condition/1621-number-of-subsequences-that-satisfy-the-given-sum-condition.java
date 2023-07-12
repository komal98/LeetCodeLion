class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0, n = nums.length, l = 0, r =n -1, mod = (int)1e9 +7, pow[] = new int[n];
        pow[0] = 1;
       for(int i = 1; i<n; ++i) pow[i] = pow[i-1] * 2 % mod;
        while(l <=r){
            if(nums[l] + nums[r] > target) r--;
            else ans = (ans + pow[r - l++])% mod;
        }
        return ans;
    }
}
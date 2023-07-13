class Solution {
  public int numSubseq(int[] nums, int target) {
    var n = nums.length;
    //sort so that easier to track smallest and largest
    Arrays.sort(nums);

    var exp = new int[n];
    exp[0] = 1;

    for (var i=1; i<n; i++)
      exp[i] = (exp[i-1] * 2) % 1000000007;

    int i = 0, j = n-1, cnt = 0;

    while (i <= j) {
      if (nums[i] + nums[j] <= target) {
        cnt = (cnt + exp[j-i]) % 1000000007;
        i++;
      } else {
        j--;
      }
    }
    return cnt;
  }
}

/*
[3,5,6,7]
[0,1,2,3,4,5]
[1,2,4,8,16,32]
*/
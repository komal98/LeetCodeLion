class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length; 
        int res[] = new int[n]; // the result array with the largest non-decreasing length of subsequences, ending at i and including nums[i]
        int dp[] = new int[n+1]; // between two subsequences with same length previously we will prefer the one smaller length
        int len = 0;

        Arrays.fill(dp,Integer.MAX_VALUE);

        for(int i =0; i<n; i++){
           int newLen = bs(1, len, obstacles[i], dp, obstacles);
           res[i] = newLen;
           len = Math.max(len, newLen);
           dp[newLen] = i;
        }

        return res;
    }

        public int bs(int low, int high, int target, int[] indices, int[] obstacles){
        if(low > high){
            return low;
        }
        int mid = low + (high - low) / 2;
        if(obstacles[indices[mid]] > target){
            return bs(low, mid - 1, target, indices, obstacles);
        }else{
            return bs(mid + 1, high, target, indices, obstacles);
        }
    }
}
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int MOD = 1000000007;

        Stack<Integer> stack = new Stack<>();

        //make a dp array of the same size as the input array arr
        int[] dp = new int[arr.length];

        //making a monotonic increasing stack
        for(int i = 0; i<arr.length; i++){

            while(!stack.empty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }

            if(stack.size()>0){
                int prevSmall = stack.peek();
                dp[i] = dp[prevSmall] + (i - prevSmall) *arr[i];
            }else{
                dp[i] = (i+1)*arr[i];
            }

            stack.push(i);
        }

        long sumOfMinimums = 0;
        for(int count : dp){
            sumOfMinimums +=count;
            sumOfMinimums %= MOD;
        }

        return (int) sumOfMinimums;
        
    }
}
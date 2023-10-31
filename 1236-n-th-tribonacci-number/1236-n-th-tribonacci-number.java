class Solution {
    public int tribonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 1;

        int[] Tsum = new int[n+1];
        Tsum[0] = 0;
        Tsum[1] = 1;
        Tsum[2] = 1;

        for(int i = 3; i<=n; i++){
            Tsum[i] = Tsum[i-1] +Tsum[i-2] +Tsum[i-3];
        }

        return Tsum[n];
    }
}
class Solution {
    public int countOrders(int n) {
        int slots = 2 * n;
        int MOD = 1000000007;
        long required = 1;

        while (slots > 0) {
            int valid = slots * (slots - 1) / 2;
            required = (required * valid) % MOD; 
            slots -= 2;
        }

        return (int) required;
    }
}
/*
This is a permutation and combination question where we have to 
place 2n orders where pcikup has to be before delivery.

There are 2n slots.

*/
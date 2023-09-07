class Solution {
    public int getSum(int a, int b) {
    //    int ans = Integer.sum(a,b);
    //    return ans;
    int carry=0;
    while (b != 0){
    carry = (a & b) << 1;
    a = a ^ b;
    b = carry;
    }
    return a;
    }
}

class Solution {
    public int trap(int[] height) {
        if(height.length == 0) return 0;

        int l = 0, r = height.length - 1;
        int maxLeft = height[l], maxRight = height[r];
        int res = 0;

        while(l<r){
            if(maxLeft < maxRight){
                l++;
                maxLeft = Math.max(maxLeft, height[l]);
                res = res + (maxLeft - height[l]);
            }else{
                r--;
                maxRight = Math.max(maxRight, height[r]);
                res = res + (maxRight - height[r]);
            }
        }
        return res;
    }
}
/*
we have o use two pointers
maximum height of walls to the left and right of each element.
amount of water that can be trapped at each element is equal to the minimum of 

min(L,R) - h[i]
*/
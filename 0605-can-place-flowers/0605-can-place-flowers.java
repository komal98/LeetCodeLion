class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m = flowerbed.length;
        //we can place more than half the flowerbed + 1
        if(n > m/2 + 1) return false;
        
        int i = 0;
        while(n > 0 && i < m){
            if(i + 1 < m && flowerbed[i+1] == 1){
                i++;
            }else if(flowerbed[i] == 0){
                n--;
            }
            i = i+2;
        }

        return n == 0;
    }
}
class Solution {
    public int[] replaceElements(int[] arr) {
       //traverse from right to left, keep track of max
       for(int i = arr.length -1, max = -1; i>=0; --i){
           max = Math.max(arr[i], arr[i] = max);
       }
       return arr;
    }
}
class Solution {
    public int[] replaceElements(int[] arr) {
       //traverse from right to left, keep track of max
       int max = -1;
       for(int i = arr.length -1; i>=0; --i){
           int temp = arr[i];
           arr[i] = max;
           max = Math.max(arr[i], temp);
       }
       return arr;
    }
}
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int max = -1;
        int index =-1;
        for(int i = 0; i<arr.length; i++){
            if(i!=0 && i!=arr.length -1 && max<arr[i]){
                index = i;
                max = arr[i];
            }
        }
        return index;
    }
}
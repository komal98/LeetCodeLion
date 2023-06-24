class Solution {
    public int subarraySum(int[] nums, int k) {
        //using hashmap to store sum and the corressponding count of that sum
       HashMap<Integer, Integer> map = new HashMap<>();
       // intiliazing map with sum 0 as count 1
       map.put(0,1);
       int sum = 0;
       int count = 0;
       //looping through the array
       for(int i = 0; i < nums.length; i++){
           //finding sum of the subarrays
           sum = sum + nums[i];
           //if the compliment sum exists means that there is a sub array 
           // with the sum k
           if(map.containsKey(sum - k)){
               count +=map.get(sum - k);
           }
           //if sum is not in the map initialize the array with the sum,0 and add 
           //the count
           map.put(sum, map.getOrDefault(sum,0)+1);
       }
       return count;
    }
}
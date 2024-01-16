class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> el = new HashSet<Integer>();
        
        // add all elements in a set
        for(int i = 0; i<nums.length; i++){
            el.add(nums[i]);
        }
        
        int countMax = 0;
        
        for(int i = 0; i<nums.length; i++){
            int count = 1, prev = nums[i]-1, next = nums[i] + 1;
           while(el.contains(prev)){
               count++;
               el.remove(prev);
               prev--;
           }
            while(el.contains(next)){
                count++;
                el.remove(next);
                next++;
            }
            countMax = Math.max(count, countMax);
        }
        
        return countMax;
    }
}
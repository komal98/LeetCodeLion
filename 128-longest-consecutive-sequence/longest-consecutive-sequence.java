class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs1 = new HashSet<Integer>();
        for(int num:nums)
        {
            hs1.add(num);
        }
        int longestStreak = 0;
        for(int num1 : nums)
        {
            if(!hs1.contains(num1-1))//identify the smallest
            {
                int currentStreak = 1;
                int currentNum = num1;
                while(hs1.contains(currentNum+1))
                {
                    currentStreak = currentStreak + 1;
                    currentNum = currentNum + 1;
                }
                longestStreak = Math.max(longestStreak,currentStreak);
            }
        }
        return longestStreak;
        
    }
}
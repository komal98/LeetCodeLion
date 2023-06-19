class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int below = 0;
        int count = 0;
        for (int num : nums) {
            if (num < target) below++;
            else if (num == target) count++;
        }
        
        List<Integer> indices = new ArrayList<>(count);
        while(count > 0) {
            indices.add(below++);
            count--;
        }
        return indices;
    }
}
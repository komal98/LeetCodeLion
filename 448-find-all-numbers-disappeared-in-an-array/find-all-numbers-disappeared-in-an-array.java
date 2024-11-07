class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int[] trace = new int[nums.length+1];

        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= nums.length)
                trace[nums[i]] = 1;
        }

        for(int i = 1; i <=nums.length; i++){
            if(trace[i] == 0){
                ans.add(i);
            }
        }

        return ans;
    }
}
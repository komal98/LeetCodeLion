class Solution {
    public int minOperations(List<Integer> nums, int k) {
        int cnt=0;
        Set<Integer> set = new HashSet<>();

        for(int i=nums.size()-1; i>=0; i--){
            cnt++;
// Count until the list value is less than or equal to "k"            
            if(nums.get(i) <= k){
                set.add(nums.get(i));
            }

// if set length equals to "k" then break and print the result(cnt)
            if(set.size() == k) break;
        }
        return cnt;
    }
}
class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList();
        int i = 0;
        
        for (int num : target) {
            while (i < num - 1) {
                ans.add("Push");
                ans.add("Pop");
                i++;
            }
            
            ans.add("Push");
            i++;
        }
        
        return ans;
    }
}
/*
[1,3] n = 3
 1 2 3


 3
 [1,0,3]
[1,2]
 push, push, pop, push
 if something is there just push
 if something is not there push pop
 stop when end of either of arrays is reached
*/
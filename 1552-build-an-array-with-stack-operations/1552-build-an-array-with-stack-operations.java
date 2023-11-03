class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ops = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        
        int l = target[target.length-1];
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i<target.length; i++){
            set.add(target[i]);
        }
        for(int i = 1; i<=l; i++){
            if(set.contains(i)){
                track.add(i);
            }else{
                track.add(0);
            }
        }

        for(int i =0; i<track.size(); i++){
            if(track.get(i)!=0){
                ops.add("Push");
            }
            else{
                ops.add("Push");
                ops.add("Pop");
            }
        }

        return ops;
        
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
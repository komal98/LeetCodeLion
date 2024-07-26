class Solution {
    public int similarPairs(String[] words) {
        HashMap<String,Integer> map = new HashMap();
        for(String str: words){
            Set<Character> set = new HashSet();
            for(int i=0; i<str.length(); i++){
                char ch = str.charAt(i);
                set.add(ch);
            }
            String s = set.toString();
            map.putIfAbsent(s,0);
            map.put(s,map.get(s)+1);
        }
        int ans = 0;
        for(String s: map.keySet()){
            int items = map.get(s);
            ans += (items*(items-1))/2;
        }
       return ans; 
    }
}
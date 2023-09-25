class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        HashMap<Character,Integer> map = new HashMap<>();
        int n = word1.length();

        for(int i = 0; i<n; i++){
            map.put(word1.charAt(i), map.getOrDefault(word1.charAt(i),0)+1);
            map.put(word2.charAt(i), map.getOrDefault(word2.charAt(i),0)-1);
        }

        for(int i : map.values()){
            if(i > 3 || i < -3){
                return false;
            }
        }
        return true;
    }
}
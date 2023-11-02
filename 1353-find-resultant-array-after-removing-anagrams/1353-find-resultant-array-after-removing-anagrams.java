class Solution {
    public List<String> removeAnagrams(String[] words) {
        int n = words.length;
        //int i = 1;
        List<String> ans = new ArrayList<>();
        for(int j =0; j<n; j++){
            ans.add(words[j]);
        }
        for(int i = 1; i<n; i++){
            if(sort(words[i-1]).equals(sort(words[i]))){
                ans.remove(words[i]);
                //System.out.println(words[i]);
            }
        }
        return ans;
    }

    private String sort(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        return sorted;
    }
}
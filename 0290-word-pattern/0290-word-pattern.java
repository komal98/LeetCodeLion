class Solution {
    public boolean wordPattern(String pattern, String s) {
       HashMap<Character, String> sMap = new HashMap<>();
       HashMap<String, Character> pMap = new HashMap<>();

       String[] words = s.split(" ");
       if(words.length != pattern.length()) return false;
       for(int i = 0; i<pattern.length(); i++){
           char ch = pattern.charAt(i);

           if(sMap.containsKey(ch)){
               if(!sMap.get(ch).equals(words[i]))
                    return false;
           }
           sMap.put(ch, words[i]);

           if(pMap.containsKey(words[i])){
               if(!pMap.get(words[i]).equals(ch))
                    return false;
           }
           pMap.put(words[i],ch);
       }
        return true;
    }
}
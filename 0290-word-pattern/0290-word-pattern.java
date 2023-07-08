class Solution {
   public boolean wordPattern(String pattern, String s) {
        List<String> list = List.of(s.split(" "));
        Map<Character, String> map = new HashMap<>();
        if (pattern.length() != list.size()) {
            return false;
        }
        return (extracted(pattern, list, map));
    }
    private static boolean extracted(String pattern, List<String> list, Map<Character, String> map) {
        for (int i = 0; i < pattern.length(); i++) {
             if (!map.containsKey(pattern.charAt(i))) {
                if(map.containsValue(list.get(i))) return false;
                map.put(pattern.charAt(i), list.get(i));
            } else if (map.containsKey(pattern.charAt(i))
                    && !map.get(pattern.charAt(i)).equals(list.get(i))) {
               return false;
            }
        }
        return true;
    }

}
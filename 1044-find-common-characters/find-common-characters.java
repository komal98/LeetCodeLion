class Solution {
    public List<String> commonChars(String[] words) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : words[0].toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);

        for (int i = 1; i < words.length; i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : words[i].toCharArray())
                map.put(c, map.getOrDefault(c, 0) + 1);

            Map<Character, Integer> newFreq = new HashMap<>();
            for (char c : freq.keySet())
                if (map.containsKey(c))
                    newFreq.put(c, Math.min(freq.get(c), map.get(c)));
            freq = newFreq;
        }

        List<String> res = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            char v = entry.getKey();
            int count = entry.getValue();
            for (int j = 0; j < count; j++)
                res.add(String.valueOf(v));
        }
        return res;
    }
}
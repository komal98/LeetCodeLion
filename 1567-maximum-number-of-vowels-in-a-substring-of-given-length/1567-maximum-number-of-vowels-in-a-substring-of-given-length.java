class Solution {
    public int maxVowels(String s, int k) {
    Set<Character> vowvels = new HashSet<>();
    vowvels.add('a');
    vowvels.add('e');
    vowvels.add('i');
    vowvels.add('o');
    vowvels.add('u');
    int maxCount = 0, currCount = 0;
    for(int i = 0; i < k; i++){
        if(vowvels.contains(s.charAt(i))) currCount++;
    }

    maxCount = currCount;

    for(int i = k; i < s.length(); i++){
        if(vowvels.contains(s.charAt(i-k))) currCount--;
        if(vowvels.contains(s.charAt(i))) currCount++;
        maxCount = Math.max(maxCount, currCount);
    }
     return maxCount;
    }
}

//extract all substrings of length k
//check how many vowvels are in them
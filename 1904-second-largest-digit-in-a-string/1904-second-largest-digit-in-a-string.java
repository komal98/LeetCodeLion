class Solution {
    public int secondHighest(String s) {
       TreeSet<Integer> set = new TreeSet<>();

        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                set.add(Character.getNumericValue(s.charAt(i)));  
            }
        }
        if(set.size()== 0 || set.size() == 1){
            return -1;
        }
        set.pollLast();
        return set.last();
    }
}
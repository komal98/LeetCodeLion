class Solution {

    class Trie{
        boolean isword;
        HashMap<Character, Trie> child;

        Trie(){
            isword = false;
            child = new HashMap<>();
        }
    }

    Trie root = new Trie();

    public boolean wordBreak(String s, List<String> wordDict) {
        root = new Trie();

        for(String it : wordDict){
            Trie node = root;

            for(char ele : it.toCharArray()){
                if(!node.child.containsKey(ele)){
                    node.child.put(ele, new Trie());
                }

                node = node.child.get(ele);
            }

            node.isword = true;
        }
        boolean[] dp = new boolean[s.length()];

        for(int i = 0;i < s.length();i++){
            if(i == 0|| dp[i-1]){
                Trie node = root;
                for(int j = i;j < s.length();j++){
                    char ele = s.charAt(j);

                    if(!node.child.containsKey(ele)){
                        break;
                    }

                    node = node.child.get(ele);
                    if(node.isword){
                        dp[j] = true;
                    }
                }
            }
        }

        return dp[s.length()-1];

    }
}
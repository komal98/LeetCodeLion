class TrieNode{
    private final Map<Character,TrieNode> children = new HashMap<Character,TrieNode>();
    private boolean endOfWord;

    Map<Character,TrieNode> getChildren(){
        return children;
    }

    boolean isEndOfWord(){
        return endOfWord;
    }

    void setEndOfWord(boolean value){
        endOfWord = value;
    }

}
class Trie {
     private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode current = root;
        for(char l : word.toCharArray()){
            current = current.getChildren().computeIfAbsent(l, c->new TrieNode());
        }
        current.setEndOfWord(true);
    }
    
    public boolean search(String word) {
        TrieNode current = root;
        for(int i = 0; i<word.length(); i++){
            char ch = word.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if(node == null){
                return false;
            }
            current = node;
        }
        return current.isEndOfWord();
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(int i = 0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if(node == null){
                return false;
            }
            current = node;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
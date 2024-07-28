class Node {
    public int key;
    public int val;
    public Node next;
    public Node prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        next = null;
        prev = null;
    }
}

class LRUCache {
    Map<Integer, Node> lru;
    private Node head;
    private Node tail;
    private int capacity;

    public LRUCache(int capacity) {
       
       this.capacity = capacity;
       lru = new HashMap<>();
       head = new Node(-1,-1);
       tail = new Node(-1,1);
       head.next = tail;
       tail.prev = head;
    }

    private void deleteNode(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void addNode(Node newNode){
        Node temp = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next = temp;
        temp.prev = newNode;
    }
    
    public int get(int key) {
        if(!lru.containsKey(key)) return -1;

        Node node = lru.get(key);
        deleteNode(node);
        addNode(node);
        lru.put(key,head.next);
        return head.next.val;
    }
    
    public void put(int key, int value) {
       if(lru.containsKey(key)){
           Node node = lru.get(key);
           deleteNode(node);
           node.val = value;
           addNode(node);
           lru.put(key,head.next);
       }else if(lru.size() == capacity){
           Node prev = tail.prev;
           deleteNode(prev);
           lru.remove(prev.key);
           Node newNode = new Node(key,value);
           addNode(newNode);
           lru.put(key,head.next);
       } else{
           Node newNode = new Node(key,value);
           addNode(newNode);
           lru.put(key,head.next);
       }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
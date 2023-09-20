class OrderedStream {
    private String[] stream;
    private int ptr;

    public OrderedStream(int n) {
        stream = new String[n];
        ptr = 0;
    }
    
    public List<String> insert(int idKey, String value) {
        stream[idKey-1] = value;
        List<String> chunk = new ArrayList<>();
        while(ptr < stream.length && stream[ptr]!=null){
            chunk.add(stream[ptr]);
            ptr++;
        }
        return chunk;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
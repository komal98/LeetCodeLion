class MyStack {
    Queue<Integer> q;
    
    public MyStack() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
        q.add(x);
        int size = q.size();
        for(int i =0; i<size-1; i++){
            q.add(q.peek());
            q.remove();
        }
    }
    
    public int pop() {
        return q.remove();
        
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        if(q.isEmpty()) return true;
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

 //queue is first in first out, stack is last in first out
 //so if i push an element in a queue, it is going to come out as 
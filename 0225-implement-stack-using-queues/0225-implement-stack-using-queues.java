class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        if(q1.isEmpty()) q1.add(x);
        else{
            while(!q1.isEmpty()){
                q2.add(q1.peek());
                q1.remove();
            }
            q1.add(x);
            while(!q2.isEmpty()){
                q1.add(q2.peek());
                q2.remove();
            }
        }
    }
    
    public int pop() {
        return q1.remove();
        
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        if(q1.isEmpty()) return true;
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
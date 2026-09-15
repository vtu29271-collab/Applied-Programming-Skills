class MinStack {
    private Stack<Integer>mainStack;
    private Stack<Integer>minStack;
    public MinStack() {
        mainStack=new Stack<>();
        minStack=new Stack<>();
    }
    
    public void push(int value) {
        mainStack.push(value);
        if(minStack.isEmpty()||value<=minStack.peek()){
            minStack.push(value);
        }else{
            minStack.push(minStack.peek());
        }
    }
    
    public void pop() {
        mainStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
/*

155. Min Stack
Easy

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.

 

Example:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.

Link : https://leetcode.com/problems/min-stack/

*/

class MinStack {

    /** initialize your data structure here. */
    Stack<int[]> s;
    public MinStack() {
        this.s = new Stack<>();
    }
    
    public void push(int x) {
        if(s.isEmpty()) s.push(new int[]{x, x});
        else{
            if(x <= s.peek()[1]) s.push(new int[]{x, x});
            else s.push(new int[]{x, s.peek()[1]});
        }
    }
    
    public void pop() {
        s.pop();
    }
    
    public int top() {
        return s.isEmpty() ? -1 : s.peek()[0];
    }
    
    public int getMin() {
        return s.isEmpty() ? -1 : s.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

// Using LinkedList
class MinStack {

    /** initialize your data structure here. */
    LinkedList<Integer> stack;
    public MinStack() {
        this.stack = new LinkedList<>();
    }
    
    public void push(int x) {
        this.stack.addFirst(x);
        
    }
    
    public void pop() {
        this.stack.remove(0);
    }
    
    public int top() {
        return stack.peekFirst();
        
    }
    
    public int getMin() {
        int MIN = Integer.MAX_VALUE;
        for (int min : stack) {
            if(min<MIN)
                MIN=min;
        }
        return MIN;
        
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

// Using 2 stacks

class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }
    
    public void push(int x) {
        if(this.minStack.isEmpty() || x <= this.minStack.peek() )
            this.minStack.push(x);
        this.stack.push(x);
        
    }
    
    public void pop() {
        if(this.stack.peek().equals(this.minStack.peek())){
            this.minStack.pop();
        }
        this.stack.pop();
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return this.minStack.peek();   
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

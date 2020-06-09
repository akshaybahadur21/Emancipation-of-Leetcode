/*

895. Maximum Frequency Stack
Hard

Implement FreqStack, a class which simulates the operation of a stack-like data structure.

FreqStack has two functions:

    push(int x), which pushes an integer x onto the stack.
    pop(), which removes and returns the most frequent element in the stack.
        If there is a tie for most frequent element, the element closest to the top of the stack is removed and returned.
 

Example 1:

Input: 
["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
[[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
Output: [null,null,null,null,null,null,null,5,7,5,4]
Explanation:
After making six .push operations, the stack is [5,7,5,7,4,5] from bottom to top.  Then:

pop() -> returns 5, as 5 is the most frequent.
The stack becomes [5,7,5,7,4].

pop() -> returns 7, as 5 and 7 is the most frequent, but 7 is closest to the top.
The stack becomes [5,7,5,4].

pop() -> returns 5.
The stack becomes [5,7,4].

pop() -> returns 4.
The stack becomes [5,7].

Note:

    Calls to FreqStack.push(int x) will be such that 0 <= x <= 10^9.
    It is guaranteed that FreqStack.pop() won't be called if the stack has zero elements.
    The total number of FreqStack.push calls will not exceed 10000 in a single test case.
    The total number of FreqStack.pop calls will not exceed 10000 in a single test case.
    The total number of FreqStack.push and FreqStack.pop calls will not exceed 150000 across all test cases.

*/

class FreqStack {
        int index; //used to deal with frequency tie. might overflow, but question says we will only have 10^4 push operations
    Map<Integer, Integer> map = new HashMap<>(); //val->freq
    PriorityQueue<int[]> pq; //val, freq, index

    public FreqStack() {
        index = 0;
        pq = new PriorityQueue<>((n1, n2) -> n2[1] == n1[1] ? n2[2] - n1[2] : n2[1] - n1[1]); //dealing with tie
        
    }
    
    //O(logn)
    public void push(int x) {
        map.put(x, map.containsKey(x) ? map.get(x) + 1 : 1);
        pq.offer(new int[]{x, map.get(x), index++});
    }
    
    //O(1)
    public int pop() {
        int x = pq.poll()[0];
        map.put(x, map.get(x)-1); 
        if(map.get(x)==0) map.remove(x);
        return x;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */

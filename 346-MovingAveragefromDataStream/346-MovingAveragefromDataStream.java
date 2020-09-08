/*

346. Moving Average from Data Stream
Easy

Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Example:

MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3

*/

class MovingAverage {

    /** Initialize your data structure here. */
    Queue<Integer> q;
    double sum;
    int size = 0;
    public MovingAverage(int size) {
        this.q = new LinkedList<>();
        this.sum = 0;
        this.size = size;
    }
    
    public double next(int val) {
        q.add(val);
        if(q.size() > size) sum -= q.poll();
        sum += val;
        return sum / (double)q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */

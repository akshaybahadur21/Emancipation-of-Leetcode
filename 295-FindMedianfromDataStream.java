/*

295. Find Median from Data Stream
Hard

Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
For example,

[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

    void addNum(int num) - Add a integer number from the data stream to the data structure.
    double findMedian() - Return the median of all elements so far.

 

Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2

 

Follow up:

    If all integer numbers from the stream are between 0 and 100, how would you optimize it?
    If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?

Link : https://leetcode.com/problems/find-median-from-data-stream/

*/


class MedianFinder {

    /** initialize your data structure here. */
    
    Queue <Integer> lowers = new PriorityQueue<>((n1,n2)->n2-n1); //max queue
    Queue <Integer> highers = new PriorityQueue<>((n1,n2)->n1-n2); // min queue
    
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if ( lowers.peek()!=null && num < lowers.peek())
            lowers.add(num);
        else
            highers.add(num);
        
        Queue <Integer> biggerHeap = lowers.size() >= highers.size() ? lowers : highers;
        Queue <Integer> smallerHeap = lowers.size() < highers.size() ? lowers : highers;
        
        if(biggerHeap.size() - smallerHeap.size() == 2)
            smallerHeap.add(biggerHeap.poll());
        
    }
    
    public double findMedian() {
        Queue <Integer> biggerHeap = lowers.size() >= highers.size() ? lowers : highers;
        Queue <Integer> smallerHeap = lowers.size() < highers.size() ? lowers : highers;
        
        if (smallerHeap.size() == biggerHeap.size())
            return (double)(smallerHeap.peek() + biggerHeap.peek()) / 2;
        else
            return biggerHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

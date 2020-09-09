/*

281. Zigzag Iterator
Medium

Given two 1d vectors, implement an iterator to return their elements alternately.

Example:

Input:
v1 = [1,2]
v2 = [3,4,5,6] 
Output: [1,3,2,4,5,6]
Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,3,2,4,5,6].

Follow up:

What if you are given k 1d vectors? How well can your code be extended to such cases?

Clarification for the follow up question:
The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example:

Input:
[1,2,3]
[4,5,6,7]
[8,9]

Output: [1,4,8,2,5,9,3,6,7].

*/

public class ZigzagIterator {
    List<Integer> l;
    int len;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.l = new ArrayList<>();
        this.len = 0;
        int l1 = 0, l2 = 0;
        while(l1 + l2 != v1.size() + v2.size()){
            if(l1 != v1.size())
                l.add(v1.get(l1++));
            if(l2 != v2.size())
                l.add(v2.get(l2++));
        }
    }

    public int next() {
        return l.get(len++);
    }

    public boolean hasNext() {
        return len < l.size();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */

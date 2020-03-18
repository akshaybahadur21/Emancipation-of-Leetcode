/*

1167. Minimum Cost to Connect Sticks
Medium

You have some sticks with positive integer lengths.

You can connect any two sticks of lengths X and Y into one stick by paying a cost of X + Y.  You perform this action until there is one stick remaining.

Return the minimum cost of connecting all the given sticks into one stick in this way.

 

Example 1:

Input: sticks = [2,4,3]
Output: 14
Example 2:

Input: sticks = [1,8,3,5]
Output: 30
 

Constraints:

1 <= sticks.length <= 10^4
1 <= sticks[i] <= 10^4

*/

class Solution {
    public int connectSticks(int[] sticks) {
        //Have a min Heap to keep track of the smallest element at all times
        if (sticks.length <= 1) return 0;
        Queue<Integer> heap = new PriorityQueue<>((n1,n2) -> n1 - n2);
        for (int i : sticks)
            heap.add(i);
        int val =0;
        int temp = 0;
        while(heap.size() != 2){
            temp = heap.poll() + heap.poll();
            val += temp;
            heap.add(temp);
        }
        return val + heap.poll() + heap.poll();
    }
}

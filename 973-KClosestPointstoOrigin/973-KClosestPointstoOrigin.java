/*

973. K Closest Points to Origin
Medium

We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

 

Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].

Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)

 

Note:

    1 <= K <= points.length <= 10000
    -10000 < points[i][0] < 10000
    -10000 < points[i][1] < 10000

Link : https://leetcode.com/problems/k-closest-points-to-origin/submissions/

*/

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        
    PriorityQueue<int[]> heap = new PriorityQueue<>((x, y) -> (x[0]*x[0] + x[1]*x[1]) - (y[0]*y[0]+y[1]*y[1]));        //We created a min priority queue
        for (int[]p:points)
            heap.add(p);
        
        int[][] res = new int[K][];
        int count=0;
        while(K-- >0)
            res[count++]=heap.poll();
        return res;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        
    PriorityQueue<int[]> heap = new PriorityQueue<>((y, x) -> (x[0]*x[0] + x[1]*x[1]) - (y[0]*y[0]+y[1]*y[1]));        
        //We created a max priority queue
        for (int[]p : points){
            heap.add(p);
            if (heap.size() > K)
                heap.poll();
        }
        
        int[][] res = new int[K][];
        int count=0;
        while(!heap.isEmpty())
            res[count++]=heap.poll();
        return res;
    }
}

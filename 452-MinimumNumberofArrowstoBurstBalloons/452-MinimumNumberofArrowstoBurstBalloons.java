/*

452. Minimum Number of Arrows to Burst Balloons
Medium

There are some spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter, and hence the x-coordinates of start and end of the diameter suffice. The start is always smaller than the end.

An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An arrow once shot keeps traveling up infinitely.

Given an array points where points[i] = [xstart, xend], return the minimum number of arrows that must be shot to burst all balloons.

Example 1:

Input: points = [[10,16],[2,8],[1,6],[7,12]]
Output: 2
Explanation: One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).

Example 2:

Input: points = [[1,2],[3,4],[5,6],[7,8]]
Output: 4

Example 3:

Input: points = [[1,2],[2,3],[3,4],[4,5]]
Output: 2

Example 4:

Input: points = [[1,2]]
Output: 1

Example 5:

Input: points = [[2,3],[2,3]]
Output: 1

Constraints:

    0 <= points.length <= 104
    points.length == 2
    -231 <= xstart < xend <= 231 - 1

*/

class Solution {
    public int findMinArrowShots(int[][] points) {
        // think about the intersection
        if(points == null || points.length == 0) return 0;
        Arrays.sort(points, (n1, n2) -> Integer.compare(n1[0], n2[0]));
        int res = 1, end = points[0][1];
        for(int i = 0; i < points.length; i++){
            int[] curr = points[i];
            if(curr[0] <= end){
                end = Math.min(end, curr[1]);
            }
            else{
                res++;
                end = curr[1];
            }
        }
        return res;
    }
}

class Solution {
    public int findMinArrowShots(int[][] points) {
        // Arrays.sort(points, (n1, n2) -> n1[0] - n2[0]);
         Arrays.sort(points, (o1, o2) -> {
            // We can't simply use the o1[1] - o2[1] trick, as this will cause an 
            // integer overflow for very large or small values.
            if (o1[1] == o2[1]) return 0;
            if (o1[1] < o2[1]) return -1;
            return 1;
        });
        LinkedList<int[]> q = new LinkedList<>();
        q.add(points[0]);
        for(int i = 1; i < points.length; i++){
            int[] curr = points[i];
            int last[] = q.pollLast();
           if(last[1] < curr[0]){
               q.add(last);
               q.add(curr);
           } 
            else{
                q.add(new int[]{Math.max(curr[0], last[0]), Math.min(curr[1], last[1])});
            }
        }
        return q.size();
    }
}

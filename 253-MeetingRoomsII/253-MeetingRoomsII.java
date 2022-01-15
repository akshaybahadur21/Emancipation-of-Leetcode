/*

253. Meeting Rooms II
Medium

Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2

Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1

Constraints:

    1 <= intervals.length <= 104
    0 <= starti < endi <= 106

*/

class Solution {
    public int minMeetingRooms(int[][] intervals) {
      Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
      PriorityQueue<Integer> pq =new PriorityQueue<Integer>();
        for(int[] interval:intervals){
            if(pq.isEmpty()){
              pq.add(interval[1]);
              continue;
            }else if( pq.peek()<=interval[0]){
                pq.poll();
            }pq.add(interval[1]);
            }
        return pq.size();
        }
    }

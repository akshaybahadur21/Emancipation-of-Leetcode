/*

57. Insert Interval
Hard

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

*/

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        if(newInterval == null || newInterval.length == 0) return new int[][]{{}};
        if(!validateInput(intervals, newInterval)) return intervals == null || intervals.length == 0 ? new int[][]{{newInterval[0], newInterval[1]}} : intervals;
        int i = 0;
        while(i < intervals.length && intervals[i][1] < newInterval[0]) list.add(intervals[i++]);
        while(i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        list.add(newInterval);
        while(i < intervals.length) list.add(intervals[i++]);
        return list.toArray(new int[list.size()][2]);
    }
    private boolean validateInput(int[][] intervals, int[] newInterval) {
        if(intervals == null || intervals.length == 0 || intervals[0].length == 0 || newInterval == null || newInterval.length == 0 ) 
            return false;
        return true;
    }
}

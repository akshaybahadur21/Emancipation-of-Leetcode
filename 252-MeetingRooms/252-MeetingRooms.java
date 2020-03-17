/*

252. Meeting Rooms

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

Example 1:

Input: [[0,30],[5,10],[15,20]]
Output: false
Example 2:

Input: [[7,10],[2,4]]
Output: true

*/

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0]-i2[0]);
        for (int i = 0; i<intervals.length-1; i++){
            if (intervals[i][1] > intervals[i + 1][0])
                return false;
        }
        return true;
    }
}

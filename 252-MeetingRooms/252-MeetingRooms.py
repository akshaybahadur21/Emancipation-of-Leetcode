"""

252. Meeting Rooms

Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: false

Example 2:

Input: intervals = [[7,10],[2,4]]
Output: true

Constraints:

    0 <= intervals.length <= 104
    intervals[i].length == 2
    0 <= starti < endi <= 106

"""

class Solution:
    def canAttendMeetings(self, intervals: List[List[int]]) -> bool:
        if len(intervals) <= 1: return True
        intervals.sort(key=lambda x : x[0])
        prev = intervals[0]
        for i in range(1, len(intervals)):
            curr = intervals[i]
            if prev[1] > curr[0]: return False
            prev = curr
        return True

"""

539. Minimum Time Difference

Given a list of 24-hour clock time points in "HH:MM" format, return the minimum minutes difference between any two time-points in the list.

Example 1:

Input: timePoints = ["23:59","00:00"]
Output: 1

Example 2:

Input: timePoints = ["00:00","23:59","00:00"]
Output: 0

Constraints:

    2 <= timePoints.length <= 2 * 104
    timePoints[i] is in the format "HH:MM".

"""

class Solution:
    def findMinDifference(self, timePoints: List[str]) -> int:
        min_arr = []
        for i in range(len(timePoints)): 
            minutes_to_sec = int(timePoints[i][0:2]) * 60 
            sec = int(timePoints[i][3:5])
            min_arr.append(minutes_to_sec + sec)
        min_arr = sorted(min_arr)
        res = float("inf")
        for i in range(1, len(min_arr)):  res = min(res, min_arr[i] - min_arr[i - 1])
        return min(res, 24 * 60 - min_arr[-1] + min_arr[0])

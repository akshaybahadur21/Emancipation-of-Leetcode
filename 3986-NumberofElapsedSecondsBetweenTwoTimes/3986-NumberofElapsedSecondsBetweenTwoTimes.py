"""

3986. Number of Elapsed Seconds Between Two Times

You are given two valid times startTime and endTime, each represented as a string in the format "HH:MM:SS".

Return the number of seconds that have elapsed from startTime to endTime.

Example 1:

Input: startTime = "01:00:00", endTime = "01:00:25"

Output: 25

Explanation:
endTime is 25 seconds ahead of startTime.

Example 2:

Input: startTime = "12:34:56", endTime = "13:00:00"

Output: 1504

Explanation:

endTime is 25 minutes and 4 seconds ahead of startTime, which equals 1504 seconds.

Constraints:

    startTime.length == 8
    endTime.length == 8
    startTime and endTime are valid times in the format "HH:MM:SS"
    00 <= HH <= 23
    00 <= MM <= 59
    00 <= SS <= 59
    endTime is not earlier than startTime

"""

class Solution:
    def secondsBetweenTimes(self, startTime: str, endTime: str) -> int:
        h1, m1, s1 = startTime.split(":")
        h2, m2, s2 = endTime.split(":")

        start_sec = int(s1) + int(m1) * 60 + int(h1) * 60 * 60
        end_sec = int(s2) + int(m2) * 60 + int(h2) * 60 * 60

        return end_sec - start_sec

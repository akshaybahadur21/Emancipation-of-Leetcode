"""

552. Student Attendance Record II

An attendance record for a student can be represented as a string where each character signifies whether the student was absent, late, or present on that day. The record only contains the following three characters:

    'A': Absent.
    'L': Late.
    'P': Present.

Any student is eligible for an attendance award if they meet both of the following criteria:

    The student was absent ('A') for strictly fewer than 2 days total.
    The student was never late ('L') for 3 or more consecutive days.

Given an integer n, return the number of possible attendance records of length n that make a student eligible for an attendance award. The answer may be very large, so return it modulo 109 + 7.

Example 1:

Input: n = 2
Output: 8
Explanation: There are 8 records with length 2 that are eligible for an award:
"PP", "AP", "PA", "LP", "PL", "AL", "LA", "LL"
Only "AA" is not eligible because there are 2 absences (there need to be fewer than 2).

Example 2:

Input: n = 1
Output: 3

Example 3:

Input: n = 10101
Output: 183236316

Constraints:

    1 <= n <= 105

"""

class Solution:
    def checkRecord(self, n: int) -> int:
        def dfs(n, total_absent, consecutive_late):
            if total_absent >= 2 or consecutive_late >= 3:
                return 0
            if n == 0:
                return 1
            count = 0
            if cache[n][total_absent][consecutive_late] != - 1:
                return cache[n][total_absent][consecutive_late]

            count = dfs(n - 1, total_absent, 0) % mod

            count = (count + dfs(n - 1, total_absent + 1, 0)) % mod

            count = (count + dfs(n - 1, total_absent, consecutive_late + 1)) % mod

            cache[n][total_absent][consecutive_late] = count
            return count
        
        cache = [[[-1] * 3 for _ in range(2)] for _ in range(n + 1)]
        mod = 1_000_000_007
        return dfs(n, 0, 0)
        

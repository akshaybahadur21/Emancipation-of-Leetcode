/*

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

*/

class Solution {
    private final int MOD = 1000000007;
    public int checkRecord(int n) {
        Integer[][][] cache = new Integer[n + 1][2][3];
        return dfs(n, 0, 0, cache);
    }

    private int dfs(int n, int totalAbsence, int consecutiveLate, Integer[][][] cache){
        if(totalAbsence >= 2 || consecutiveLate >= 3) return 0;
        if(n == 0) return 1;
        if (cache[n][totalAbsence][consecutiveLate] != null) return cache[n][totalAbsence][consecutiveLate];
        int count = 0;

        //Present
        count = dfs(n - 1, totalAbsence, 0, cache) % MOD;

        //Absent
        count = (count + dfs(n - 1, totalAbsence + 1, 0, cache))% MOD;

        //Late
        count = (count + dfs(n - 1, totalAbsence , consecutiveLate + 1, cache))% MOD;

        return cache[n][totalAbsence][consecutiveLate] = count;
    }
}

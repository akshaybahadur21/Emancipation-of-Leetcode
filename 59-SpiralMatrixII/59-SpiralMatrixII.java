/*

59. Spiral Matrix II
Medium

Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

*/
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int curr = 1;
        int rowBegin = 0;
        int rowEnd = n - 1;
        int colBegin = 0;
        int colEnd = n - 1;
        while(curr <= n * n){
            for(int i = colBegin; i <= colEnd; i++)
                res[rowBegin][i] = curr++;
            rowBegin++;
            for(int i = rowBegin; i <= rowEnd; i++)
                res[i][colEnd] = curr++;
            colEnd--;
            for(int i = colEnd; i>=colBegin; i--)
                res[rowEnd][i] = curr++;
            rowEnd--;
            for(int i = rowEnd; i >= rowBegin; i--)
                res[i][colBegin] = curr++;
            colBegin++;
        }
        return res;
    }
}

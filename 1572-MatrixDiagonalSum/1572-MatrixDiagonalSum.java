/*

1572. Matrix Diagonal Sum
Easy

Given a square matrix mat, return the sum of the matrix diagonals.

Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.

Example 1:

Input: mat = [[1,2,3],
              [4,5,6],
              [7,8,9]]
Output: 25
Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
Notice that element mat[1][1] = 5 is counted only once.

Example 2:

Input: mat = [[1,1,1,1],
              [1,1,1,1],
              [1,1,1,1],
              [1,1,1,1]]
Output: 8

Example 3:

Input: mat = [[5]]
Output: 5

Constraints:

    n == mat.length == mat[i].length
    1 <= n <= 100
    1 <= mat[i][j] <= 100

*/

class Solution {
    public int diagonalSum(int[][] mat) {
        int left_i = 0, left_j = 0, right_i = 0, right_j = mat[0].length - 1, res = 0;
        while(left_i != mat.length && right_j != -1){
            res += mat[left_i][left_j];
            res += mat[right_i][right_j];
            left_i++; left_j++;
            right_i++; right_j--;
        }
        if(mat.length % 2 !=  0){
            res -= mat[mat.length/2][mat.length/2];
        }
        return res;
    }
}

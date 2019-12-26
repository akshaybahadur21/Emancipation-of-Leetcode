/*

74. Search a 2D Matrix
Medium

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.

Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true

Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false

Link : https://leetcode.com/problems/search-a-2d-matrix/submissions/

*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        
        int row = 0;
        int col = matrix[0].length -1;
        while(row<matrix.length && col>-1){
            if (matrix[row][col] == target)
                return true;
            if(matrix[row][col] > target)
                col--;
            else
                row++;
        }
        return false;
    }
}

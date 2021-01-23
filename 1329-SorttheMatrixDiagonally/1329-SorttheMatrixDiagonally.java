/*

1329. Sort the Matrix Diagonally
Medium

A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row or leftmost column and going in the bottom-right direction until reaching the matrix's end. For example, the matrix diagonal starting from mat[2][0], where mat is a 6 x 3 matrix, includes cells mat[2][0], mat[3][1], and mat[4][2].

Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and return the resulting matrix.

Example 1:

Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]

Constraints:

    m == mat.length
    n == mat[i].length
    1 <= m, n <= 100
    1 <= mat[i][j] <= 100

*/


class Solution {
    public int[][] diagonalSort(int[][] mat) {
        //if j - i is common, they belong to the same diagonal
        // add this to a map of integer and min pqueue
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(!map.containsKey(j - i)) {
                    Queue<Integer> q = new PriorityQueue<>((n1 , n2) -> n1 - n2);
                    map.put(j - i, q);
                }
                map.get(j - i).add(mat[i][j]);
            }
        }
         for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                mat[i][j] = map.get(j - i).poll();
            }
         }
        return mat;
    }
}

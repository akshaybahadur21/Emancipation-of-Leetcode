/*

378. Kth Smallest Element in a Sorted Matrix
Medium

Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.

Note:
You may assume k is always valid, 1 ≤ k ≤ n2.

Link : https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

*/

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        Queue<Integer> heap = new PriorityQueue<>((n1,n2)->n2-n1);
        for (int i=0;i<matrix.length;i++)
        {
            for (int j=0;j<matrix.length;j++)
            {
                heap.add(matrix[i][j]);
                if (heap.size()>k) 
                    heap.remove();
            }
        }
        return heap.poll();
    }
}

/*

977. Squares of a Sorted Array
Easy

Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.

Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]

Example 2:

Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]


Note:

    1 <= A.length <= 10000
    -10000 <= A[i] <= 10000
    A is sorted in non-decreasing order.

*/

class Solution {
    public int[] sortedSquares(int[] A) {
        //Couple of Approach
        // 1. simple square and sort
        // 2. Use Min Heap
        // 3. Use 2 pointer
        for(int i =0; i< A.length; i++)
            A[i] = A[i] * A[i];
        Arrays.sort(A);
        return A;
    }
}

class Solution {
    public int[] sortedSquares(int[] A) {
        //Couple of Approach
        // 1. simple square and sort
        // 2. Use Min Heap
        // 3. Use 2 pointer
        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> n1 - n2);
        // int[] res = new int[A.length];
        for(int i =0; i< A.length; i++)
            heap.add(A[i] * A[i]);
        int count = 0;
        while(!heap.isEmpty()){
            A[count++] = heap.poll();
        }
        return A;
    }
}

class Solution {
    public int[] sortedSquares(int[] A) {
        //Couple of Approach
        // 1. simple square and sort
        // 2. Use Min Heap
        // 3. Use 2 pointer
        int res[] = new int[A.length];
        //Now, we know that the biggest absolute number will either be at 0 or at N
        //We keep pointers on both of thrm and just travers the entire array
        int i = 0;
        int j = A.length - 1;
        int count = A.length-1;
        while(count >= 0){
            if (A[i]*A[i] > A[j] * A[j]){
                res[count--] = A[i] * A[i];
                i++;
            }
            else{
                res[count--] = A[j] * A[j];
                j--;
            }
        }
        return res;
    }
}

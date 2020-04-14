/*

658. Find K Closest Elements
Medium

Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

Example 1:

Input: [1,2,3,4,5], k=4, x=3
Output: [1,2,3,4]

Example 2:

Input: [1,2,3,4,5], k=4, x=-1
Output: [1,2,3,4]

Note:

    The value k is positive and will always be smaller than the length of the sorted array.
    Length of the given array is positive and will not exceed 104
    Absolute value of elements in the array and x will not exceed 104

*/

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // create a max heap to return min values;
        List<Integer> resList = new ArrayList<>();
        Queue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> Math.abs(x - n2) == Math.abs(x - n1) ? n2 - n1 :  Math.abs(x - n2) - Math.abs(x - n1));
        for(int a : arr){
            heap.add(a);
            if(heap.size() > k)
                heap.poll();
        }
        while(!heap.isEmpty())
            resList.add(heap.poll());
        Collections.sort(resList);
        return resList;
    }
}

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> resList = new ArrayList<>();
        int left = 0, right = arr.length - k;
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - arr[mid] > arr[mid + k] - x)
                left = mid + 1;
            else
                right = mid;
        }
        for(int i = left; i < left + k; i++)
            resList.add(arr[i]);
        return resList;
    }
}

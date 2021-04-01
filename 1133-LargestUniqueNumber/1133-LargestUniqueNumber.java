/*

1133. Largest Unique Number
Easy

Given an array of integers A, return the largest integer that only occurs once.

If no integer occurs once, return -1.

Example 1:

Input: [5,7,3,9,4,9,8,3,1]
Output: 8
Explanation: 
The maximum integer in the array is 9 but it is repeated. The number 8 occurs only once, so it's the answer.

Example 2:

Input: [9,9,8,8]
Output: -1
Explanation: 
There is no number that occurs only once.

Note:

    1 <= A.length <= 2000
    0 <= A[i] <= 1000

*/

class Solution {
    public int largestUniqueNumber(int[] A) {
        int res = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) map.put(a, map.containsKey(a) ? map.get(a) + 1 : 1);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1) res = Math.max(res, entry.getKey());
        }
        return res;
    }
}

/*

1299. Replace Elements with Greatest Element on Right Side
Easy

Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.

After doing so, return the array.

Example 1:

Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]

Constraints:

    1 <= arr.length <= 10^4
    1 <= arr[i] <= 10^5

*/

class Solution {
    public int[] replaceElements(int[] arr) {
        int[] res = new int[arr.length];
        res[arr.length - 1] = -1;
        int max = arr[arr.length - 1];
        for(int i = arr.length - 2; i>=0; i--){
            max = Math.max(max, arr[i + 1]);
            res[i] = max;
        }
        return res;
    }
}

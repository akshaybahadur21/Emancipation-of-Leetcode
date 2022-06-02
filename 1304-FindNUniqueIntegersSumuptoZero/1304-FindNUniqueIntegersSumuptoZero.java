/*

1304. Find N Unique Integers Sum up to Zero
Easy

Given an integer n, return any array containing n unique integers such that they add up to 0.

Example 1:

Input: n = 5
Output: [-7,-1,1,3,4]
Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].

Example 2:

Input: n = 3
Output: [-1,0,1]

Example 3:

Input: n = 1
Output: [0]

Constraints:

    1 <= n <= 1000

*/
class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int count = 0;
        if(n % 2 != 0)
            res[count++] = 0;
        for(int i = 1; i <= n / 2; i++){
            res[count++] = i;
            res[count++] = -i;
        }
        return res;
    }
}

class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int mid = n / 2;
        for(int i = 0; i < mid; i++){
            res[i] = -mid + i;
            res[n - i - 1] = mid - i;
        }
        return res;
    }
}

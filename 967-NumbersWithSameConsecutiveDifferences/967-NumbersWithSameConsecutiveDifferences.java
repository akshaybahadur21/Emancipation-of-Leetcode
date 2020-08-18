/*

967. Numbers With Same Consecutive Differences
Medium

Return all non-negative integers of length N such that the absolute difference between every two consecutive digits is K.

Note that every number in the answer must not have leading zeros except for the number 0 itself. For example, 01 has one leading zero and is invalid, but 0 is valid.

You may return the answer in any order.

Example 1:

Input: N = 3, K = 7
Output: [181,292,707,818,929]
Explanation: Note that 070 is not a valid number, because it has leading zeroes.

Example 2:

Input: N = 2, K = 1
Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]

Note:

    1 <= N <= 9
    0 <= K <= 9

*/

class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        if(N == 0) return new int[]{0};
        List<Integer> resList = new ArrayList<>();
        if(N == 1) resList.add(0);
        dfs(resList, N, K, 0);
        return resList.stream().mapToInt(i -> i).toArray();
    }
    private void dfs(List<Integer> resList, int N, int K, int num){
        if(N == 0){
            resList.add(num);
            return;
        }
        for(int i = 0; i < 10; i++){
            if(num == 0 && i == 0) continue;
            if(num == 0 && i != 0) dfs(resList, N - 1, K, i);
            else if(Math.abs(num % 10 - i) == K) dfs(resList, N - 1, K, num * 10 + i);
        }
    }
}

/*

60. Permutation Sequence
Medium

The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

    "123"
    "132"
    "213"
    "231"
    "312"
    "321"

Given n and k, return the kth permutation sequence.

Note:

    Given n will be between 1 and 9 inclusive.
    Given k will be between 1 and n! inclusive.

Example 1:

Input: n = 3, k = 3
Output: "213"

Example 2:

Input: n = 4, k = 9
Output: "2314"

*/

class Solution {
    int curr = 0;
    public String getPermutation(int n, int k) {
        List<String> result = new ArrayList<>();
        dfs(n, k, result, new StringBuilder(), new boolean[n+1]);
        return result.get(0);
    }
    private void dfs(int n, int k, List<String> result, StringBuilder sb, boolean[] vis){
        if(sb.length() == n && ++curr == k){
            result.add(sb.toString());
            return;
        }
        if(sb.length() >= n) return;
        for(int i = 1; i <= n; i++ ){
            if(result.size() > 0) break;
            if(vis[i]) continue;
            sb.append(i);
            vis[i] = true;
            dfs(n, k, result, sb, vis);
            sb.deleteCharAt(sb.length() - 1);
            vis[i] = false;
        }
    }
}

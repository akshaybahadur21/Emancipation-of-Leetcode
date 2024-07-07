/*

3211. Generate Binary Strings Without Adjacent Zeros

You are given a positive integer n.

A binary string x is valid if all
substrings
of x of length 2 contain at least one "1".

Return all valid strings with length n, in any order.

Example 1:

Input: n = 3

Output: ["010","011","101","110","111"]

Explanation:

The valid strings of length 3 are: "010", "011", "101", "110", and "111".

Example 2:

Input: n = 1

Output: ["0","1"]

Explanation:

The valid strings of length 1 are: "0" and "1".

Constraints:

    1 <= n <= 18

*/

class Solution {
    public List<String> validStrings(int n) {
        List<String> resList = new ArrayList<>();
        dfs(n, new StringBuilder(), resList, -1);
        return resList;
    }

    private void dfs(int n, StringBuilder sb, List<String> resList, int last){
        if (sb.length() == n){
            resList.add(new String(sb.toString()));
            return;
        }
        sb.append('1');
        dfs(n, sb, resList, 1);
        sb.deleteCharAt(sb.length() - 1);

        if (last != 0) {
            sb.append('0');
            dfs(n, sb, resList, 0);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

/*

22. Generate Parentheses
Medium

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

*/

class Solution {
    public List<String> generateParenthesis(int n) {
        // backtracking dfs approach
        List<String> resList = new ArrayList<>();
        dfs(resList, n, new StringBuilder(), 0,0);
        return resList;
    }
    private void dfs(List<String> resList, int n, StringBuilder sb, int open, int close){

        if (sb.length() == n*2){
            resList.add(sb.toString());
            return;
        }
        if(open < n){
            dfs(resList, n, sb.append("("), open + 1, close);
             sb.deleteCharAt(sb.length()-1);
        }
        if(close < open){
            dfs(resList, n, sb.append(")"), open, close + 1);
             sb.deleteCharAt(sb.length()-1);
        }
    }
}

class Solution {
    public List<String> generateParenthesis(int n) {
        // backtracking dfs approach
        List<String> resList = new ArrayList<>();
        dfs(resList, n, new StringBuilder(), 0,0);
        return resList;
    }
    private void dfs(List<String> resList, int n, StringBuilder sb, int open, int close){

        if (sb.length() == n*2){
            resList.add(sb.toString());
            return;
        }
        if(open < n)
            dfs(resList, n, new StringBuilder(sb).append("("), open + 1, close);
        if(close < open)
            dfs(resList, n, new StringBuilder(sb).append(")"), open, close + 1);
    }
}


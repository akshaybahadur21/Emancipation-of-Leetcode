/*

784. Letter Case Permutation
Easy

Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]

*/

class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        if(S.length() == 0) return res;
        dfs(S, res, 0, "");
        return res;
    }
    
    private void dfs(String S, List<String> res, int curr, String s){
        if (s.length() == S.length()){
            res.add(s);
            return;
        }
        char ch = S.charAt(curr);
        if(ch >= '0' && ch <= '9'){
            dfs(S, res, curr + 1, s + String.valueOf(ch));
            return;
        }
         dfs(S, res, curr + 1, s + String.valueOf(Character.toUpperCase(ch)));
         dfs(S, res, curr + 1, s + String.valueOf(Character.toLowerCase(ch)));
    }
}

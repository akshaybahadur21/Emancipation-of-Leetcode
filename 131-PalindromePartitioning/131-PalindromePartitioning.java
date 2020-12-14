/*

131. Palindrome Partitioning
Medium

Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

Example 2:

Input: s = "a"
Output: [["a"]]

Constraints:

    1 <= s.length <= 16
    s contains only lowercase English letters.

*/

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> resList = new ArrayList<>();
        dfs(s, resList, new ArrayList<String>(), 0);
        return resList;
    }
    private void dfs(String s, List<List<String>> resList, List<String> list, int idx){
        if(idx > s.length()) return;
        if(idx == s.length()) resList.add(new ArrayList<>(list));
        for(int i = idx; i < s.length(); i++){
            if(isPalindrome(s, idx, i)){
                list.add(s.substring(idx, i + 1));
                dfs(s, resList, list, i + 1);
                list.remove(list.size() - 1);
            }
            
        }
    }
    private boolean isPalindrome(String s, int lo, int hi) {
        while (lo < hi) {
            if (s.charAt(lo++) != s.charAt(hi--)) return false;
        }
        return true;
    }
}

/*

139. Word Break
Medium

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

    The same word in the dictionary may be reused multiple times in the segmentation.
    You may assume the dictionary does not contain duplicate words.

Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.

Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false

*/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // DP with memoization
        if(!validateInput(s, wordDict)) return false;
        return dfs(s, 0, new HashSet<>(wordDict), new Boolean[s.length()]);
    }
    private boolean dfs(String s, int idx, Set<String> words, Boolean[] cache){
        if(idx == s.length()) return true;
        if(cache[idx] != null) return cache[idx];
        for(int i = idx + 1; i <= s.length(); i++){
            if(words.contains(s.substring(idx, i)) && dfs(s, i, words, cache))
                return cache[idx] = true;
        }
        return cache[idx] = false;
    }
    private boolean validateInput(String s, List<String> wordDict) {
        if(s == null ) return false;
        return true;
    }
}

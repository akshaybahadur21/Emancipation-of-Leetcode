"""

139. Word Break

Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.

Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false

Constraints:

    1 <= s.length <= 300
    1 <= wordDict.length <= 1000
    1 <= wordDict[i].length <= 20
    s and wordDict[i] consist of only lowercase English letters.
    All the strings of wordDict are unique.

"""

class Solution:
    def dfs(self, s, idx, wordSet, cache):
        if idx == len(s): return True;
        if cache[idx]is not None: return cache[idx]
        for i in range(idx + 1, len(s) + 1):
            if s[idx:i] in wordSet and self.dfs(s, i, wordSet, cache):
                cache[idx] = True
                return cache[idx]
        cache[idx] = False;
        return cache[idx]

    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        cache = [None for _ in range(len(s))]
        return self.dfs(s, 0, set(wordDict), cache)

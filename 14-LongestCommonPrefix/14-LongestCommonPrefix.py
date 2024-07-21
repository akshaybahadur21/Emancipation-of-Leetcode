"""

14. Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Constraints:

    1 <= strs.length <= 200
    0 <= strs[i].length <= 200
    strs[i] consists of only lowercase English letters.

"""

class TrieNode:
    def __init__(self):
        self.children = {}
        self.isEnd = False

class Solution:
    def insert_in_trie(self, node, word):
        for ch in word:
            if ch not in node.children.keys(): node.children[ch] = TrieNode()
            node = node.children[ch]

    def search(self, node, word):
        res = 0
        for ch in word:
            if ch not in node.children.keys(): return res
            res += 1
            node = node.children[ch]
        return res

    def longestCommonPrefix(self, strs: List[str]) -> str:
        if len(strs) == 1: return strs[0]
        root = TrieNode()
        node = root
        self.insert_in_trie(node, strs[0])
        res = float("inf")
        for i in range(1, len(strs)):
            node = root
            curr = self.search(node, strs[i])
            if curr == 0 : return ""
            res = min(curr, res)
        return strs[0][0:res]

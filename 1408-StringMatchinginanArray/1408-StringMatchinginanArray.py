"""

1408. String Matching in an Array

Given an array of string words, return all strings in words that is a substring of another word. You can return the answer in any order.

A substring is a contiguous sequence of characters within a string

Example 1:

Input: words = ["mass","as","hero","superhero"]
Output: ["as","hero"]
Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
["hero","as"] is also a valid answer.

Example 2:

Input: words = ["leetcode","et","code"]
Output: ["et","code"]
Explanation: "et", "code" are substring of "leetcode".

Example 3:

Input: words = ["blue","green","bu"]
Output: []
Explanation: No string of words is substring of another string.

Constraints:

    1 <= words.length <= 100
    1 <= words[i].length <= 30
    words[i] contains only lowercase English letters.
    All the strings of words are unique.

"""

class Solution:
    def stringMatching(self, words: List[str]) -> List[str]:
        def add_to_Trie(word):
            node = root
            for ch in word:
                if ch not in node.children:
                    node.children[ch] = TNode()
                node = node.children[ch]
                node.freq += 1
        
        def is_substring(word):
            node = root
            for ch in word:
                node = node.children[ch]
            return node.freq > 1

        root = TNode()
        res = []
        for word in words: 
            for start_index in range(len(word)):
                add_to_Trie(word[start_index:])
        for word in words:
            if is_substring(word): res.append(word)
        return res

        
class TNode:
    def __init__(self):
        self.children = {}
        self.isEnd = False
        self.freq = 0

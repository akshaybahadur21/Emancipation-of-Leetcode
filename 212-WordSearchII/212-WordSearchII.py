"""

212. Word Search II

Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example 1:

Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]

Example 2:

Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []

Constraints:

    m == board.length
    n == board[i].length
    1 <= m, n <= 12
    board[i][j] is a lowercase English letter.
    1 <= words.length <= 3 * 104
    1 <= words[i].length <= 10
    words[i] consists of lowercase English letters.
    All the strings of words are unique.

"""

class TrieNode:
    def __init__(self):
        self.children = {}
        self.isEnd = False

class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        root = TrieNode()
        def insert_in_trie(word, curr):
            for ch in word:
                if ch not in curr.children: curr.children[ch] = TrieNode()
                curr = curr.children[ch]
            curr.isEnd = True
        for word in words:
            curr = root
            insert_in_trie(word, curr)
        reslist = []
        def dfs(i, j, curr, word):
            if curr.isEnd:
                reslist.append(word)
                curr.isEnd = False
            if i < 0 or j < 0 or i >= len(board) or j >= len(board[0]) or board[i][j] not in curr.children or vis[i][j]: return
            vis[i][j] = True
            curr = curr.children[board[i][j]]
            dfs(i + 1, j, curr, word + board[i][j])
            dfs(i, j + 1, curr, word + board[i][j])
            dfs(i - 1, j, curr, word + board[i][j])
            dfs(i, j - 1, curr, word + board[i][j])
            vis[i][j] = False

        vis = [[False] * len(board[0]) for _ in range(len(board))]
        for i in range(len(board)):
            for j in range(len(board[0])):
                curr = root
                if board[i][j] in curr.children: dfs(i, j, curr, "")
        return reslist

/*

212. Word Search II
Hard

Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example:

Input: 
board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
words = ["oath","pea","eat","rain"]

Output: ["eat","oath"]

Note:

    All inputs are consist of lowercase letters a-z.
    The values of words are distinct.

*/

class Solution {
    TNode root = new TNode();
    public List<String> findWords(char[][] board, String[] words) {
        List<String> resList = new ArrayList<>();
        if(!validateInput(board, words)) return resList;
        for(String w : words)
            addToTrie(w);
        TNode temp = root;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(temp.children.containsKey(board[i][j])){
                    dfs(board, visited, resList, temp, new StringBuilder(),i, j);
                }
            }
        }
        return resList;
    }
    private boolean validateInput(char[][] board, String[] words){
        if(words == null || board == null || words.length == 0 || board.length == 0)
            return false;
        return true;
    }
    private void dfs(char[][] board, boolean[][] visited, List<String> resList, TNode temp, StringBuilder sb, int i, int j){
        if(temp.isEnd){
            resList.add(sb.toString());
            temp.isEnd = false;
        }
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || !temp.children.containsKey(board[i][j])) return;
        visited[i][j] = true;
        temp = temp.children.get(board[i][j]);
        sb.append(board[i][j]);
        
        dfs(board, visited, resList, temp, sb, i + 1, j);
        dfs(board, visited, resList, temp, sb, i, j + 1);
        dfs(board, visited, resList, temp, sb, i - 1, j);
        dfs(board, visited, resList, temp, sb, i, j - 1);
        
        sb.deleteCharAt(sb.length() - 1);
        visited[i][j] = false;
    }
    private void  addToTrie(String w){
        TNode temp = root;
        for(int i = 0; i < w.length(); i++){
            char ch = w.charAt(i);
            if(!temp.children.containsKey(ch))
                temp.children.put(ch, new TNode());
            temp = temp.children.get(ch);
        }
        temp.isEnd = true;
    }
}
class TNode{
    Map<Character, TNode> children;
    boolean isEnd;
    TNode(){
        children = new HashMap<>();
        isEnd = false;
    }
}

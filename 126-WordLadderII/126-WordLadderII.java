/*

126. Word Ladder II
Hard

Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

    Only one letter can be changed at a time
    Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

Note:

    Return an empty list if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
    You may assume no duplicates in the word list.
    You may assume beginWord and endWord are non-empty and are not the same.

Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]

Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: []

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.

*/

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Map<String, List<String>> graph = buildBFS(beginWord, endWord, wordSet);
        List<List<String>> resList = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        dfs(resList, list, beginWord, endWord, graph);
        return resList;
    }
     private Map<String, List<String>> buildBFS(String beginWord, String endWord, Set<String> wordSet){
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        HashMap<String, List<String>> graph = new HashMap<String, List<String>>();
        boolean isFound = false;
        q.add(beginWord);
        visited.add(beginWord);
        while(!q.isEmpty()){
            int len = q.size();
            Set<String> nextVisited = new HashSet<>(); 
            while(len -->0){
                String currWord = q.poll();
                List<String> nextWords = getNextLevel(currWord, wordSet);
                for(String nextWord : nextWords){
                    if(nextWord.equals(endWord)) isFound = true;
                    if(!visited.contains(nextWord)){
                            graph.computeIfAbsent(currWord, k -> new ArrayList<>()).add(nextWord);
                        if(!nextVisited.contains(nextWord)){
                            q.add(nextWord);
                            nextVisited.add(nextWord);
                        }
                    }
                }
            }
            if(isFound) break;
            visited.addAll(nextVisited);
        }
        return graph;
     }
    
    private void dfs(List<List<String>> resList, List<String> list, String beginWord, String endWord, Map<String, List<String>> graph){
        if(beginWord.equals(endWord)){
            resList.add(new ArrayList<>(list));
            return;
        }
        if(graph.containsKey(beginWord)){
            for(String word : graph.get(beginWord)){
                list.add(word);
                dfs(resList, list, word, endWord, graph);
                list.remove(list.size() - 1);
            }
        }
    }
    
    private List<String> getNextLevel(String currWord, Set<String> wordSet){
        List<String> nextWords = new ArrayList<>();
        char[] chArr = currWord.toCharArray();
        for(int i = 0; i < chArr.length; i++){
                char temp = chArr[i];
                for(char a = 'a'; a <= 'z'; a++){
                    chArr[i] = a;
                    String convStr = new String(chArr);
                    if(wordSet.contains(convStr)) nextWords.add(convStr);
                    chArr[i] = temp;
                }
            }
        return nextWords;
        } 
}

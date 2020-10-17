/*

127. Word Ladder
Medium

Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

    Only one letter can be changed at a time.
    Each transformed word must exist in the word list.

Note:

    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
    You may assume no duplicates in the word list.
    You may assume beginWord and endWord are non-empty and are not the same.

Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.

*/

class Solution {
    //bidirectional bfs
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!validateInput(beginWord, endWord, wordSet)) return 0;
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>(), vis = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int res = 1;
        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            //we want to work with the smaller of the 2 sets
            if(beginSet.size() > endSet.size()){
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> temp = new HashSet<>();
            for(String str : beginSet){
                char[] chArr = str.toCharArray();
                for(int i = 0; i < chArr.length; i++){
                    char ch = chArr[i];
                    for(char a = 'a'; a <= 'z'; a++){
                        chArr[i] = a;
                        String target = String.valueOf(chArr);
                        if(endSet.contains(target)) return res + 1;
                        if(!vis.contains(target) && wordSet.contains(target)){
                            vis.add(target);
                            temp.add(target);
                        }
                    }
                    chArr[i] = ch;
                }
            }
            beginSet = temp;
            res++;
        }
        return 0;
    }
    private boolean validateInput(String beginWord, String endWord, Set<String> wordSet) {
        if(beginWord == null || endWord == null || !wordSet.contains(endWord)) return false;
        return true;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!validateInput(beginWord, endWord, wordList)) return 0;
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        visited.add(beginWord);
        q.add(beginWord);
        int distance = 1;
        while(!q.isEmpty()){
            distance++;
            int len = q.size();
            for(int j = 0; j < len; j++){
                char[] chArray = q.poll().toCharArray();
                for(int i = 0; i < chArray.length; i++){
                    char temp = chArray[i];
                    for(char a = 'a'; a <= 'z'; a++){
                        chArray[i] = a;
                        String str = new String(chArray);
                        if(wordSet.contains(str) && !visited.contains(str)){
                            if(str.equals(endWord)) return distance;
                            q.add(str);
                            visited.add(str);
                        }
                    }
                    chArray[i] = temp;
                }
            }
        }
        return 0;
    }
    private boolean validateInput(String beginWord, String endWord, List<String> wordList){
        if(!wordList.contains(endWord) || beginWord == null ||endWord == null || wordList == null || wordList.size() == 0 || beginWord.equals(endWord))
            return false;
        return true;
    }
}

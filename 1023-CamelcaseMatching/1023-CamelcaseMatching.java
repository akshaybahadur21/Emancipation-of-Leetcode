/*

1023. Camelcase Matching
Medium

A query word matches a given pattern if we can insert lowercase letters to the pattern word so that it equals the query. (We may insert each character at any position, and may insert 0 characters.)

Given a list of queries, and a pattern, return an answer list of booleans, where answer[i] is true if and only if queries[i] matches the pattern.

Example 1:

Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
Output: [true,false,true,true,false]
Explanation: 
"FooBar" can be generated like this "F" + "oo" + "B" + "ar".
"FootBall" can be generated like this "F" + "oot" + "B" + "all".
"FrameBuffer" can be generated like this "F" + "rame" + "B" + "uffer".

Example 2:

Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
Output: [true,false,true,false,false]
Explanation: 
"FooBar" can be generated like this "Fo" + "o" + "Ba" + "r".
"FootBall" can be generated like this "Fo" + "ot" + "Ba" + "ll".

Example 3:

Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
Output: [false,true,false,false,false]
Explanation: 
"FooBarTest" can be generated like this "Fo" + "o" + "Ba" + "r" + "T" + "est".

Note:

    1 <= queries.length <= 100
    1 <= queries[i].length <= 100
    1 <= pattern.length <= 100
    All strings consists only of lower and upper case English letters.

*/

class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        Tnode root = new Tnode();
        insertToTrie(root, pattern);
        List<Boolean> resList = new ArrayList<>();
        for(String q : queries)
            resList.add(checkPattern(root, q));
        return resList;
    }
    private boolean checkPattern(Tnode root, String w){
        Tnode temp = root;
        for(char ch : w.toCharArray()){
            if(temp.children.containsKey(ch)){
                temp = temp.children.get(ch);
                continue;
            }
            if(ch >= 'a' && ch <= 'z') continue;
            return false;
        }
        return temp.isEnd;
    }
    
    private void insertToTrie(Tnode root, String w){
        Tnode temp = root;
        for(char ch : w.toCharArray()){
            if(!temp.children.containsKey(ch)){
                temp.children.put(ch, new Tnode());
                temp.ch = ch;
            }
            temp = temp.children.get(ch);
        }
        temp.isEnd = true;
    }
}
class Tnode{
    Map<Character, Tnode> children;
    char ch;
    boolean isEnd;
    Tnode(){
        this.children = new HashMap<>();
        this.isEnd = false;
        this.ch = '0';
    }
}

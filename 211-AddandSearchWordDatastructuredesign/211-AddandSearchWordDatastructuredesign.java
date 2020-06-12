/*

211. Add and Search Word - Data structure design
Medium

Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)

search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true

Note:
You may assume that all words are consist of lowercase letters a-z.

*/

class WordDictionary {

    /** Initialize your data structure here. */
    TNode root;
    public WordDictionary() {
        root = new TNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TNode temp = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!temp.children.containsKey(ch))
                temp.children.put(ch, new TNode());
            temp = temp.children.get(ch);
        }
        temp.isEnd = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(word == null || word.length() == 0) 
            return false;
        return dfs(word, root);
        
    }
    private boolean dfs(String word, TNode temp){
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(ch == '.'){
              for(char a = 'a' ; a <= 'z'; a++){
                  if(dfs(a + word.substring(i+1), temp))
                      return true;
              }
                return false;
            }
            else if(temp.children.containsKey(ch))
                temp = temp.children.get(ch);
            else
                return false;
        }
        return temp.isEnd;
    }
}

class TNode{
    Map<Character, TNode> children;
    boolean isEnd;
    TNode(){
        this.children = new HashMap<>();
        this.isEnd = false;
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

/*

1032. Stream of Characters
Hard

Implement the StreamChecker class as follows:

- StreamChecker(words): Constructor, init the data structure with the given words.
- query(letter): returns true if and only if for some k >= 1, the last k characters queried (in order from oldest to newest, including this letter just queried) spell one of the words in the given list.

 

Example:

StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // init the dictionary.
streamChecker.query('a');          // return false
streamChecker.query('b');          // return false
streamChecker.query('c');          // return false
streamChecker.query('d');          // return true, because 'cd' is in the wordlist
streamChecker.query('e');          // return false
streamChecker.query('f');          // return true, because 'f' is in the wordlist
streamChecker.query('g');          // return false
streamChecker.query('h');          // return false
streamChecker.query('i');          // return false
streamChecker.query('j');          // return false
streamChecker.query('k');          // return false
streamChecker.query('l');          // return true, because 'kl' is in the wordlist

 

Note:

    1 <= words.length <= 2000
    1 <= words[i].length <= 2000
    Words will only consist of lowercase English letters.
    Queries will only consist of lowercase English letters.
    The number of queries is at most 40000.

*/

class StreamChecker {
    TrieNode root = new TrieNode();
    StringBuilder sb = new StringBuilder();
    
    public StreamChecker(String[] words) {    
        for (String word : words){
            TrieNode curr = root;
            //append in reverse
            for (int i = word.length() - 1; i>= 0; i--){
                char ch = word.charAt(i);
                if(curr.children.containsKey(ch)){
                    curr = curr.children.get(ch);
                    continue;
                }
                curr.children.put(ch , new TrieNode());
                curr = curr.children.get(ch);
            }
            curr.isEnd = true;
        }
    }
    
    public boolean query(char letter) {
        //check reverse
        sb.append(letter);
        TrieNode curr = root;
        for (int i =sb.length() - 1; i >= 0 && curr != null; i--){
            char ch = sb.charAt(i);
            curr = curr.children.get(ch);
            if (curr != null && curr.isEnd)
                return true;
        }
        return false;
    }
}
class TrieNode{
    Map<Character,TrieNode> children;
    boolean isEnd;
    TrieNode(){
        children = new HashMap<>();
        isEnd = false;
    }
}
/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */

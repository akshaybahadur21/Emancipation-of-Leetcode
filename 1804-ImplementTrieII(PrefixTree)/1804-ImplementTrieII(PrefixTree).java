/*

1804. Implement Trie II (Prefix Tree)
Medium
271
14
Docusign

A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

    Trie() Initializes the trie object.
    void insert(String word) Inserts the string word into the trie.
    int countWordsEqualTo(String word) Returns the number of instances of the string word in the trie.
    int countWordsStartingWith(String prefix) Returns the number of strings in the trie that have the string prefix as a prefix.
    void erase(String word) Erases the string word from the trie.

Example 1:

Input
["Trie", "insert", "insert", "countWordsEqualTo", "countWordsStartingWith", "erase", "countWordsEqualTo", "countWordsStartingWith", "erase", "countWordsStartingWith"]
[[], ["apple"], ["apple"], ["apple"], ["app"], ["apple"], ["apple"], ["app"], ["apple"], ["app"]]
Output
[null, null, null, 2, 2, null, 1, 1, null, 0]

Explanation
Trie trie = new Trie();
trie.insert("apple");               // Inserts "apple".
trie.insert("apple");               // Inserts another "apple".
trie.countWordsEqualTo("apple");    // There are two instances of "apple" so return 2.
trie.countWordsStartingWith("app"); // "app" is a prefix of "apple" so return 2.
trie.erase("apple");                // Erases one "apple".
trie.countWordsEqualTo("apple");    // Now there is only one instance of "apple" so return 1.
trie.countWordsStartingWith("app"); // return 1
trie.erase("apple");                // Erases "apple". Now the trie is empty.
trie.countWordsStartingWith("app"); // return 0

Constraints:

    1 <= word.length, prefix.length <= 2000
    word and prefix consist only of lowercase English letters.
    At most 3 * 104 calls in total will be made to insert, countWordsEqualTo, countWordsStartingWith, and erase.
    It is guaranteed that for any function call to erase, the string word will exist in the trie.

*/

class Trie {
    TrieNode root;
    Map<String, Integer> map;
    public Trie() {
        root = new TrieNode();
        this.map = new HashMap<>();
    }
    
    public void insert(String word) {
        map.put(word, map.containsKey(word) ? map.get(word) + 1 : 1);
        TrieNode curr = root;
        for (int i = 0; i<word.length(); i++){
            char c = word.charAt(i);
            if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
                curr.wordCount++;
                continue;
            }
            curr.children.put(c,new TrieNode());
            curr = curr.children.get(c);
            curr.wordCount++;
        }
        curr.isEnd = true;
        
    }
    
    public int countWordsEqualTo(String word) {
        return map.containsKey(word) ? map.get(word) : 0;
    }
    
    public int countWordsStartingWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            if (!curr.children.containsKey(c))
                return 0;
            curr = curr.children.get(c);
        }
        return curr.wordCount;
    }
    
    public void erase(String word) {
        map.put(word, map.get(word) - 1);
        if(map.get(word) == 0) map.remove(word);
        TrieNode curr = root;
        for (int i = 0; i<word.length(); i++){
            char c = word.charAt(i);
            TrieNode child = curr.children.get(c);
            child.wordCount--;
            curr = curr.children.get(c);
        }
    }
}

class TrieNode{
    Map<Character, TrieNode> children;
    boolean isEnd;
    int wordCount;
    TrieNode(){
        this.children = new HashMap<>();
        this.isEnd = false;
        this.wordCount = 0;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */

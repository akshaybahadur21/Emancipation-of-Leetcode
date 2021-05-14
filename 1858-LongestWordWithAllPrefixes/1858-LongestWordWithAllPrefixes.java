/*

1858. Longest Word With All Prefixes
Medium

Given an array of strings words, find the longest string in words such that every prefix of it is also in words.

    For example, let words = ["a", "app", "ap"]. The string "app" has prefixes "ap" and "a", all of which are in words.

Return the string described above. If there is more than one string with the same length, return the lexicographically smallest one, and if no string exists, return "".

Example 1:

Input: words = ["k","ki","kir","kira", "kiran"]
Output: "kiran"
Explanation: "kiran" has prefixes "kira", "kir", "ki", and "k", and all of them appear in words.

Example 2:

Input: words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
Output: "apple"
Explanation: Both "apple" and "apply" have all their prefixes in words.
However, "apple" is lexicographically smaller, so we return that.

Example 3:

Input: words = ["abc", "bc", "ab", "qwe"]
Output: ""

Constraints:

    1 <= words.length <= 105
    1 <= words[i].length <= 105
    1 <= sum(words[i].length) <= 105

*/

class Solution {
    String longest = "";
    public String longestWord(String[] words) {
        // insert to trie. 
        // traverse trie to get the longest word
        Tnode root = new Tnode();
        for(String w : words){
            insertToTrie(root, w);
        }
        for(Map.Entry<Character, Tnode> entry : root.child.entrySet()) {
            dfs(entry.getValue(), ("" + entry.getKey()));
        }
        return this.longest;
    }
    
    private void dfs(Tnode root, String w){
        if(!root.isEnd) return;
        if(this.longest.length() < w.length() || (this.longest.length() == w.length() && this.longest.compareTo(w) > 0)) this.longest = w;
        for(Map.Entry<Character, Tnode> entry : root.child.entrySet()) {
            dfs(entry.getValue(), (w + entry.getKey()));
        }
    }
    
    private void insertToTrie(Tnode root, String w){
        Tnode temp = root;
        for(char ch : w.toCharArray()){
            if(!temp.child.containsKey(ch))
                temp.child.put(ch, new Tnode());
            temp = temp.child.get(ch);
        }
        temp.isEnd = true;
    }
}
class Tnode{
    Map<Character, Tnode> child;
    boolean isEnd;
    Tnode(){
        this.child = new HashMap<>();
        this.isEnd = false;
    }
}

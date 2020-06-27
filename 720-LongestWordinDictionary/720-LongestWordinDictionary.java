/*

720. Longest Word in Dictionary
Easy

Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order.
If there is no answer, return the empty string.

Example 1:

Input: 
words = ["w","wo","wor","worl", "world"]
Output: "world"
Explanation: 
The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".

Example 2:

Input: 
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
Output: "apple"
Explanation: 
Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".

Note:
All the strings in the input will only contain lowercase letters.
The length of words will be in the range [1, 1000].
The length of words[i] will be in the range [1, 30].

*/

class Solution {
    Tnode root = new Tnode();
    StringBuilder sb = new StringBuilder();
    int max = 0;
    public String longestWord(String[] words) {
        if(words == null || words.length == 0) return "";
        Arrays.sort(words, (w1, w2) -> w1.length() != w2.length() ? w1.length() - w2.length() : w1.compareTo(w2));
        for(String w : words)
            addToTrie(w);
        return sb.toString();
    }
    
    private void addToTrie(String w){
        Tnode temp = root;
        for(int i = 0; i < w.length(); i++){
            char ch = w.charAt(i);
            if (!temp.children.containsKey(w.charAt(i)) && i != w.length() - 1) return;
            if (!temp.children.containsKey(w.charAt(i)))
                temp.children.put(ch, new Tnode());
            temp = temp.children.get(ch);
        }
        temp.isEnd = true;
        if(w.length() > max){
            sb = new StringBuilder(w);
            max = w.length();
        }
    }
}

class Tnode{
    Map<Character, Tnode> children;
    boolean isEnd;
    Tnode(){
        this.children = new HashMap<>();
        isEnd = false;
    }
}

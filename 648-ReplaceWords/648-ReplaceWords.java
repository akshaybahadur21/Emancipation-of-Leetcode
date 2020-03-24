/*
648. Replace Words
Medium

In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.

Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.

You need to output the sentence after the replacement.

Example 1:

Input: dict = ["cat", "bat", "rat"]
sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"

 

Note:

    The input will only have lower-case letters.
    1 <= dict words number <= 1000
    1 <= sentence words number <= 1000
    1 <= root length <= 100
    1 <= sentence words length <= 1000
*/

class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        //create a set for dict and interate over all the words in a sentence to replace
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();
        for(String s : dict)
            set.add(s);
        String[] sentences = sentence.split(" ");
        for (String word : sentences){
            String prefix = "";
            for (int i = 1; i <= word.length(); i++) {
                prefix = word.substring(0, i);
                if (set.contains(prefix)) break;
            }
            sb.append(" " + prefix);
        }
        return sb.deleteCharAt(0).toString();
    }
}

class Solution {
    TrieNode root;
    public String replaceWords(List<String> dict, String sentence) {
        //Approach
        // create a trie with all dict values and traverse while iterating through sentence
        StringBuilder sb = new StringBuilder();
        root = new TrieNode();
        for(String s : dict){
            trieInsert(s);
        }
        String[] sentences = sentence.split(" ");
        for(String s : sentences){
            String search = searchTrie(s);
            sb.append(" ").append(search);
        }
        return sb.deleteCharAt(0).toString();
        
    }
    
    private String searchTrie(String word){
        StringBuilder tempsb = new StringBuilder();
        TrieNode curr = root;
         for(int i = 0; i < word.length(); i++){
             char ch = word.charAt(i);
             tempsb.append(ch);
             TrieNode node = curr.children.get(ch);
             if (node == null)
                 return word;
             if(node.isEnd)
                 return tempsb.toString();
             curr = curr.children.get(ch);
         }
        return word;
    }
    
    private void trieInsert(String word){
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
           if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
                continue;
            }
            curr.children.put(c,new TrieNode());
            curr = curr.children.get(c);
        }
        curr.isEnd = true;
    }
}
class TrieNode{
    Map<Character, TrieNode> children;
    boolean isEnd;
    TrieNode(){
        children = new HashMap<>();
        isEnd = false;
    }
}

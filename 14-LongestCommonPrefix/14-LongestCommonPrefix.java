/*

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Question Link : https://leetcode.com/problems/longest-common-prefix/

*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)
            return "";
        if (strs.length==1)
            return strs[0].toString();
            
        boolean flag=false;
        StringBuilder sb = new StringBuilder();
        
        Arrays.sort(strs, (a, b)->Integer.compare(a.length(), b.length()));
        
        for(int i=0;i<strs[0].length();i++)
        {
            for(int j=1;j<strs.length;j++)
            {
                if (strs[0].charAt(i)==strs[j].charAt(i))
                    flag=true;
                else
                {
                    flag =false;
                    i=strs[0].length();
                    break;
                }
            }
            if (flag==true)
                    sb.append(strs[0].charAt(i));            
        }

        return sb.toString();
        
    }
}


// Trie Approach

class Solution {
    public String longestCommonPrefix(String[] strs) {
        TrieNode root = new TrieNode();
        TrieNode node = root;
        insertInTrie(strs[0], node);
        int res = strs[0].length();
        for(int i = 1; i < strs.length; i++){
            node = root;
            int curr = search(node, strs[i]);
            if(curr == 0) return "";
            res = Math.min(res, curr);
        }
        return res == 0 ? "" : strs[0].substring(0, res);
    }

    private int search(TrieNode node, String word){
        int res = 0;
        for(char ch : word.toCharArray()){
            if(!node.children.containsKey(ch)) return res;
            res++;
            node = node.children.get(ch);
        }
        return res;
    }

    private void insertInTrie(String word, TrieNode node){
        for(char ch : word.toCharArray()){
            if(!node.children.containsKey(ch)) node.children.put(ch, new TrieNode());
            node = node.children.get(ch);
        }
    }
}

class TrieNode{
    Map<Character, TrieNode> children;
    TrieNode(){
        this.children = new HashMap<>();
    }
}

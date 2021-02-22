/*

524. Longest Word in Dictionary through Deleting
Medium

Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

Example 1:

Input:
s = "abpcplea", d = ["ale","apple","monkey","plea"]

Output: 
"apple"

Example 2:

Input:
s = "abpcplea", d = ["a","b","c"]

Output: 
"a"

Note:

    All the strings in the input will only contain lower-case letters.
    The size of the dictionary won't exceed 1,000.
    The length of all the strings in the input won't exceed 1,000.

*/

class Solution {
    public String findLongestWord(String s, List<String> d) {
       String res = "";
       for(String w: d){
         if(isSubsequence(w, s)){
           if(w.length() > res.length()) res = w; 
           if(w.length() == res.length() && w.compareTo(res) < 0) res = w;  
         }  
       }    
       return res;
    }
    
    boolean isSubsequence(String w, String s){
      char[] wc = w.toCharArray();
      char[] sc = s.toCharArray();
      int i = 0, j = 0;
      while(i < wc.length && j < sc.length){
        if(wc[i] == sc[j]) i++;
        j++;    
      }  
      return i == wc.length;  
    }
}

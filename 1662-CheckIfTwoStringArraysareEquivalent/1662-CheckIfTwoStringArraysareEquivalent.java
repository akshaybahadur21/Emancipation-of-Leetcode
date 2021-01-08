/*

1662. Check If Two String Arrays are Equivalent
Easy

Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.

A string is represented by an array if the array elements concatenated in order forms the string.

Example 1:

Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
Output: true
Explanation:
word1 represents string "ab" + "c" -> "abc"
word2 represents string "a" + "bc" -> "abc"
The strings are the same, so return true.

Example 2:

Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
Output: false

Example 3:

Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
Output: true

Constraints:

    1 <= word1.length, word2.length <= 103
    1 <= word1[i].length, word2[i].length <= 103
    1 <= sum(word1[i].length), sum(word2[i].length) <= 103
    word1[i] and word2[i] consist of lowercase letters.

*/

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        // Brute force
        // combine w1 array and w2 array respectively
        // compare both the sb
        if(word1 == null && word2 == null) return true;
        if(!validateInput(word1, word2)) return false;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(String w : word1) sb1.append(w);
        for(String w : word2) sb2.append(w);
        return sb1.toString().equals(sb2.toString());
    }
    private boolean validateInput(String[] w1, String[] w2){
        if(w1 == null || w2 == null || w1.length == 0 && w2.length != 0 || w1.length != 0 && w2.length == 0 ) return false;
        return true;
    }
}

/*

72. Edit Distance
Hard

Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

    Insert a character
    Delete a character
    Replace a character

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')

Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')

*/

class Solution {
    public int minDistance(String word1, String word2) {
        Integer[][] cache = new Integer[word1.length()][word2.length()];
        return dfs(cache, word1, word2, 0, 0);
    }
    private int dfs(Integer[][] cache, String word1, String word2, int i1, int i2) {
        if(i1 == word1.length()) return word2.length() - i2;
        if(i2 == word2.length()) return word1.length() - i1;
        if(cache[i1][i2] != null) return cache[i1][i2];
        if(word1.charAt(i1) == word2.charAt(i2)) {
            cache[i1][i2] = dfs(cache, word1, word2, i1 + 1, i2 + 1);
            return cache[i1][i2];
        }
        cache[i1][i2] = 1 + Math.min(Math.min(dfs(cache, word1, word2, i1, i2 + 1), dfs(cache, word1, word2, i1 + 1, i2)), dfs(cache, word1, word2, i1 + 1, i2 + 1));
        return cache[i1][i2];
    }
}

class Solution {
    public int minDistance(String word1, String word2) {
        return dfs(word1, word2, word1.length(), word2.length());
    }
    private int dfs(String word1, String word2, int l1, int l2) {
        if(l1 == 0) return l2;
        if(l2 == 0) return l1;
        if(word1.charAt(l1 - 1) == word2.charAt(l2 - 1)) return dfs(word1, word2, l1 - 1, l2 - 1);
        return 1 + Math.min(Math.min(dfs(word1, word2, l1, l2 - 1), dfs(word1, word2, l1 - 1, l2)), dfs(word1, word2, l1 - 1, l2 - 1));
    }
}

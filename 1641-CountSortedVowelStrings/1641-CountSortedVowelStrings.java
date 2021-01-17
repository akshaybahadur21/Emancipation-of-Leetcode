/*

1641. Count Sorted Vowel Strings
Medium

Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.

A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.

Example 1:

Input: n = 1
Output: 5
Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i","o","u"].

Example 2:

Input: n = 2
Output: 15
Explanation: The 15 sorted strings that consist of vowels only are
["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet.

Example 3:

Input: n = 33
Output: 66045

Constraints:

    1 <= n <= 50 

*/

class Solution {
    public int countVowelStrings(int n) {
        char[] chArr = new char[]{'a', 'e', 'i', 'o', 'u'};
        int[] res = new int[]{0};
        dfs(n, chArr, res, 0, new StringBuilder());
        return res[0];
    }
    private void dfs(int n, char[] chArr, int[] res, int idx, StringBuilder sb){
        if(sb.length() == n) res[0]++;
        if(sb.length() > n) return;
        for(int i = idx; i < chArr.length; i++){
            sb.append(chArr[i]);
            dfs(n, chArr, res, i, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

/*

680. Valid Palindrome II
Easy

Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:

Input: "aba"
Output: True

Example 2:

Input: "abca"
Output: True
Explanation: You could delete the character 'c'.

Note:

    The string will only contain lowercase characters a-z. The maximum length of the string is 50000.

*/

class Solution {
    public boolean validPalindrome(String s) {
        boolean canSkip = true;
        for(int i = 0, j = s.length() - 1; j - i >= 1; ){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
                continue;
            }
            else
                return isPalindrome(i + 1, j, s) || isPalindrome(i, j - 1, s);
        }
        return true;
    }
    private boolean isPalindrome(int i, int j, String s){
        while(j - i >= 1){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
        
    }
}

/*

125. Valid Palindrome
Easy

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true

Example 2:

Input: "race a car"
Output: false

Link : 

*/

class Solution {
    public boolean isPalindrome(String s) {
        String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int i = 0;
        int j = str.length()-1;
        while(j-i >= 1){
            if (str.charAt(i++) != str.charAt(j--))
                return false;
        }
        return true;
    }
}

/*

2108. Find First Palindromic String in the Array
Easy

Given an array of strings words, return the first palindromic string in the array. If there is no such string, return an empty string "".

A string is palindromic if it reads the same forward and backward.

Example 1:

Input: words = ["abc","car","ada","racecar","cool"]
Output: "ada"
Explanation: The first string that is palindromic is "ada".
Note that "racecar" is also palindromic, but it is not the first.

Example 2:

Input: words = ["notapalindrome","racecar"]
Output: "racecar"
Explanation: The first and only string that is palindromic is "racecar".

Example 3:

Input: words = ["def","ghi"]
Output: ""
Explanation: There are no palindromic strings, so the empty string is returned.

Constraints:

    1 <= words.length <= 100
    1 <= words[i].length <= 100
    words[i] consists only of lowercase English letters.

*/

class Solution {
    public String firstPalindrome(String[] words) {
        if(words == null || words.length == 0) return "";
        for(String s : words){
            if(isPalin(s)) return s;
        }
        return "";
    }
    private boolean isPalin(String s){
        char[] arr = s.toCharArray();
        int lo = 0, hi = arr.length - 1;
        while(lo < hi){
            if(arr[lo++] != arr[hi--]) return false;
        }
        return true;
    }
}

/*

Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.

 

Example 1:

Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

Example 2:

Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]

Link : https://leetcode.com/problems/reverse-string/

*/

class Solution {
    public void reverseString(char[] s) {
        
        int f=0;
        int l =s.length-1;
        while(f<=l)
        {
            char c= s[f];
            s[f]= s[l];
            s[l] =c;
            f++;
            l--;
            
        }
    }
}

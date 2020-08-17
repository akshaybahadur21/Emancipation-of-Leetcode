/*

186. Reverse Words in a String II
Medium

Given an input string , reverse the string word by word. 

Example:

Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]

Note: 

    A word is defined as a sequence of non-space characters.
    The input string does not contain leading or trailing spaces.
    The words are always separated by a single space.

Follow up: Could you do it in-place without allocating extra space?

*/

class Solution {
    public void reverseWords(char[] s) {
        // reverse the string
        //reverse each word
        // reverse the last word (corner case)
       reverse(s, 0, s.length - 1);
        int start = 0;
        for(int i = 0; i < s.length; i++){
            if(s[i] == ' '){
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
    reverse(s, start, s.length - 1);
    }
    private void reverse(char[] s, int lo, int hi){
        while(lo < hi){
            char temp = s[lo];
            s[lo++] = s[hi];
            s[hi--] = temp;
        }
    }
}

/*

171. Excel Sheet Column Number
Easy

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...

Example 1:

Input: "A"
Output: 1

Example 2:

Input: "AB"
Output: 28

Example 3:

Input: "ZY"
Output: 701

Link : https://leetcode.com/problems/excel-sheet-column-number/submissions/

*/

class Solution {
    public int titleToNumber(String s) {
        int ans =0;
        for (int i =0; i<s.length(); i++){
            ans *= 26;
            ans += (s.charAt(i) - 'A') +1;
        }
        return ans;
    }
}

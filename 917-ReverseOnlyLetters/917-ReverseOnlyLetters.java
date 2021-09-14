/*

917. Reverse Only Letters
Easy

Given a string s, reverse the string according to the following rules:

    All the characters that are not English letters remain in the same position.
    All the English letters (lowercase or uppercase) should be reversed.

Return s after reversing it.

Example 1:

Input: s = "ab-cd"
Output: "dc-ba"

Example 2:

Input: s = "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"

Example 3:

Input: s = "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"

Constraints:

    1 <= s.length <= 100
    s consists of characters with ASCII values in the range [33, 122].
    s does not contain '\"' or '\\'.

*/


class Solution {
    public String reverseOnlyLetters(String s) {
        // 2 pointers
        char[] arr = s.toCharArray();
        int lo = 0, hi = arr.length - 1;
        while(lo <= hi) {
            while(lo < hi && !Character.isLetter(arr[lo])) lo++;
            while(lo < hi && ! Character.isLetter(arr[hi])) hi--;
            char temp = arr[lo];
            arr[lo++] = arr[hi];
            arr[hi--] = temp;
        }
        return String.valueOf(arr);
    }
}

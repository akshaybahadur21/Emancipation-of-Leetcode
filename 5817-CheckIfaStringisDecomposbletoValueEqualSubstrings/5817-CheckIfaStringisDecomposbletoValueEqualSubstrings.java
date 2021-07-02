/*

5817. Check If a String is Decomposble to Value-Equal Substrings
Easy

A value-equal string is a string where all characters are equal.

    For example, "1111" and "33" are value-equal strings.
    In contrast, "123" is not a value-equal string.

Given a numeric string s, decompose the string into some consecutive value-equal substrings where all substrings except for exactly one has a size of three and the wild substring has a size of two.

Return true if you can decompose s according to the above rules otherwise, return false.

A substring is a contiguous sequence of characters in a string.

Example 1:

Input: s = "000111000"
Output: false
Explanation: s can be only decomposed to substrings of size three here.

Example 2:

Input: s = "00011111222"
Output: true
Explanation: s can be decomposed to ["000","111","11","222"].

Example 3:

Input: s = "01110002223300"
Output: false
Explanation: One of the reasons s can't be decomposed here is because there will be a leftover 0 at the beginning.

Constraints:

    1 <= s.length <= 1000
    s consists of only digits.

*/

class Solution {
    public boolean isDecomposable(String s) {
        int three = 0, two = 0, curr = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.containsKey(s.charAt(i)) ? map.get(s.charAt(i)) + 1 : 1);
            if(i + 1 < s.length() && s.charAt(i + 1) != s.charAt(i)){
                curr = map.get(s.charAt(i));
                if(curr == 3){
                    three++;
                    map.remove(s.charAt(i));
                }
                else if(curr == 2){
                    two++;
                    map.remove(s.charAt(i));
                }
                else return false;
            }
            if(i + 1 < s.length() && s.charAt(i + 1) == s.charAt(i)){
                curr = map.get(s.charAt(i));
                if(curr == 3){
                    three++;
                    map.remove(s.charAt(i));
                }
            }
        }
        if(map.get(s.charAt(s.length() - 1)) == 2) two++;
        else if(map.get(s.charAt(s.length() - 1)) == 3) three++;
        else return false;
        return two == 1 && three >= 0;
    }
}

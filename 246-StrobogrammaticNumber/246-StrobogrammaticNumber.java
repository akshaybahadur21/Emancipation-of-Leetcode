/*

246. Strobogrammatic Number
Easy

Given a string num which represents an integer, return true if num is a strobogrammatic number.

A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Example 1:

Input: num = "69"
Output: true

Example 2:

Input: num = "88"
Output: true

Example 3:

Input: num = "962"
Output: false

Example 4:

Input: num = "1"
Output: true

Constraints:

    1 <= num.length <= 50
    num consists of only digits.
    num does not contain any leading zeros except for zero itself.

*/

class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('6','9');
        map.put('9','6');
        map.put('8','8');
        map.put('1','1');
        map.put('0','0');
        StringBuilder sb = new StringBuilder();
        for(char ch : num.toCharArray()){
            if(!map.containsKey(ch)) return false;
            sb.insert(0, map.get(ch));
        }
        return num.equals(sb.toString());
    }
}

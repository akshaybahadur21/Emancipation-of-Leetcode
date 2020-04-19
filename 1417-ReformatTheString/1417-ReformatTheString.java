/*

1417. Reformat The String
Easy

Given alphanumeric string s. (Alphanumeric string is a string consisting of lowercase English letters and digits).

You have to find a permutation of the string where no letter is followed by another letter and no digit is followed by another digit. That is, no two adjacent characters have the same type.

Return the reformatted string or return an empty string if it is impossible to reformat the string.

Example 1:

Input: s = "a0b1c2"
Output: "0a1b2c"
Explanation: No two adjacent characters have the same type in "0a1b2c". "a0b1c2", "0a1b2c", "0c2a1b" are also valid permutations.

Example 2:

Input: s = "leetcode"
Output: ""
Explanation: "leetcode" has only characters so we cannot separate them by digits.

Example 3:

Input: s = "1229857369"
Output: ""
Explanation: "1229857369" has only digits so we cannot separate them by characters.

Example 4:

Input: s = "covid2019"
Output: "c2o0v1i9d"

Example 5:

Input: s = "ab123"
Output: "1a2b3"

 

Constraints:

    1 <= s.length <= 500
    s consists of only lowercase English letters and/or digits.

*/

class Solution {
    public String reformat(String s) {
        StringBuilder sb = new StringBuilder();
        Queue<Character> letSet = new LinkedList<>();
        Queue<Character> digSet = new LinkedList<>();
        for(int i =0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9')
                digSet.add(ch);
            else
                letSet.add(ch);
        }
        if(Math.abs(letSet.size() - digSet.size()) > 1) return sb.toString();
        Queue<Character> big = letSet;
        Queue<Character> small = digSet;
        if ( letSet.size() != digSet.size()){
            big = letSet.size() > digSet.size() ? letSet : digSet; 
            small = letSet.size() > digSet.size() ? digSet : letSet;
        }

        while(!big.isEmpty() && !small.isEmpty()){
            char bigCh = big.poll();
            char smallCh = small.poll();
            sb.append(bigCh).append(smallCh);
        }
        if (!big.isEmpty()) sb.append(big.poll());
        return sb.toString();
    }
}

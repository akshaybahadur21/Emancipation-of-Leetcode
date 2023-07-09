/*

159. Longest Substring with At Most Two Distinct Characters
Medium

Given a string s, return the length of the longest substring that contains at most two distinct characters.

Example 1:

Input: s = "eceba"
Output: 3
Explanation: The substring is "ece" which its length is 3.

Example 2:

Input: s = "ccaabbb"
Output: 5
Explanation: The substring is "aabbb" which its length is 5.

Constraints:

    1 <= s.length <= 105
    s consists of English letters.

*/

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        int res = 0, i = 0;
        while(i < s.length()){
            char curr = s.charAt(i++);
            q.add(curr);
            map.put(curr, map.containsKey(curr) ? map.get(curr) + 1 : 1);
            while(map.size() > 2){
                char qu = q.poll();
                map.put(qu, map.get(qu) - 1);
                if(map.get(qu) == 0) map.remove(qu);
            }
            res = Math.max(res, q.size());
        }
        res = Math.max(res, q.size());
        return res;
    }
}

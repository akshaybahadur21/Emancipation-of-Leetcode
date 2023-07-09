/*

340. Longest Substring with At Most K Distinct Characters
Medium

Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters.

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: The substring is "ece" with length 3.

Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: The substring is "aa" with length 2.

Constraints:

    1 <= s.length <= 5 * 104
    0 <= k <= 50

*/

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        //sliding window
        int[] map = new int[256];
        int lo = 0, hi = 0, count = 0, max = 0;
        for(hi = 0; hi < s.length(); hi++){
            if(map[s.charAt(hi)]++ == 0){
                count++;
            }
            while(count > k && lo < s.length()){
                map[s.charAt(lo)]--;
                if (map[s.charAt(lo)] == 0) count--;
                lo++;
            }
            max = Math.max(max, hi - lo + 1);
        }
        return max;
    }
}

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        int res = 0, i = 0;
        while(i < s.length()){
            char curr = s.charAt(i++);
            q.add(curr);
            map.put(curr, map.containsKey(curr) ? map.get(curr) + 1 : 1);
            while(map.size() > k){
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

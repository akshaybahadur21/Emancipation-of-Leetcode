
/*

Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 

Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

Question : https://leetcode.com/problems/longest-substring-without-repeating-characters/

*/


class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> posMap = new HashMap<>();
        int i=0;
        int flag=0;
        int ans=0;
        while(i<s.length())
        {
            if (posMap.containsKey(s.charAt(i)))
                flag=Math.max(posMap.get(s.charAt(i)),flag);
            ans=Math.max(ans, i-flag+1);
            posMap.put(s.charAt(i),i+1);
            i++;
            
        }
        return ans;
}
}

/*

1456. Maximum Number of Vowels in a Substring of Given Length
Medium

Given a string s and an integer k.

Return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are (a, e, i, o, u).

Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.

Example 2:

Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.

Example 3:

Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.

Example 4:

Input: s = "rhythms", k = 4
Output: 0
Explanation: We can see that s doesn't have any vowel letters.

Example 5:

Input: s = "tryhard", k = 4
Output: 1

 

Constraints:

    1 <= s.length <= 10^5
    s consists of lowercase English letters.
    1 <= k <= s.length

*/

class Solution {
    public int maxVowels(String s, int k) {
        int res = 0;
        int max = 0;
        if(!validateInput(s,k)) return res;
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        for(int i = 0; i <k; i++){
            if(set.contains(s.charAt(i)))
                res++;
        }
        max = res;
        //sliding window
        for(int i = k; i < s.length(); i++){
            if(set.contains(s.charAt(i - k)))
                res--;
            if(set.contains(s.charAt(i)))
                res++;
            max = Math.max(res, max);
        }
        return Math.max(res, max);
    }
    private boolean validateInput(String s, int k){
        if(s == null || s.length() == 0 || k == 0 )
            return false;
        return true;
    }
}

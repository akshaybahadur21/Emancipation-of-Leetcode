/*

242. Valid Anagram
Easy

Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true

Example 2:

Input: s = "rat", t = "car"
Output: false

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?


*/

// 2 HashMaps

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        Map<Character,Integer> lookupMap1 = new HashMap<>();
        Map<Character,Integer> lookupMap2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++){
            
            lookupMap1.put(s.charAt(i), lookupMap1.containsKey(s.charAt(i)) ? lookupMap1.get(s.charAt(i)) + 1 : 1);
            lookupMap2.put(t.charAt(i), lookupMap2.containsKey(t.charAt(i)) ? lookupMap2.get(t.charAt(i)) + 1 : 1);
            
        }
        if (lookupMap1.equals(lookupMap2))
            return true;
        return false;
    }
}

//Sort toCharArray

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        char[] c1= s.toCharArray();
        char[] c2= t.toCharArray();
        
        Arrays.sort(c1);
        Arrays.sort(c2);
        
        for (int i=0;i<s.length();i++){
            if (c1[i]!=c2[i])
                return false;
        }
        return true;
    }
}

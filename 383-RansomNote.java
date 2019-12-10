/*

383. Ransom Note
Easy

Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true

Link : https://leetcode.com/problems/ransom-note/submissions/

*/

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        Map <Character, Integer> magazineMap = createMap(magazine);
        Map <Character, Integer> ransomMap = createMap(ransomNote);
        return checkEqualMap (magazineMap, ransomMap);
        
    }
    
    private Map createMap (String str){
        Map <Character, Integer> map = new HashMap<>();
        for (int i =0 ; i<str.length() ; i++)
            map.put(str.charAt(i),map.containsKey(str.charAt(i)) ?map.get(str.charAt(i)) + 1 : 1);
        return map;
    }
    
    private boolean checkEqualMap(Map <Character, Integer> magazineMap, Map <Character, Integer> ransomMap){
        for (Map.Entry<Character, Integer> entry : ransomMap.entrySet()){
            char key = entry.getKey();
            int value = entry.getValue();
            if (magazineMap.get(key) == null)
                return false;
            if (magazineMap.get(key) < value)
                return false;
        }
        return true;
    }
    
}

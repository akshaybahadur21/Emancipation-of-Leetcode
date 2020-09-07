/*

205. Isomorphic Strings
Easy

Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true

Example 2:

Input: s = "foo", t = "bar"
Output: false

Example 3:

Input: s = "paper", t = "title"
Output: true

Note:
You may assume both s and t have the same length.

*/

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(!validateInput(s, t)) return false;
        Map<Character, List<Integer>> map = new LinkedHashMap<>();
        char sArr[] = s.toCharArray();
        char tArr[] = t.toCharArray();
        for(int i = 0; i < sArr.length; i++){
            if(map.containsKey(sArr[i])) map.get(sArr[i]).add(i);
            else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(sArr[i], list);
            }
        }
        Set<Character> vis = new HashSet<>();
        for(Map.Entry<Character, List<Integer>> entry : map.entrySet()){
            List<Integer> list = entry.getValue();
            for(int i = 0; i < list.size() - 1; i++){
                if(tArr[list.get(i)] != tArr[list.get(i + 1)]) return false;
            }
            if(vis.contains(tArr[list.get(0)])) return false;
            vis.add(tArr[list.get(0)]);
        }
        return true;
    }
    private boolean validateInput(String s, String t){
        if(s == null || t == null || s.length() != t.length()) return false;
        return true;
    }
}

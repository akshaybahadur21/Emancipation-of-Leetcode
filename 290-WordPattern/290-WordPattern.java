/*

290. Word Pattern
Easy

Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true

Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false

Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false

Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false

Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.

*/

class Solution {
    public boolean wordPattern(String pattern, String str) {
        if(!validateInput(pattern, str)) return false;
        LinkedHashMap<Character, List<Integer>> map = new LinkedHashMap<>();
        for(int i = 0; i < pattern.length(); i++){
            char ch = pattern.charAt(i);
            if(map.containsKey(ch)) map.get(ch).add(i);
            else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(ch, list);
            }
        }
        String[] arr = str.split(" ");
        Set<String> vis = new HashSet<>();
        for(Map.Entry<Character, List<Integer>> entry : map.entrySet()){
            List<Integer> list = entry.getValue();
            for(int i = 0; i < list.size() - 1; i++){
                if(!arr[list.get(i)].equals(arr[list.get(i + 1)]) || vis.contains(arr[list.get(i)])) return false;
            }
            if(vis.contains(arr[list.get(0)])) return false;
            vis.add(arr[list.get(0)]);
        }
           return true;
    }
    private boolean validateInput(String pattern, String str) {
        if(pattern == null || str == null || pattern.length() != str.split(" ").length || pattern.length() > 0 && str.length() == 0) return false;
        return true;
    }
}

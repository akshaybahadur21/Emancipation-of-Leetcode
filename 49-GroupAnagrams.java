/*

49. Group Anagrams
Medium

Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

Note:

    All inputs will be in lowercase.
    The order of your output does not matter.

Link :

*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> lookupMap = new HashMap<>();
        List<List<String>> resultList = new ArrayList<>();
        for (String str:strs){
            char tempArray[] = str.toCharArray();
            Arrays.sort(tempArray);
            if (lookupMap.containsKey(new String(tempArray))){
                lookupMap.get(new String(tempArray)).add(str);
            }
            else{
                List<String> tempList = new ArrayList<>();
                tempList.add(str);
                lookupMap.put(new String(tempArray),tempList);
            }
        }
        for(Map.Entry<String,List<String>> entry : lookupMap.entrySet()){
                resultList.add(entry.getValue());
            }
        return resultList;
    }
}

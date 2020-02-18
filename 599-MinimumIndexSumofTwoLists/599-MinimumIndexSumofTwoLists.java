/*
599. Minimum Index Sum of Two Lists
Easy

Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

Example 1:

Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".

Example 2:

Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).

Note:

    The length of both lists will be in the range of [1, 1000].
    The length of strings in both lists will be in the range of [1, 30].
    The index is starting from 0 to the list length minus 1.
    No duplicates in both lists.

*/
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> lookupMap = new HashMap<>();
        Map<Integer, List<String>> resMap = new TreeMap<>();
        //create a map for word and it's index
        for(int i =0; i<list1.length; i++){
            lookupMap.put(list1[i],i);
        }
        for (int i = 0; i<list2.length; i++){
            if (lookupMap.containsKey(list2[i])){
                if (resMap.containsKey(i + lookupMap.get(list2[i]))){
                    resMap.get(i + lookupMap.get(list2[i])).add(list2[i]);
                }
                else{
                    resMap.put(i + lookupMap.get(list2[i]), new ArrayList<String>());
                    resMap.get(i + lookupMap.get(list2[i])).add(list2[i]);
                }
            }
        }
        int check = Integer.MAX_VALUE;
        for(Map.Entry<Integer, List<String>> entry : resMap.entrySet()){
            if (entry.getKey() <= check){
                check = entry.getKey();
                res.addAll(entry.getValue());
            }
        }
        return res.toArray(new String[res.size()]);
    }
}

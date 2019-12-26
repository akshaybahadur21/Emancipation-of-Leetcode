/*

451. Sort Characters By Frequency
Medium

Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.

Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.

Link : https://leetcode.com/problems/sort-characters-by-frequency/

*/

class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> lookupMap = new HashMap<>();
        for (int i=0;i<s.length();i++)
            lookupMap.put(s.charAt(i),lookupMap.containsKey(s.charAt(i))?lookupMap.get(s.charAt(i))+1:1);
        
        Queue<Character> heap = new PriorityQueue<>((n1,n2)->lookupMap.get(n2)-lookupMap.get(n1));
        for (Map.Entry<Character, Integer> entry: lookupMap.entrySet())
           heap.add(entry.getKey());
           
        StringBuilder sb = new StringBuilder();
        while(!heap.isEmpty()){
            char c = heap.poll();
            for (int i =0;i<lookupMap.get(c);i++)
                sb.append(c);
        }
        return sb.toString();
        
    }
}

/*

358. Rearrange String k Distance Apart
Hard
Given a non-empty string s and an integer k, rearrange the string such that the same characters are at least distance k from each other.

All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".

Example 1:

Input: s = "aabbcc", k = 3
Output: "abcabc" 
Explanation: The same letters are at least distance 3 from each other.
Example 2:

Input: s = "aaabc", k = 3
Output: "" 
Explanation: It is not possible to rearrange the string.
Example 3:

Input: s = "aaadbbcc", k = 2
Output: "abacabcd"
Explanation: The same letters are at least distance 2 from each other.

*/

class Solution {
    public String rearrangeString(String s, int k) {
        Map<Character, Integer> countMap = new HashMap<>();
        Queue<Character> heap = new PriorityQueue<>((n1, n2) -> countMap.get(n2) == countMap.get(n1) ? n1.compareTo(n2) : countMap.get(n2) - countMap.get(n1));
        Queue<Character> waitHeap = new LinkedList<>();
        Map<Character, Integer> posMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            countMap.put(ch, countMap.containsKey(ch) ? countMap.get(ch) + 1 : 1);
        }
        heap.addAll(countMap.keySet());
        while(!heap.isEmpty()){
            char ch = heap.poll();
            sb.append(ch);
            countMap.put(ch, countMap.get(ch) - 1);
            waitHeap.add(ch);
            
            if(waitHeap.size() < k) continue;
            
            ch = waitHeap.poll();
            if(countMap.get(ch) > 0)
                heap.add(ch);
        }
        
        return sb.length() == s.length() ? sb.toString() : "";
    }
}

/*

846. Hand of Straights

Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.

Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.

Example 1:

Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]

Example 2:

Input: hand = [1,2,3,4,5], groupSize = 4
Output: false
Explanation: Alice's hand can not be rearranged into groups of 4.

Constraints:

    1 <= hand.length <= 104
    0 <= hand[i] <= 109
    1 <= groupSize <= hand.length

Note: This question is the same as 1296: https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/

*/

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0 ) return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int h : hand) map.put(h, map.containsKey(h) ? map.get(h) + 1 : 1 );
        while(map.size() != 0){
            int currentCard = map.entrySet().iterator().next().getKey();
            for(int i = 0; i < groupSize; i++){
                int key = currentCard + i;
                if(!map.containsKey(key)) return false;
                map.put(key, map.get(key) - 1);
                if(map.get(key) == 0) map.remove(key);
            }
        }
        return true;
    }
}

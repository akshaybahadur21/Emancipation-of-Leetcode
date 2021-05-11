/*

432. All O`one Data Structure
Hard

Design a data structure to store the strings' count with the ability to return the strings with minimum and maximum counts.

Implement the AllOne class:

    AllOne() Initializes the object of the data structure.
    inc(String key) Increments the count of the string key by 1. If key does not exist in the data structure, insert it with count 1.
    dec(String key) Decrements the count of the string key by 1. If the count of key is 0 after the decrement, remove it from the data structure. It is guaranteed that key exists in the data structure before the decrement.
    getMaxKey() Returns one of the keys with the maximal count. If no element exists, return an empty string "".
    getMinKey() Returns one of the keys with the minimum count. If no element exists, return an empty string "".

Example 1:

Input
["AllOne", "inc", "inc", "getMaxKey", "getMinKey", "inc", "getMaxKey", "getMinKey"]
[[], ["hello"], ["hello"], [], [], ["leet"], [], []]
Output
[null, null, null, "hello", "hello", null, "hello", "leet"]

Explanation
AllOne allOne = new AllOne();
allOne.inc("hello");
allOne.inc("hello");
allOne.getMaxKey(); // return "hello"
allOne.getMinKey(); // return "hello"
allOne.inc("leet");
allOne.getMaxKey(); // return "hello"
allOne.getMinKey(); // return "leet"

 

Constraints:

    1 <= key.length <= 10
    key consists of lowercase English letters.
    It is guaranteed that for each call to dec, key is existing in the data structure.
    At most 3 * 104 calls will be made to inc, dec, getMaxKey, and getMinKey.

Follow up: Could you apply all the operations in O(1) time complexity?

*/


class AllOne {

    /** Initialize your data structure here. */
    Map<String, Integer> map;
    Queue<String> maxHeap;
    Queue<String> minHeap;
    public AllOne() {
        this.map = new HashMap<>();
        this.maxHeap = new PriorityQueue<>((n1, n2) -> map.get(n2) - map.get(n1));
        this.minHeap = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(!map.containsKey(key)) return;
        map.put(key, map.get(key) - 1);
        if(map.get(key) == 0) map.remove(key);
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        maxHeap.addAll(map.keySet());
        if(maxHeap.size() == 0) return "";
        String ans = maxHeap.peek();
        maxHeap.clear();
        return ans;
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        minHeap.addAll(map.keySet());
        if(minHeap.size() == 0) return "";
        String ans = minHeap.peek();
        minHeap.clear();
        return ans;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */

/*

146. LRU Cache
Medium

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4

Link : https://leetcode.com/problems/lru-cache/

*/

// LinkedHashMap
class LRUCache {
    Map <Integer, Integer> lookupMap;
    int capacity;
    int currCount =0;
    
    public LRUCache(int capacity) {
        this.lookupMap = new LinkedHashMap();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(lookupMap.containsKey(key)){
            int val = lookupMap.get(key);
            lookupMap.remove(key);
            lookupMap.put(key, val);
            return lookupMap.get(key);
        }
        else
            return -1;
    } 
    
    public void put(int key, int value) {
        if(lookupMap.containsKey(key)){
            lookupMap.remove(key);
            lookupMap.put(key, value);
            return;
        }
        if (this.currCount == this.capacity){
            this.lookupMap.remove(this.lookupMap.keySet().iterator().next());
            this.currCount--;
        }
        
        this.lookupMap.put(key, value);
        this.currCount++;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

class LRUCache {
    
    class DNode{
        int key;
        int value;
        DNode prev;
        DNode next;
        DNode(int key, int value){
            this.key = key;
            this.value = value;
        }
        
        private void removeFromHead(){ //removing the least recently used
            if (tail == this){
                tail = null;
                head = null;
                return;
            }
            head = this.next;
            head.prev = null;
            
        }
        
        private void update(){ //update existing entry
            if(tail == this) return;
            if (this != head)
                this.prev.next = this.next;
            else
                head = this.next;
            this.next.prev = this.prev;
            this.appendToTail();
            return;
        }
        
        private void appendToTail(){ //append new entry to tail
            if (tail == null){
                tail = this;
                head = this;
                return;
            }
            this.next = null;
            this.prev = tail;
            tail.next = this;
            tail = this;
        }
    }
    
    private Map<Integer, DNode> cache;
    DNode tail = null;
    DNode head = null;
    int capacity;

    public LRUCache(int capacity) {
        cache = new HashMap<Integer, DNode>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)){
            DNode target = cache.get(key);
            int val = target.value;
            target.update();
            return val;
            
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)){
            DNode target = cache.get(key);
            target.value = value;
            target.update();
            return;
        }
        if (cache.size() == capacity){
            cache.remove(head.key);
            head.removeFromHead();
        }
        DNode target = new DNode(key, value);
        target.appendToTail();
        cache.put(key, target);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

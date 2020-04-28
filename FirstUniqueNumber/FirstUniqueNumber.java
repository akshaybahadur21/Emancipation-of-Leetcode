/*

You have a queue of integers, you need to retrieve the first unique integer in the queue.

Implement the FirstUnique class:

    FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
    int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.
    void add(int value) insert value to the queue.

 

Example 1:

Input: 
["FirstUnique","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique"]
[[[2,3,5]],[],[5],[],[2],[],[3],[]]
Output: 
[null,2,null,2,null,3,null,-1]

Explanation: 
FirstUnique firstUnique = new FirstUnique([2,3,5]);
firstUnique.showFirstUnique(); // return 2
firstUnique.add(5);            // the queue is now [2,3,5,5]
firstUnique.showFirstUnique(); // return 2
firstUnique.add(2);            // the queue is now [2,3,5,5,2]
firstUnique.showFirstUnique(); // return 3
firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
firstUnique.showFirstUnique(); // return -1

Example 2:

Input: 
["FirstUnique","showFirstUnique","add","add","add","add","add","showFirstUnique"]
[[[7,7,7,7,7,7]],[],[7],[3],[3],[7],[17],[]]
Output: 
[null,-1,null,null,null,null,null,17]

Explanation: 
FirstUnique firstUnique = new FirstUnique([7,7,7,7,7,7]);
firstUnique.showFirstUnique(); // return -1
firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
firstUnique.showFirstUnique(); // return 17

Example 3:

Input: 
["FirstUnique","showFirstUnique","add","showFirstUnique"]
[[[809]],[],[809],[]]
Output: 
[null,809,null,-1]

Explanation: 
FirstUnique firstUnique = new FirstUnique([809]);
firstUnique.showFirstUnique(); // return 809
firstUnique.add(809);          // the queue is now [809,809]
firstUnique.showFirstUnique(); // return -1

 

Constraints:

    1 <= nums.length <= 10^5
    1 <= nums[i] <= 10^8
    1 <= value <= 10^8
    At most 50000 calls will be made to showFirstUnique and add.

*/

class FirstUnique {
    class DNode{
        DNode prev;
        DNode next;
        int val;
        DNode(int val){
            this.val = val;
        }
    }
    
    DNode head = null;
    DNode tail = null;
    Map<Integer, DNode> map = new HashMap<>();
    public FirstUnique(int[] nums) {
        for(int i = 0; i < nums.length; i++)
            add(nums[i]);
    }
    
    public void appendToTail(DNode node){ //append new entry to tail
            if (tail == null){
                tail = node;
                head = node;
                return;
            }
            node.next = null;
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        public void deleteDNode(DNode node){ //removing the least recently used
            
        DNode next = node.next;
        DNode prev = node.prev;
        if (prev != null && next != null) {
            prev.next = next;
            next.prev = prev;
            node.next = null;
            node.prev = null;
            return;
            }
            
            if (tail == node){
                tail = null;
                head = null;
                return;
            }
            if (head == node){
                DNode temp = head;
                head = head.next;
                head.prev = null;
                temp.next = null;
            }
        }
    
    public int showFirstUnique() {
        if(tail == null) return -1;
        return head.next.val;
    }
    
    public void add(int value) {
        System.out.println(value);
        if (map.containsKey(value)){
            deleteDNode(map.get(value));
        }
        else{
            DNode node = new DNode(value);
            map.put(value, node);
            appendToTail(node);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
 
 

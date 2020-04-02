/*

1019. Next Greater Node In Linked List
Medium

We are given a linked list with head as the first node.  Let's number the nodes in the list: node_1, node_2, node_3, ... etc.

Each node may have a next larger value: for node_i, next_larger(node_i) is the node_j.val such that j > i, node_j.val > node_i.val, and j is the smallest possible choice.  If such a j does not exist, the next larger value is 0.

Return an array of integers answer, where answer[i] = next_larger(node_{i+1}).

Note that in the example inputs (not outputs) below, arrays such as [2,1,5] represent the serialization of a linked list with a head node value of 2, second node value of 1, and third node value of 5.

Example 1:

Input: [2,1,5]
Output: [5,5,0]

Example 2:

Input: [2,7,4,3,5]
Output: [7,0,5,5,0]

Example 3:

Input: [1,7,5,1,9,2,5,1]
Output: [7,9,9,9,0,5,0,0]

 
Note:

    1 <= node.val <= 10^9 for each node in the linked list.
    The given list has length in the range [0, 10000].

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> nodeList = new ArrayList<>();
        for (ListNode node = head; node != null; node = node.next)
            nodeList.add(node.val);
        int[] res = new int[nodeList.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nodeList.size(); i++){
            while(!stack.isEmpty() && nodeList.get(stack.peek()) < nodeList.get(i))
                res[stack.pop()] = nodeList.get(i);
            stack.push(i);
        }
        return res;
    }
}

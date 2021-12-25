/*

1836. Remove Duplicates From an Unsorted Linked List
Medium

Given the head of a linked list, find all the values that appear more than once in the list and delete the nodes that have any of those values.

Return the linked list after the deletions.

Example 1:

Input: head = [1,2,3,2]
Output: [1,3]
Explanation: 2 appears twice in the linked list, so all 2's should be deleted. After deleting all 2's, we are left with [1,3].

Example 2:

Input: head = [2,1,1,2]
Output: []
Explanation: 2 and 1 both appear twice. All the elements should be deleted.

Example 3:

Input: head = [3,2,2,1,3,2,4]
Output: [1,4]
Explanation: 3 appears twice and 2 appears three times. After deleting all 3's and 2's, we are left with [1,4].

Constraints:

    The number of nodes in the list is in the range [1, 105]
    1 <= Node.val <= 105

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        ListNode newHead = new ListNode(0);
        ListNode curr = head;
        while(curr != null){
            map.put(curr.val, map.containsKey(curr.val) ? map.get(curr.val) + 1 : 1);
            curr = curr.next;
        }
        curr = newHead;
        while(head != null){
            if(map.get(head.val) > 1) {
                head = head.next;
                continue;
            }
            curr.next = new ListNode(head.val);
            curr = curr.next;
            head = head.next;
        }
        return newHead.next;
    }
}

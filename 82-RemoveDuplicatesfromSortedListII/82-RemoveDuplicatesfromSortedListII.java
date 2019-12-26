/*

82. Remove Duplicates from Sorted List II
Medium

Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5

Example 2:

Input: 1->1->1->2->3
Output: 2->3

Link : https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

*/

// Not a preferred approach (using HashMaps)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        Map<Integer, Integer> lookupMap = new LinkedHashMap<>();
        ListNode temp=head;
        int count=0;
        ListNode newHead=head;
        ListNode tempHead=head;

        while(temp!=null){
            lookupMap.put(temp.val,lookupMap.containsKey(temp.val)?lookupMap.get(temp.val)+1:1);
            temp=temp.next;
        }
        for (Map.Entry<Integer, Integer> entry : lookupMap.entrySet()) {

            if(entry.getValue()==1){
                if (count ==0){
                    newHead = new ListNode(entry.getKey());
                    tempHead=newHead;
                    count++;
                }
                else if (count>0){
                    tempHead.next=new ListNode(entry.getKey());
                    tempHead=tempHead.next;
                }
                else
                    continue;
            }  
        }
        if (count ==0)
            return null;
        return newHead;
    }
}

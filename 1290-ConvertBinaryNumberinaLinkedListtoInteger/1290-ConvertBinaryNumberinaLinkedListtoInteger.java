/*

1290. Convert Binary Number in a Linked List to Integer
Easy

Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.

Return the decimal value of the number in the linked list.

 

Example 1:

Input: head = [1,0,1]
Output: 5
Explanation: (101) in base 2 = (5) in base 10

Example 2:

Input: head = [0]
Output: 0

Example 3:

Input: head = [1]
Output: 1

Example 4:

Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
Output: 18880

Example 5:

Input: head = [0,0]
Output: 0

 

Constraints:

    The Linked List is not empty.
    Number of nodes will not exceed 30.
    Each node's value is either 0 or 1.

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
    public int getDecimalValue(ListNode head) {
        //traverse linkedList and create integer[]
        // traverse integer[] to conver the base from 2 to 10 and return
        StringBuilder sb = new StringBuilder();
        while(head != null){
            sb.append(String.valueOf(head.val));
            head=head.next;
        }
        int[]num = new int[sb.length()];
        for (int i =0; i<sb.length(); i++)
            num[i] = Character.getNumericValue(sb.charAt(i));
        int baseTen = 0;
        int count =0;
        for(int i =num.length - 1; i>= 0; i--){
            baseTen += num[i]* Math.pow(2,count);
            count ++;
        }
        return baseTen;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        //Approach 2
        // traverse the list and add integer to a stack
        // traverse stack and return int
        
        Stack<Integer> stack = new Stack<>();
        while(head != null){
            stack.push(head.val);
            head = head.next;
        }
        int res = 0;
        int count = 0;
        while(!stack.isEmpty())
            res += Math.pow(2, count++) * stack.pop();
        return res;
    }
}

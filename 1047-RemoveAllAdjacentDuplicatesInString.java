/*
1047. Remove All Adjacent Duplicates In String
Easy

Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.

We repeatedly make duplicate removals on S until we no longer can.

Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.

 

Example 1:

Input: "abbaca"
Output: "ca"
Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".

 

Note:

    1 <= S.length <= 20000
    S consists only of English lowercase letters.


Link : https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

*/


class Solution {
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder(S);
        for (int i=0;i<sb.length()-1;){
            if (sb.charAt(i)==sb.charAt(i+1)){
                sb.delete(i,i+2);
                if (i!=0)
                    i--;
                continue;
            }
            i++;
        }
        return sb.toString();
        
    }
}

// Using Stack based approach

class Solution {
    public String removeDuplicates(String S) {
        Deque<Character> dequeue = new LinkedList<Character>();
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<S.length();i++){
            if (dequeue.peekFirst()==null)
                dequeue.addFirst(S.charAt(i));
            
            else if (S.charAt(i)==dequeue.peekFirst())
                dequeue.removeFirst();
            
            else
                dequeue.addFirst(S.charAt(i));
        }
        while(dequeue.peekLast()!=null)
            sb.append(dequeue.pollLast());
        return sb.toString();
        
    }
}

/*

 Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. 
 If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].

Link : https://leetcode.com/problems/daily-temperatures/
*/

//Using Stack

class Solution {
    public int[] dailyTemperatures(int[] T) {
        
        
        Stack <Integer> tempStack = new Stack<>();
        Stack<Integer> posStack= new Stack<>();
        
        int[] ans = new int[T.length];
        if (T.length==0)
            return ans;
        
        ans[T.length-1]=0;
        tempStack.push(T[T.length-1]);
        posStack.push(T.length-1);
        
        for (int i=T.length-2;i>=0;i--)
        {
            if(tempStack.peek()>T[i])
            {
                tempStack.push(T[i]);
                posStack.push(i);
                ans[i]=1;
            }
            else
            {
                while(!tempStack.isEmpty() && tempStack.peek()<=T[i]){
                    posStack.pop();
                    tempStack.pop();
                }
                if(tempStack.isEmpty()){
                    ans[i]=0;
                    tempStack.push(T[i]);
                    posStack.push(i);
                }
                else{
                    ans[i]=posStack.peek()-i;
                    tempStack.push(T[i]);
                    posStack.push(i);
                }
                
            }
        
        }
        return ans;
    }
}


// Using 2 loops

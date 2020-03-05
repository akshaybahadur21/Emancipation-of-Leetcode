/*

315. Count of Smaller Numbers After Self
Hard

You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Input: [5,2,6,1]
Output: [2,1,1,0] 
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.

*/

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        //Approach 1
        // Simple iterative - Time Limit Exceed
        List<Integer> resList = new ArrayList<>();
        if (nums.length == 0) return resList;
        int res[] = new int[nums.length];
        res[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >=0 ; i--){
            int count = i;
            while(count < nums.length){
                if (nums[count++] < nums[i])
                    res[i]++;
            }
        }
        for (int i : res)
            resList.add(i);
        return resList;
    }
}

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        //Approach 2
        // Using 2 Priority queue to shuffle elements - Time Limit Exceeded
        Queue<Integer> q1 = new PriorityQueue<>((n1, n2) -> n2 - n1);
        Queue<Integer> q2 = new PriorityQueue<>((n1, n2) -> n2 - n1);
        List<Integer> resList = new ArrayList<>();
        if (nums.length == 0) return resList;
        int res[] = new int[nums.length];
        res[nums.length - 1] = 0;
        q1.add(nums[nums.length - 1]);
        for (int i = nums.length - 2; i >=0 ; i--){
            while(!q1.isEmpty() && q1.peek() >= nums[i]) 
                q2.add(q1.poll());
            res[i] = q1.size();
            q1.add(nums[i]);
            while(!q2.isEmpty()) 
                q1.add(q2.poll());
        }
        for (int i : res)
            resList.add(i);
        return resList;
    }
}

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        //Approach 3
        // 2 stacks - Time limit exceeded
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        List<Integer> resList = new ArrayList<>();
        if (nums.length == 0) return resList;
        int res[] = new int[nums.length];
        res[nums.length - 1] = 0;
        s1.add(nums[nums.length - 1]);
        for (int i = nums.length - 2; i >=0 ; i--){
            while(!s1.isEmpty() && s1.peek() >= nums[i]) 
                s2.push(s1.pop());
            res[i] = s1.size();
            s1.push(nums[i]);
            while(!s2.isEmpty()) 
                s1.push(s2.pop());
        }
        for (int i : res)
            resList.add(i);
        return resList;
    }
}

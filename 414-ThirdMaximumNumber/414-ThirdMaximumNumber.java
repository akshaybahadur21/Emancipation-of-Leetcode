/*

414. Third Maximum Number
Easy
Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:

Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.

Example 2:

Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.

Example 3:

Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.

*/

class Solution {
    public int thirdMax(int[] nums) {
        //Approach 1
        // Use 3 variables
        
        Integer max = null, second = null, third = null;
        
        for (Integer i : nums){
            if (i.equals(max) || i.equals(second) || i.equals(third)) continue;
            if (max == null || i > max){
                third = second;
                second = max;
                max = i;
            }
            else if(second == null || i > second){
                third = second;
                second = i;
            }
            else if(third == null || i > third){
                third = i;
            }
            
        }
        
        return third == null ? max : third;
    }
}

class Solution {
    public int thirdMax(int[] nums) {
        //Approach 2
        // TreeSet
        
        Integer max = null, second = null, third = null;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : nums)
            set.add(i);
        if(set.size() < 3)
          return set.last();
        set.remove(set.last());
        set.remove(set.last());
        return set.last();
    }
}

class Solution {
    public int thirdMax(int[] nums) {
        //Approach 3
        // Min Heap
        Queue<Integer> heap = new PriorityQueue<>((n1,n2) -> n1 - n2);
        for(int i : nums){
            if (heap.contains(i)) continue;
            heap.add(i);
            if (heap.size() > 3) heap.poll();
        }
        if (heap.size() < 3){
            while(true){
                int res = heap.poll();
                if (heap.isEmpty())
                    return res;
            }
        }
        return heap.poll();
    }
}

class Solution {
    public int thirdMax(int[] nums) {
        //Approach 3
        // Max Heap
        Queue<Integer> heap = new PriorityQueue<>((n1,n2) -> n2 - n1);
        for(int i : nums){
            if (heap.contains(i)) continue;
            heap.add(i);
        }
        if (heap.size() < 3)
           return heap.poll();
        int count = 3;
        while(count-- != 1)
            heap.poll();
        return heap.poll();
    }
}

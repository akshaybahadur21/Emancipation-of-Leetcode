/*

621. Task Scheduler
Medium

Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks. Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

Example:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.

Constraints:

    The number of tasks is in the range [1, 10000].
    The integer n is in the range [0, 100].

*/

class Solution {
    public int leastInterval(char[] tasks, int n) {
       //pq solution where i can maintain the max heap for upto n distance
        Map<Character, Integer> map = new HashMap<>();
        Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((n1, n2) -> n2.getValue() != n1.getValue() ? n2.getValue() - n1.getValue() : n1.getKey() - n2.getKey());
        for(char t : tasks)
            map.put(t, map.containsKey(t) ? map.get(t) + 1 : 1);
        maxHeap.addAll(map.entrySet());
        int res = 0;
        while(!maxHeap.isEmpty()){
            int k = n + 1;
            List<Map.Entry> entryList = new ArrayList<>();
            while(k > 0 && !maxHeap.isEmpty()){
                Map.Entry<Character, Integer> temp = maxHeap.poll();
                temp.setValue(temp.getValue() - 1);
                entryList.add(temp);
                k--;
                res++;
            }
            for(Map.Entry<Character, Integer> t : entryList){
                if(t.getValue() > 0)
                    maxHeap.add(t);
            }
            if(maxHeap.isEmpty()) break;
            res += k;
        }
        return res;
    }
}

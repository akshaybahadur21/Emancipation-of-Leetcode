/*

582. Kill Process
Medium

Given n processes, each process has a unique PID (process id) and its PPID (parent process id).

Each process only has one parent process, but may have one or more children processes. This is just like a tree structure. Only one process has PPID that is 0, which means this process has no parent process. All the PIDs will be distinct positive integers.

We use two list of integers to represent a list of processes, where the first list contains PID for each process and the second list contains the corresponding PPID.

Now given the two lists, and a PID representing a process you want to kill, return a list of PIDs of processes that will be killed in the end. You should assume that when a process is killed, all its children processes will be killed. No order is required for the final answer.

Example 1:

Input: 
pid =  [1, 3, 10, 5]
ppid = [3, 0, 5, 3]
kill = 5
Output: [5,10]
Explanation: 
           3
         /   \
        1     5
             /
            10
Kill 5 will also kill 10.

Note:

    The given kill id is guaranteed to be one of the given PIDs.
    n >= 1.

*/

class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        // 1. simple iterate and kill all the child processes. Use queue to manage levels.
        // 2. Build graph and kill all child process in dfs
        if (kill == 0) return pid;
        Map<Integer, Set<Integer>> graph = getGraph(pid, ppid);
        List<Integer> resList = new ArrayList<>();
        dfs(graph, resList, kill);
        return resList;
    }
    
    private void dfs(Map<Integer, Set<Integer>> graph, List<Integer> resList, int pid) {
        resList.add(pid);
        Set<Integer> children = graph.get(pid);
        for (Integer child : children) {
            dfs(graph, resList, child);
        }
    }
    private Map<Integer, Set<Integer>> getGraph(List<Integer> pid, List<Integer> ppid){
        int n = pid.size();
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(pid.get(i), new HashSet<Integer>());
        }
        for (int i = 0; i < n; i++) {
            if (graph.containsKey(ppid.get(i))) {
                Set<Integer> children = graph.get(ppid.get(i));
                children.add(pid.get(i));
                graph.put(ppid.get(i), children);
            }
        }
        return graph;
    }
}



//TLE
class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        // 1. simple iterate and kill all the child processes. Use queue to manage levels.
        // 2. Build graph and kill all child process in dfs
        List<Integer> resList = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();
        q.add(kill);
        vis.add(kill);
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                int curr = q.poll();
                resList.add(curr);
                for(int j = 0; j < ppid.size(); j++){
                    if(ppid.get(j) == curr && !vis.contains(pid.get(j))){
                        q.add(pid.get(j));
                        vis.add(pid.get(j));
                        }
                    }
                }
            }
        return resList;
    }
}

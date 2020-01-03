/*

690. Employee Importance
Easy

You are given a data structure of employee information, which includes the employee's unique id, his importance value and his direct subordinates' id.

For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. They have importance value 15, 10 and 5, respectively. Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct.

Now given the employee information of a company, and an employee id, you need to return the total importance value of this employee and all his subordinates.

Example 1:

Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
Output: 11
Explanation:
Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3. They both have importance value 3. So the total importance value of employee 1 is 5 + 3 + 3 = 11.

Note:

    One employee has at most one direct leader and may have several subordinates.
    The maximum number of employees won't exceed 2000.

Link : https://leetcode.com/problems/employee-importance/

*/

/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    //search for employee id
    //get subordinates
    //check their impartance and recursively call subordinates of subordinates (dfs)
    Map<Integer, Employee> lookupMap;
    public int getImportance(List<Employee> employees, int id) {
        lookupMap = new HashMap<>();
        for(Employee emp : employees){
            lookupMap.put(emp.id, emp);
        }
        return dfs(id);
        
    }
    private int dfs(int id){
        Employee emp = lookupMap.get(id);
        int ans = emp.importance;
        for (int e : emp.subordinates){
            ans += dfs(e);
        }
        return ans;
            
    }
}

//dfs with external stack
/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    //search for employee id
    //get subordinates
    //check their impartance and recursively call subordinates of subordinates (dfs)
    Map<Integer, Employee> lookupMap;
    public int getImportance(List<Employee> employees, int id) {
        lookupMap = new HashMap<>();
        for(Employee emp : employees){
            lookupMap.put(emp.id, emp);
        }
        return dfs(id);
        
    }
    private int dfs(int id){
        int ans = 0;
        Stack<Integer> s = new Stack<>();
        s.add(id);
        while(!s.isEmpty()){
            Employee emp = lookupMap.get(s.pop());
            ans+= emp.importance;
            for (int i : emp.subordinates)
                s.push(i);
        }
        return ans;
            
    }
}

//bfs
/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    //Create a map of <empId, emp>
    //Add the importance and add the subordinates in queue
    // iterate through queue and add the importance of subordinates.
    Map<Integer, Employee> lookupMap;
    public int getImportance(List<Employee> employees, int id) {
        lookupMap = new HashMap<>();
        for(Employee emp : employees){
            lookupMap.put(emp.id, emp);
        }
        return bfs(id);
        
    }
    private int bfs(int id){
        int ans = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        while(!q.isEmpty()){
            Employee emp = lookupMap.get(q.poll());
            ans+= emp.importance;
            for (int i : emp.subordinates)
                q.add(i);
        }
        return ans;
            
    }
}

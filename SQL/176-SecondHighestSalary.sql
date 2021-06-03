/*

176. Second Highest Salary
Easy
SQL Schema

Write a SQL query to get the second highest salary from the Employee table.

+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+

For example, given the above Employee table, the query should return 200 as the second highest salary. If there is no second highest salary, then the query should return null.

+---------------------+
| SecondHighestSalary |
+---------------------+
| 200                 |
+---------------------+

*/

# Write your MySQL query statement below

    SELECT Salary as SecondHighestSalary
      FROM Employee
  ORDER BY Salary
     LIMIT 1
    OFFSET 1;
    
 # Write your MySQL query statement below

    SELECT MAX(Salary) as SecondHighestSalary
      FROM Employee
     WHERE (Salary < (SELECT MAX(Salary)
                       FROM Employee));

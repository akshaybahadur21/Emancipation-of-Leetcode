"""

412. Fizz Buzz
Solved
Easy
Topics
Companies

Given an integer n, return a string array answer (1-indexed) where:

    answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
    answer[i] == "Fizz" if i is divisible by 3.
    answer[i] == "Buzz" if i is divisible by 5.
    answer[i] == i (as a string) if none of the above conditions are true.

Example 1:

Input: n = 3
Output: ["1","2","Fizz"]

Example 2:

Input: n = 5
Output: ["1","2","Fizz","4","Buzz"]

Example 3:

Input: n = 15
Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]

Constraints:

    1 <= n <= 104

"""

class Solution:
    def fizzBuzz(self, n: int) -> List[str]:
        res = []
        for num in range (1, n + 1):
            if num % 15 == 0: res.append("FizzBuzz")
            elif num % 5 == 0: res.append("Buzz")
            elif num % 3 == 0: res.append("Fizz")
            else: res.append(str(num))
        return res

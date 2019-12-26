/*

412. Fizz Buzz
Easy

Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.

Example:

n = 15,

Return:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]

Link : https://leetcode.com/problems/fizz-buzz/

*/

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> resList = new ArrayList<>();
        for (int i=1;i<=n;i++){
            if (i%15==0)
                resList.add("FizzBuzz");
            else if(i%3==0)
                resList.add("Fizz");
            else if (i%5==0)
                resList.add("Buzz");
            else
                resList.add(String.valueOf(i));
        }
        return resList;
        
    }
}

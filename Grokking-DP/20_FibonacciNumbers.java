/*

Problem Statement #
Write a function to calculate the nth Fibonacci number.

Fibonacci numbers are a series of numbers in which each number is the sum of the two preceding numbers. First few Fibonacci numbers are: 0, 1, 1, 2, 3, 5, 8, …

Mathematically we can define the Fibonacci numbers as:

    Fib(n) = Fib(n-1) + Fib(n-2), for n > 1
 
    Given that: Fib(0) = 0, and Fib(1) = 1

*/

class Fibonacci {
  public int CalculateFibonacci(int n) {
    if(n < 2)
      return n;
    return CalculateFibonacci(n-1) + CalculateFibonacci(n-2);
  }
  public static void main(String[] args) {
    Fibonacci fib = new Fibonacci();
    System.out.println("5th Fibonacci is ---> " + fib.CalculateFibonacci(5));
    System.out.println("6th Fibonacci is ---> " + fib.CalculateFibonacci(6));
    System.out.println("7th Fibonacci is ---> " + fib.CalculateFibonacci(7));
  }
}


class Fibonacci {

  public int CalculateFibonacci(int n) {
    Integer cache[] = new Integer[n + 1];
    return CalculateFibonacciRecursive(cache, n);
  }
  public int CalculateFibonacciRecursive(Integer[] cache, int n) {
    if(n < 2) return n;
    if(cache[n] != null) return cache[n];
    cache[n] = CalculateFibonacciRecursive(cache, n - 1) + CalculateFibonacciRecursive(cache, n - 2);
    return cache[n];
  }
  public static void main(String[] args) {
    Fibonacci fib = new Fibonacci();
    System.out.println("5th Fibonacci is ---> " + fib.CalculateFibonacci(5));
    System.out.println("6th Fibonacci is ---> " + fib.CalculateFibonacci(6));
    System.out.println("7th Fibonacci is ---> " + fib.CalculateFibonacci(7));
  }
}

class Fibonacci {
  public int CalculateFibonacci(int n) {
    if(n < 2) return n;
    int dp[] = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    for(int i = 2; i < dp.length; i++)
      dp[i] = dp[i - 1] + dp[i - 2];
    return dp[n];
  }
  public static void main(String[] args) {
    Fibonacci fib = new Fibonacci();
    System.out.println("5th Fibonacci is ---> " + fib.CalculateFibonacci(5));
    System.out.println("6th Fibonacci is ---> " + fib.CalculateFibonacci(6));
    System.out.println("7th Fibonacci is ---> " + fib.CalculateFibonacci(7));
  }
}

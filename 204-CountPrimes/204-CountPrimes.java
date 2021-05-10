/*

204. Count Primes
Easy

Count the number of prime numbers less than a non-negative number, n.

Example 1:

Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

Example 2:

Input: n = 0
Output: 0

Example 3:

Input: n = 1
Output: 0

Constraints:

    0 <= n <= 5 * 106

*/

class Solution {
    public int countPrimes(int n) {
        // Sieve of Eratosthenes
        boolean[] sieve = new boolean[n + 1];
        int count = 0, res = 0;
        
        for(int i = 2; i < n; i++){
            if(isPrime(i)){
                sieve[i] = true;
                markSieve(i, sieve);
            }
        }
        
        for(int i = 0; i < sieve.length; i++){
            if(sieve[i]) res++;
        }
        return res;
    }
    private boolean isPrime(int n){
        for(int i = 2; i <= n / 2; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
    
    private void markSieve(int i, boolean[] sieve){
        int count = 2;
        for(int j = i; j * count < sieve.length; j++){
            sieve[j * count++] = false;
        }
    }
}

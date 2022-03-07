/*
Given an integer n, return the number of prime numbers that are strictly less than n.

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

0 <= n <= 5 * 10^6
*/
class Solution {
    public int countPrimes(int n) {
        if(n <= 2) return 0; //checking 0 & 1
        boolean[] primes = new boolean[n];
        /*for(int i = 0; i < primes.length; i++){
            primes[i] = true;
        }*/
        
        for(int i = 2; i * i < primes.length; i++){//there are no prime numbers greater than current number in its squared
            if(!primes[i]){
                for(int j = i; j * i < primes.length; j++){
                    primes[i * j] = true;
                }
            }            
        }
        int primeCount = 0;
        for(int i = 2; i < primes.length; i++){
            if(!primes[i]){
                primeCount++;
            }
        }
        return primeCount;
    }
}
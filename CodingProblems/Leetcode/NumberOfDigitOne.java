/*
Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

Example 1:

Input: n = 13
Output: 6

Example 2:

Input: n = 0
Output: 0
 

Constraints:

0 <= n <= 10^9
*/
class Solution {
    public int countDigitOne(int n) {
        char toFind = '1';             // change '1' to any digit to find number of times repeated
        return countAnyDigit(n, toFind);
    }
    
    private int countAnyDigit(int n, int c){
        String s = "";
        for(int i = 0; i < n + 1; i++)  s += String.valueOf(i);      
        int count = 0;
        for(int i = 0; i < s.length(); i++) if(s.charAt(i) == c) count++; 
        return count;
    } 
}

class Solution {
    public int countDigitOne(int n) {
       if (n == 0) return 0;

        long base = 1;
        int sum = 0;

        while (base <= n) {
            int cur = (int) (n / base % 10);
            int left = (int) (n / base / 10);
            int right = (int) (n % base);
            
            if (cur > 1) {
                sum += (left + 1) * base;
            } else if (cur == 1) {
                sum += (left) * base;              
                sum += (right + 1);
            } else {
                sum += left * base;
            }

            base *= 10;
        }

        return sum; 
    }
}
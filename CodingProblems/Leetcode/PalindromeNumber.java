/*
Given an integer x, return true if x is palindrome integer.
An integer is a palindrome when it reads the same backward as forward.
For example, 121 is a palindrome while 123 is not.
 
Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 
Constraints:

-231 <= x <= 231 - 1
 
Follow up: Could you solve it without converting the integer to a string?
*/
class Solution {
	//no string conversion
    public boolean isPalindromeNumber(int x) {
        int reversed = 0;
        int original = x;
        int digit = 0;
        while (x >= 1) {
            digit = x % 10;
            x /= 10;
            reversed = reversed*10 + digit;
        }
        return original == reversed;
    }
    //with string conversion
    public boolean isPalindromeNumberToStringConversion(int x) {
        String org, reverse;
        
        if (x < 0){
            org = new StringBuilder(String.valueOf(-x)).append("-").toString();
            reverse = new StringBuilder(String.valueOf(-x)).append("-").reverse().toString();
        } else {
            org = new StringBuilder(String.valueOf(x)).toString();
            reverse = new StringBuilder(String.valueOf(x)).reverse().toString();
        }
        
        if(org.equals(reverse)){
            return true;
        } else{
            return false;
        }
    }
}
/*
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Follow up: Do not use any built-in library function such as sqrt.

Example 1:

Input: num = 16
Output: true

Example 2:

Input: num = 14
Output: false
 

Constraints:

1 <= num <= 2^31 - 1
*/
class Solution {
    public boolean isPerfectSquare(int num) {
        int l = 1;
        int r = num;
        
        while(l <= r){
            long mid = (l + r) / 2;
            long squareMid = mid * mid;
            
            if(squareMid == num){
                return true;
            }else if(squareMid > num){
                r = (int) mid - 1;
            }else {
                l = (int) mid + 1;
            }
        }
        return false;
    }
}
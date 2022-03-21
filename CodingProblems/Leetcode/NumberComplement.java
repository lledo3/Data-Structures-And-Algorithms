/*
The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.

For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
Given an integer num, return its complement.

Example 1:

Input: num = 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.

Example 2:

Input: num = 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 

Constraints:

1 <= num < 2^31
*/
class Solution {
    public int findComplement(int num) {
        int result = 0;
        int power = 1;
        
        while(num > 0){
            //mod 2 will give us the last bit in binary and xor it with 1 which flip the bit then multiply by the power
            result += (num % 2 ^ 1) * power;
            //change power basically multiply by 2
            power <<= 1;
            //truncate the bit, same as dividing by 2
            num >>= 1;
        }
        return result;
    }
}
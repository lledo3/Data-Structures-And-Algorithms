/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

If multiple answers are possible, return any of them.

It is guaranteed that the length of the answer string is less than 104 for all the given inputs.

Example 1:

Input: numerator = 1, denominator = 2
Output: "0.5"

Example 2:

Input: numerator = 2, denominator = 1
Output: "2"

Example 3:

Input: numerator = 4, denominator = 333
Output: "0.(012)"
 
Constraints:

-2^31 <= numerator, denominator <= 2^31 - 1
denominator != 0
*/
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        if(numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0){
            sb.append("-");
        }
        
        long divisor = Math.abs((long) numerator);
        long dividend = Math.abs((long) denominator);
        long remainder = divisor % dividend;
        sb.append(divisor / dividend);
        
        if(remainder == 0){
            return sb.toString();
        }
        sb.append('.');
        Map<Long, Integer> map = new HashMap<>();
        while(remainder != 0){
            if(map.containsKey(remainder)){
                sb.insert(map.get(remainder), "(");
                sb.append(")");
                break;
            }
            map.put(remainder, sb.length());
            remainder *= 10;
            sb.append(remainder / dividend);
            remainder %= dividend;
        }
        return sb.toString();
    }
}
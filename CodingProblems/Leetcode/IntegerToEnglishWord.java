/*
Convert a non-negative integer num to its English words representation.

Example 1:

Input: num = 123
Output: "One Hundred Twenty Three"

Example 2:

Input: num = 12345
Output: "Twelve Thousand Three Hundred Forty Five"

Example 3:

Input: num = 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 

Constraints:

0 <= num <= 2^31 - 1
*/
class Solution {
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
    
    private final String[] LESS_THAN_TWENTY = {"", "One", "Two", "Three", "Four", "Five", 
    "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
     "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    
    private final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty",
     "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (num > 0) {
            if (num % 1000 > 0) {
                StringBuilder tmp = new StringBuilder();
                helper(tmp, num % 1000);
                tmp.append(THOUSANDS[index]).append(" ");
                sb.insert(0, tmp);
            }
            index++;
            num = num / 1000;
        }
        return sb.toString().trim();
    }
    
    public void helper(StringBuilder tmp, int num) {
        if (num == 0) {
            return;
        } else if (num < 20) {
            tmp.append(LESS_THAN_TWENTY[num]).append(" ");
            return;
        } else if (num < 100) {
            tmp.append(TENS[num / 10]).append(" ");
            helper(tmp, num % 10);
        } else {
            tmp.append(LESS_THAN_TWENTY[num / 100]).append(" Hundred ");
            helper(tmp, num % 100);
        }
    }
}
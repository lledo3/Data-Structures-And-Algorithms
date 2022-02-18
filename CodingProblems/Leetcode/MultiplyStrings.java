/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"

Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"

Constraints:

1 <= num1.length, num2.length <= 200
num1 and num2 consist of digits only.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
*/
class Solution {
    public String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        int[] arr = new int[n + m];
        
        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){
                int val = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = arr[i + j + 1] + val;
                arr[i + j] += sum / 10;
                arr[i + j + 1] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int num : arr){
            if(sb.length() != 0 || num != 0){
                sb.append(num);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
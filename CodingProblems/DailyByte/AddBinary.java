/*
Given two binary strings (strings containing only 1s and 0s) return their sum (also as a binary string).
Note: neither binary string will contain leading 0s unless the string itself is 0

Ex: Given the following binary strings...

"100" + "1", return "101"
"11" + "1", return "100"
"1" + "0", return  "1"
*/
public String addBinary(String a, String b) {
    StringBuilder result = new StringBuilder();
    int i = a.length() - 1;
    int j = b.length() - 1;
    int carry = 0;
    while (i >= 0 || j >= 0) {
        int sum = carry;
        if (i >= 0) {
            sum += a.charAt(i--) - '0';
        }
        if (j >= 0) {
            sum += b.charAt(j--) - '0';
        }

        result.append(sum % 2);
        carry = sum / 2;
    }

    if (carry != 0) {
        result.append(1);
    }

    return result.reverse().toString();
}
/*
Big-O Analysis
Runtime: O(N + M) where N is the length of one string and M is the length of the other string
Space complexity: O(max(N, M)) as the longest our resulting string will be is the length of the longer string + 1
*/
/*
Palindrome Substrings II - O(n2)

Given a string, count the number of palindromic contiguous substrings in the string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example:

Input:  "abbcbc"

Output: 9

Explanation: ["a", "b", "b", "c", "b", "c", "bb", "bcb", "cbc"]
*/
class Solution {
    int countPalindromesWithCenter(String input, int left, int right) {
        int result = 0;
        while (0 <= left && right < input.length() &&
                    input.charAt(left) == input.charAt(right)) {
            result += 1;
            left -= 1;
            right += 1;
        }
        return result;
    }
    public int countPalindromes(String input) {
        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            result += countPalindromesWithCenter(input, i, i);
            result += countPalindromesWithCenter(input, i, i + 1);
        }
        return result;
    }
}
/*
Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.

Example 1:

Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".

Example 2:

Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 

Constraints:

1 <= s.length <= 1000
s consists of lowercase English letters.
*/
class Solution {
    public int countSubstrings(String s) {
        if(s.length() == 0) return 0;
        int n = s.length();
        int res = 0;
        char[]c = s.toCharArray();
        for(int i = 0; i < n; i++){
            //odd and even lengths (center of of --> i, i)
            //Center for even --> i, i + 1
            res += isPalindrome(i, i, c);
            res += isPalindrome(i, i + 1, c);
        }
        return res;
    }
    
    public int isPalindrome(int start, int end, char[] c){
        int count = 0;
        while(start >= 0 && end < c.length && c[start] == c[end]){
            start--;
            end++;
            count++;
        }
        return count;
    }
}
/*
Implement strStr().
Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.
For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2

Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1

Example 3:

Input: haystack = "", needle = ""
Output: 0
 

Constraints:

0 <= haystack.length, needle.length <= 5 * 104
haystack and needle consist of only lower-case English characters.
*/
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()) return 0;
        
        int h = haystack.length();
        int n = needle.length();
        
        if(h < n) return -1;
        
        for(int i = 0; i <= h - n; i++){
            int j;
            for(j = 0; j < n; j++){
                if(haystack.charAt(i + j) != needle.charAt(j)){
                    break;
                }
            }
            if(j == n){
                return i;
            }
        }
        return -1;
    }
}
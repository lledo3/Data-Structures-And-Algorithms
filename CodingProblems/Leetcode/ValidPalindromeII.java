/*
Given a string s, return true if the s can be palindrome after deleting at most one character from it.

Example 1:

Input: s = "aba"
Output: true

Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
Example 3:

Input: s = "abc"
Output: false
 

Constraints:

1 <= s.length <= 10^5
s consists of lowercase English letters.
*/
class Solution {
    public boolean validPalindrome(String s) {
        if(s.length() == 0 || s.isEmpty()) return false;
    
        int i = 0;
        int j = s.length() - 1;
        
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return helper(s, i + 1, j) || helper(s, i, j - 1);
            }
            i += 1;
            j -= 1;
        }
        return true;
    }
    public boolean helper(String s, int i, int j){
        int aPt = i;
        int bPt = j;
        
        while(aPt <= bPt){
            if(s.charAt(aPt) != s.charAt(bPt)){
               return false; 
            }
            aPt += 1;
            bPt -= 1;
        }
        return true;
    }
}
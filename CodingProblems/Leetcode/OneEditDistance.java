/*
Given two strings s and t, return true if they are both one edit distance apart, otherwise return false.

A string s is said to be one distance apart from a string t if you can:

Insert exactly one character into s to get t.
Delete exactly one character from s to get t.
Replace exactly one character of s with a different character to get t.
 

Example 1:

Input: s = "ab", t = "acb"
Output: true
Explanation: We can insert 'c' into s to get t.

Example 2:

Input: s = "", t = ""
Output: false
Explanation: We cannot get t from s by only one step.
 

Constraints:

0 <= s.length, t.length <= 10^4
s and t consist of lowercase letters, uppercase letters, and digits.
*/
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int n1 = s.length(), n2 = t.length();
        
        // Ensure that s is shorter than t.
        if(n1 > n2){
            return isOneEditDistance(t, s);
        }
        
        for(int i = 0; i < n1; i++){
            if(s.charAt(i) != t.charAt(i)){
                // if strings have the same length
                if(n1 == n2){
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }else{
                    // if strings have different lengths
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }
        // If there is no diffs on ns distance
        // the strings are one edit away only if
        // t has one more character. 
        return (n1 + 1 == n2);
    }
}
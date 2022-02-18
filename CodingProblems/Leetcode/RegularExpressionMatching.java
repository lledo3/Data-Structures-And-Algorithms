/*
Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

'.' Matches any single character.​​​​
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

 

Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:

Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

Example 3:

Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
 

Constraints:

1 <= s.length <= 20
1 <= p.length <= 30
s contains only lowercase English letters.
p contains only lowercase English letters, '.', and '*'.
It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
*/
class Solution {
    public boolean isMatch(String s, String p) {
        
        Boolean[][] table = Boolean[s.length() + 1][p.length() + 1];
        table[s.length][p.length] = true;
        return isMatchHelper(s, p, 0, 0);
    }
    
    public boolean isMatchHelper(String s, String p, int i, int j){
        if(j == p.length()){
            return i == s.length();
        }
        
        boolean check = i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j));
        
        if(j + 1 < p.length() && p.charAt(j+1) == '*'){
            if(isMatchHelper(s, p, i, j+2) || (check && isMatchHelper(s, p, i+1, j))){
              return true;  
            }
        }else if(check){
            return isMatchHelper(s, p, i+1, j+1);
        }
        return false;
    }
}
/*
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:

Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.

Example 3:

Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.

Constraints:

0 <= s.length, p.length <= 2000
s contains only lowercase English letters.
p contains only lowercase English letters, '?' or '*'.
*/
class Solution {
    Map<String, Boolean> map = new HashMap<>();
    public boolean isMatch(String s, String p) {
        return dfs(s, p, 0, 0);
    }
    public boolean dfs(String s, String p, int i, int j) {
        if (i == s.length() && j == p.length()) return true;
        if (j == p.length()) return false;
        
        if (map.containsKey(i + "_" + j)) return map.get(i + "_" + j);
        
        boolean b = false;
        if (i == s.length()) 
            b = p.charAt(j) == '*' && dfs(s, p, i, j + 1);
        else if (p.charAt(j) == '*') 
            b = dfs(s, p, i + 1, j) || dfs(s, p, i, j + 1);
        else if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) 
            b = dfs(s, p, i + 1, j + 1);
        else 
            b = false;
        map.put(i + "_" + j, b);
        return b;
    }
}
/*
Given an integer n, return all the strobogrammatic numbers that are of length n. You may return the answer in any order.

A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Example 1:

Input: n = 2
Output: ["11","69","88","96"]

Example 2:

Input: n = 1
Output: ["0","1","8"]
 

Constraints:

1 <= n <= 14
*/
class Solution {
    public final char[][] mapping = {
        {'0', '0'}, 
        {'1', '1'}, 
        {'6', '9'}, 
        {'8', '8'}, 
        {'9', '6'}
    };
    
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        if(n < 1) return res;
        char[] c = new char[n];
        helper(c, 0, n - 1, res);
        return res;
    }
    public void helper(char[] c, int lo, int hi, List<String> res){
        if(lo > hi){
            if(c.length == 1 || c[0] != '0'){
                res.add(String.valueOf(c));
            }
            return;
        }
        for(char[] map : mapping){
            if(lo == hi && map[0] != map[1]){
                continue;
            }
            c[lo] = map[0];
            c[hi] = map[1];
            helper(c, lo + 1, hi - 1, res);
        }
    }
}
/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:

Input: n = 1
Output: ["()"]
 
Constraints:

1 <= n <= 8
*/
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTrackRecursion(res, "", 0, 0, n);
        return res;
    }
    
    public void backTrackRecursion(List<String> res, String combo, int open, int close, int max){
        if(combo.length() == max * 2){
            res.add(combo);
            return;
        }
        if(open < max) backTrackRecursion(res, combo + "(", open + 1, close, max);
        if(close < open) backTrackRecursion(res, combo + ")", open, close + 1, max);
     }
}
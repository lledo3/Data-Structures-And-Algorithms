/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".

Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".

Example 3:

Input: s = ""
Output: 0

Constraints:

0 <= s.length <= 3 * 104
s[i] is '(', or ')'.
*/
class Solution {
    public int longestValidParentheses(String s) {
        if (s.isEmpty()) {
    		return 0;
    	}
		
		Stack<Integer> ch = new Stack<>();
		char match;
        int max = 0;
        ch.push(-1);
        
        for(int i=0;i<s.length();i++){

            match = s.charAt(i);

            if(match =='('){
                ch.push(i);
            }
            else{
                ch.pop();
                if(ch.isEmpty()){
                    ch.push(i);
                }
                else{
                    int len = i - ch.peek();
                    max = Math.max(max,len);
                }
            }
        }
        
        return max;
    }
}
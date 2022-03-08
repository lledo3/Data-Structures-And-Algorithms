/*
Given a string s which represents an expression, evaluate this expression and return its value. 

The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

Example 1:

Input: s = "3+2*2"
Output: 7

Example 2:

Input: s = " 3/2 "
Output: 1

Example 3:

Input: s = " 3+5 / 2 "
Output: 5
 

Constraints:

1 <= s.length <= 3 * 10^5
s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
s represents a valid expression.
All the integers in the expression are non-negative integers in the range [0, 2^31 - 1].
The answer is guaranteed to fit in a 32-bit integer.
*/
class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        int sum = 0;
        Stack<Integer> st = new Stack<>();
        int curr = 0;
        char op = '+';
        char[] ch = s.toCharArray();
        
        for(int i = 0; i < ch.length; i++){
            if(Character.isDigit(ch[i])){
                curr = curr * 10 + ch[i] - '0';
            }
            if(!Character.isDigit(ch[i]) && ch[i] != ' ' || i == ch.length - 1){
                if(op == '+'){
                    st.push(curr);
                }else if(op == '-'){
                    st.push(-curr);
                }else if(op == '*'){
                    st.push(st.pop() * curr);
                }else if(op == '/'){
                    st.push(st.pop() / curr);
                }
                op = ch[i];
                curr = 0;
            }
        }
        while(!st.isEmpty()){
            sum += st.pop();
        }
        return sum;
    }
}
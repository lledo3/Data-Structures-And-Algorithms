/*
Given a string expression of numbers and operators, return all possible results from computing all the different 
possible ways to group numbers and operators. You may return the answer in any order.

Example 1:

Input: expression = "2-1-1"
Output: [0,2]
Explanation:
((2-1)-1) = 0 
(2-(1-1)) = 2

Example 2:

Input: expression = "2*3-4*5"
Output: [-34,-14,-10,-10,10]
Explanation:
(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10
 

Constraints:

1 <= expression.length <= 20
expression consists of digits and the operator '+', '-', and '*'.
All the integer values in the input expression are in the range [0, 99].
*/
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        if(expression == null || expression.length() < 1) return List.of();

            List<Integer> numbers = new ArrayList<Integer>();
            List<Character> operators = new ArrayList<Character>();

            int currNum = 0;
            for(int i = 0; i < expression.length(); i++) {
                char ch = expression.charAt(i);
                if(ch == '+' || ch == '-' || ch =='*') {
                    operators.add(ch);
                    numbers.add(currNum);
                    currNum = 0;
                } else {
                    currNum = (currNum * 10) + (ch - '0');
                }
            }
            numbers.add(currNum);

            if(operators.size() == 0) return numbers;
            return  helper(numbers, operators, 0, numbers.size() - 1);
    }
    
    public List<Integer> helper(List<Integer> nums, List<Character> operators, int start, int end) {
        if(start == end) return List.of(nums.get(start));
        
        List<Integer> ans = new ArrayList<Integer>();
        for(int i = start; i < end; i++) {
            List<Integer> left = helper(nums, operators, start, i);
            List<Integer> right = helper(nums, operators, i + 1, end);
            for(int l : left) {
                for(int r : right) {
                    char op = operators.get(i);
                    if(op == '+') ans.add(l + r);
                    else if(op == '-') ans.add(l - r);
                    else ans.add(l * r);
                }
            }
        }
        
        return ans;
    }
}
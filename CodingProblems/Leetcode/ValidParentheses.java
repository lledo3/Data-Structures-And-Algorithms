/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 
Example 1:

Input: s = "()"
Output: true

Example 2:

Input: s = "()[]{}"
Output: true

Example 3:

Input: s = "(]"
Output: false

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
*/
class Solution {
	//TC: O(n)
	public boolean isValid(String s) {
        HashMap<Character,Character> maps=new HashMap<Character,Character>();
        maps.put(')','(');
        maps.put(']','[');
        maps.put('}','{');
        Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(maps.containsKey(c)){
                if(stack.empty() || stack.pop() != maps.get(c)) return false;
            }
            else
                stack.push(c);
        }
        return stack.empty();
    }

    public boolean isValid(String s) {
        if (s.isEmpty()) {
    		return true;
    	}
		if (s.length() % 2 == 1) {
            return false;
        }
		
		Stack<Character> ch = new Stack<>();
		char match;
		
		for(int i = 0; i < s.length(); i++) {
			match = s.charAt(i);
			if(match == '(' || match == '[' || match =='{') {
				ch.push(match);	
			}else if(match == ')') {
				if(ch.size() == 0 || ch.pop() != '(') {
					return false;
				}
			}
			else if(match == ']') {
				if(ch.size() == 0 || ch.pop() != '[') {
					return false;
				}
			}
			else if(match == '}') {
				if(ch.size() == 0 || ch.pop() != '{') {
					return false;
				}
			}
			else {
				continue;
			}
		}
		if(ch.isEmpty()) {
			return true;
		}else {
			return false;
		}	
    }
}
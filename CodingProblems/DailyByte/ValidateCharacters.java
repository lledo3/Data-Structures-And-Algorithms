/*
Given a string only containing the following characters (, ), {, }, [, and ] 
return whether or not the opening and closing characters are in a valid order.

Ex: Given the following strings...

"(){}[]", return true
"(({[]}))", return true
"{(})", return false
*/
public boolean validateCharacters(String s) {
    Stack<Character> stack = new Stack<Character>();
    for(char c: s.toCharArray()) {
        if(c == '(' || c == '[' || c == '{') {
            stack.push(c);
        } else if(c == ')' && (stack.isEmpty() || stack.peek() != '(')) {
            return false;
        } else if(c == ']' && (stack.isEmpty() || stack.peek() != '[')) {
            return false;
        } else if(c == '}' && (stack.isEmpty() || stack.peek() != '{')) {
            return false;
        } else {
            stack.pop();
        }
    }

    return stack.isEmpty();
}
/*
Big-O Analysis
Runtime: O(N) where N is the number of characters in our string. 
Space complexity: O(N) where N is the number of characters in our string.
*/
/*
Given a string s containing only lowercase letters, continuously remove adjacent characters that are the same and return the result.

Ex: Given the following strings...

s = "abccba", return ""
s = "foobar", return "fbar"
s = "abccbefggfe", return "a"
*/
public String removeAdjacentDuplicates(String s) {
    StringBuilder result = new StringBuilder();
    Stack<Character> stack = new Stack<>();
    for (char c: s.toCharArray()) {
        if (!stack.isEmpty() && c == stack.peek()) {
            stack.pop();
        } else {
            stack.push(c);
        }
    }

    while (!stack.isEmpty()) {
        result.append(stack.pop());
    }

    return result.reverse().toString();
}
/*
Big-O Analysis
Runtime: O(N) where N is the number of characters in s.
Space complexity: O(N) where N is the number of characters in s.
*/
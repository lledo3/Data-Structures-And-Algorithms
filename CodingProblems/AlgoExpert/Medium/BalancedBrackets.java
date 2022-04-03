/*
Write a function that takes in a string made up of brackets (([{}]))
and other optional characters. The function should return a
boolean representing whether the string is balanced with regards to brackets.

A string is said to be balanced if it has as many opening brackets of a
certain type as it has closing brackets of that type and if no bracket is
unmatched. Note that an opening bracket can't match a corresponding closing
bracket that comes before it, and similarly, a closing bracket can't match a
corresponding opening bracket that comes after it. Also, brackets can't
overlap each other as in [(]).

Sample Input:
string = "([])(){}(())()()"

Sample Output:
true
// it's balanced
*/
import java.util.*;

class Program {
  public static boolean balancedBrackets(String str) {
    Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); ++i){
		Character current = str.charAt(i);
		if (current == '(' || current == '[' || current == '{'){ 
			stack.add(current); 
		}
		else if (current == ')' || current == ']' || current == '}'){
			if (stack.size() == 0) { 
				return false; 
			}
			Character open = stack.pop();
			if (current == ')' && open != '(') { 
				return false; 
			}
			if (current == ']' && open != '[') { 
				return false; 
			}
			if (current == '}' && open != '{') { 
				return false; 
			}
		}
	}

	if (stack.size() > 0) { 
		return false; 
	}
	return true;
  }
}

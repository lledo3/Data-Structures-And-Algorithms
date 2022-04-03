/*
Write a function that takes in a string of words separated by one or more
whitespaces and returns a string that has these words in reverse order. For
example, given the string "tim is great", your function should return "great is tim".

For this problem, a word can contain special characters, punctuation, and
numbers. The words in the string will be separated by one or more whitespaces,
and the reversed string must contain the same whitespaces as the original
string. For example, given the string "whitespaces    4" you would be expected to return
"4    whitespaces".

Note that you're not use any built-in split and reverse methods/functions. However, you
are allowed to use a built-in join method/function.

Also note that the input string isn't guaranteed to always contain words.

Sample Input:
string = "AlgoExpert is the best!"

Sample Output:
"best! the is AlgoExpert"
*/
import java.util.*;

class Program {

  public String reverseWordsInString(String s) {
    // Write your code here.
    List<String> words = new ArrayList<>();
		int start = 0;
		
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(c == ' '){
				words.add(s.substring(start, i));
				start = i;
			}else if(s.charAt(start) == ' '){
				words.add(" ");
				start = i;
			}
		}
		words.add(s.substring(start));
		Collections.reverse(words);
		return String.join("", words);
  }
}

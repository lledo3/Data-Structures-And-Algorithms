/*
Write a function that, given a string, returns its longest palindromic
substring.

A palindrome is defined as a string that's written the same forward and
backward. Note that single-character strings are palindromes.

You can assume that there will only be one longest palindromic substring.

Sample Input:
string = "abaxyzzyxf"

Sample Output:
"xyzzyx"
*/
import java.util.*;

class Program {
  public static String longestPalindromicSubstring(String s) {
    // Write your code here.
    	int start = 0, end = 0;
			for(int i = 0; i < s.length(); i++){
			int odd = expand(s,i,i);
			int even = expand(s,i,i+1);
			int len = Math.max(odd, even);
			if(len > end-start){
				//Even len (6)-> 2 start --> i-2, end -> i+3
				//Odd len (5) -> 2 start i-2, end -> i+2
				start = i - (len-1)/2;
				end = i+ len/2;
			}
		}
		 return s.substring(start, end+1);
    }
    
    public static int expand(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}

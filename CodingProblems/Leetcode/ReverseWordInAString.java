/*
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. 
The returned string should only have a single space separating the words. Do not include any extra spaces.

Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"

Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.

Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 

Constraints:

1 <= s.length <= 10^4
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.
 

Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?
*/
class Solution {
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]).append(" ");
        }
        return sb.toString().trim();
    }
}

class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        
        char[] str = s.toCharArray();
        int start = 0;
        int end = str.length - 1;
        
        while(start <= end && str[start] == ' '){
            start += 1;
        }
        
        while(start <= end && str[end] == ' '){
            end -= 1;
        }
        
        reverse(str, start, end);
        
        int i = start;
        int j = start;
        int mark = start;
        
        while(j <= end){
            if(str[j] != ' '){
                str[mark] = str[j];
                mark += 1;
            }
            if(j == end || str[j] == ' '){
                reverse(str, i, mark -1);
                if(j == end){
                    break;
                }
                str[mark++] = ' ';
                i = mark;
                while(str[j] == ' '){
                    j += 1;
                }
                j -= 1;
            }
            j += 1;
        }
        
        return new String(str, start, mark - start);
    }
    
    public void reverse(char[] str, int i , int j){
        for(; i < j; i++, j--){
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }
}
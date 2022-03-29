/*
Given a character array s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by a single space.

Your code must solve the problem in-place, i.e. without allocating extra space.

Example 1:

Input: s = ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
Example 2:

Input: s = ["a"]
Output: ["a"]
 

Constraints:

1 <= s.length <= 10^5
s[i] is an English letter (uppercase or lowercase), digit, or space ' '.
There is at least one word in s.
s does not contain leading or trailing spaces.
All the words in s are guaranteed to be separated by a single space.
*/
class Solution {
    public void reverseWords(char[] s) {
        if(s == null || s.length == 0) return;
        
        int i = 0;
        int j = 0;
        while(j <= s.length){
            if(j == s.length || s[j] == ' '){
                reverse(s, i, j -1);
                i = j + 1;
            }
            j += 1;
        }
        reverse(s, 0, s.length - 1);
    }
    
    public void reverse(char[] str, int i , int j){
        for(; i < j; i++, j--){
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }
}
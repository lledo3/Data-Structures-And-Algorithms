/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is 
being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. 
For example, there will not be input like 3a or 2[4].

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"

Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"

Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
 

Constraints:

1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300].
*/
class Solution {
    public String decodeString(String s) {
        Stack<Integer> counts = new Stack();
        Stack<String> result = new Stack();
        String res = "";
        int idx = 0;
        
        while(idx < s.length()){
            if(Character.isDigit(s.charAt(idx))){
                int count = 0;
                while(Character.isDigit(s.charAt(idx))){
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx += 1;
                }
                counts.push(count);
            }else if(s.charAt(idx) == '['){
                result.push(res);
                res = "";
                idx += 1;
            }else if(s.charAt(idx) == ']'){
                StringBuilder sb = new StringBuilder(result.pop());
                int count = counts.pop();
                for(int i = 0; i < count; i++){
                    sb.append(res);
                }
                res = sb.toString();
                idx += 1;
            }else{
                res += s.charAt(idx);
                idx += 1;
            }
        }
        return res;
    }
}
/*
Complexity Analysis

Assume, nn is the length of the string ss.

Time Complexity: O(maxK⋅n), where maxK is the maximum value of kk and nn is the length of a given string ss. We traverse a string of size nn and 
iterate kk times to decode each pattern of form \text{k[string]}k[string]. This gives us worst case time complexity as O(maxK⋅n).

Space Complexity: O(m+n), where mm is the number of letters(a-z) and nn is the number of digits(0-9) in string ss. In worst case, the maximum size of 
stringStack and countStack could be mm and nn respectively.
*/
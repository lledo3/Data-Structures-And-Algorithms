/*
Given two strings, determine if they share a common substring. A substring may be as small as one character.

Example

These share the common substring .
These do not share a substring.

Function Description

Complete the function twoStrings in the editor below.

twoStrings has the following parameter(s):

string s1: a string
string s2: another string
Returns

string: either YES or NO
Input Format

The first line contains a single integer , the number of test cases.

The following  pairs of lines are as follows:

The first line contains string .
The second line contains string .
Constraints

 and  consist of characters in the range ascii[a-z].
Output Format

For each pair of strings, return YES or NO.
*/
public class Result {
    public static String twoStrings(String s1, String s2) {
        // Write your code here
        int count = 0;
        HashMap<Character, Integer> sOne = new HashMap<>();
        for(Character ch : s1.toCharArray()){
            sOne.put(ch, 1);
        }
        for(int i = 0; i < s2.length() - 1; i++){
            char c = s2.charAt(i);
            if(sOne.containsKey(c)){
                 count += 1;
            }
        }
        if(count > 0){
            return new String("YES");
        }
        return new String("NO");
        }
}
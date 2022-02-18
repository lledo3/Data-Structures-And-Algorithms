/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:
string convert(string s, int numRows);

Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I

Example 3:

Input: s = "A", numRows = 1
Output: "A"
 

Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
*/
class Solution {
    public String convert(String s, int numRows) {
        //1. divide string into char[], create StringBuilder obj so it
        //can store and append values
        char[] c = s.toCharArray();
        int len = s.length();
        StringBuilder[] sb = new StringBuilder[numRows];
        int idx = 0;
        
        //initialize the stringbuilder
        for(int i = 0; i < numRows; i++){
            sb[i] = new StringBuilder();
        }
        
        //vertical column
        while(idx < len){
            //first column
            for(int i = 0; idx < len && i < sb.length; i++){
                sb[i].append(c[idx++]);
            }
            //second column
            for(int i = sb.length - 2; idx < len && i > 0; i--){
                sb[i].append(c[idx++]);
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < sb.length; i++){
            result.append(sb[i]);
        }
        
        return result.toString();
    }
}
/*
In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL", a move consists of either replacing one occurrence 
of "XL" with "LX", or replacing one occurrence of "RX" with "XR". Given the starting string start and the ending string end, 
return True if and only if there exists a sequence of moves to transform one string to the other.

Example 1:

Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
Output: true
Explanation: We can transform start to end following these steps:
RXXLRXRXL ->
XRXLRXRXL ->
XRLXRXRXL ->
XRLXXRRXL ->
XRLXXRRLX

Example 2:

Input: start = "X", end = "L"
Output: false
 

Constraints:

1 <= start.length <= 10^4
start.length == end.length
Both start and end will only consist of characters in 'L', 'R', and 'X'
*/
class Solution {
    public boolean canTransform(String start, String end) {
        if (start.length() != end.length()) return false;
        int rnum = 0, lnum = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == 'R') {
                rnum++;
            }
            if (start.charAt(i) == 'L') {
                lnum--;
            }
			// if there are R need to move to right , but there are some L obstacles 
            if (rnum > 0 && lnum != 0) return false;
            if (end.charAt(i) == 'R') {
                rnum--;
            }
            if (end.charAt(i) == 'L') {
                lnum++;
            }
			// there are R in right , or L in left
            if (rnum < 0 || lnum < 0) return false;
			// there are obstacles when we move R or L;
            if (rnum > 0 && lnum > 0) return false;
        }
        return rnum == 0 && lnum == 0;
    }
}

/*
RXXLRXRXL
XRLXXRRLX
*/
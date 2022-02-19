/*
Given two strings s and t, return the number of distinct subsequences of s which equals t.

A string's subsequence is a new string formed from the original string by deleting some (can be none) of 
the characters without disturbing the remaining characters' relative positions. 
(i.e., "ACE" is a subsequence of "ABCDE" while "AEC" is not).

The test cases are generated so that the answer fits on a 32-bit signed integer.

Example 1:

Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from S.
rabbbit
rabbbit
rabbbit

Example 2:

Input: s = "babgbag", t = "bag"
Output: 5
Explanation:
As shown below, there are 5 ways you can generate "bag" from S.
babgbag
babgbag
babgbag
babgbag
babgbag
 

Constraints:

1 <= s.length, t.length <= 1000
s and t consist of English letters.
*/
class Solution {
    public int numDistinct(String s, String t) {
        //Bottom up approach
        char[] sArr = s.toCharArray(), tArr = t.toCharArray();
        int sLen = sArr.length, tLen = tArr.length;
        
        //Base case 
        if(sLen < tLen) return 0;
        
        int[][] cache = new int[tLen + 1][sLen + 1];
        
        //Build the first row
        Arrays.fill(cache[0], 1);
        
        for(int row = 1; row <= tLen; row++){
            for(int col = 1; col <= sLen; col++){
                if(sArr[col - 1] == tArr[row - 1]){
                    cache[row][col] = cache[row - 1][col - 1] + cache[row][col - 1];
                }else{
                    cache[row][col] = cache[row][col - 1];
                }
            }
        }
        return cache[tLen][sLen];
    }
}
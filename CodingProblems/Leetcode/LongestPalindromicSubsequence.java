/*
Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no 
elements without changing the order of the remaining elements.

Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".

Example 2:

Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".
 

Constraints:

1 <= s.length <= 1000
s consists only of lowercase English letters.
*/
class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] arr = s.toCharArray();
        
        int N = arr.length;
        
        int[][] dp = new int[N][N];
        
        for(int i = N - 1; i >= 0; i--){
            dp[i][i] = 1;
            for(int j = i + 1; j < N; j++){
                if(arr[i] == arr[j]){
                    dp[i][j] = 2;
                    if(i + 1 < j){
                        dp[i][j] += dp[i + 1][j - 1];
                    }
                }else{
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][N - 1];
    }
}
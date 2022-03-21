/*
Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example 1:

Input: matrix = 
[
["1","0","1","0","0"],
["1","0","1","1","1"],
["1","1","1","1","1"],
["1","0","0","1","0"]
]
Output: 4

Example 2:

Input: matrix = 
[
["0","1"],
["1","0"]
]
Output: 1

Example 3:

Input: matrix = [["0"]]
Output: 0
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 300
matrix[i][j] is '0' or '1'.
*/
class Solution {
    public int maximalSquare(char[][] matrix) {
        //Bottom-Up approach
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int maxWidth = 0;
        
        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                if(matrix[i - 1][j - 1] == '1'){
                    int top = dp[i - 1][j];
                    int left = dp[i][j - 1];
                    int topLeft = dp[i - 1][j - 1];
                    int min = Math.min(top, Math.min(left, topLeft));
                    dp[i][j] = min + 1;
                    
                    //update the max width
                    maxWidth = Math.max(maxWidth, dp[i][j]);
                }
            }
        }
        return maxWidth * maxWidth;
    }
}
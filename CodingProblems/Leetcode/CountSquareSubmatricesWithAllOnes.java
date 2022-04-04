/*
Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.

Example 2:

Input: matrix = 
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
Explanation: 
There are 6 squares of side 1.  
There is 1 square of side 2. 
Total number of squares = 6 + 1 = 7.
 

Constraints:

1 <= arr.length <= 300
1 <= arr[0].length <= 300
0 <= arr[i][j] <= 1
*/
class Solution {
    public int countSquares(int[][] matrix) {
        int i, j;
        int count = 0;
        int row = matrix.length;
        int col =  matrix[0].length;
        int[][] dp = new int[row][col];
        
        //set first column
        for(i = 0; i < row; i++){
            dp[i][0] = matrix[i][0];
        }
        
        //set first row
        for(j = 0; j < col; j++){
            dp[0][j] = matrix[0][j];
        }
        
        for(i = 1; i < row; i++){
            for(j = 1; j < col; j++){
                if(matrix[i][j] == 1){
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        //use dp arr to count numb of squares we found
        for(i = 0; i < row; i++){
            for(j = 0; j < col; j++){
                count += dp[i][j];
            }
        }
        return count;
    }
}
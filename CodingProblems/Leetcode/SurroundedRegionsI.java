/*
Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example 1:

Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation: Surrounded regions should not be on the border, which means that any 'O' on the border of the 
board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. 
Two cells are connected if they are adjacent cells connected horizontally or vertically.

Example 2:

Input: board = [["X"]]
Output: [["X"]]
 

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'.
*/
class Solution {
    public void solve(char[][] board) {
       if(board.length == 0 || board[0].length == 0){
           return;
       }
        
        int row = board.length;
        int col = board[0].length;
        
        //check the left most column and right most column
        for(int i = 0; i < row; i++){
            if(board[i][0] == 'O') boundaryDfs(board, i, 0);
            //System.out.println(board[i][0] + "");
            if(board[i][col - 1] == 'O') boundaryDfs(board, i, col - 1);
            //System.out.println(board[i][col - 1] + "");
        }
        
        //check top row and bottom row
        for(int i = 0; i < col; i++){
            if(board[0][i] == 'O') boundaryDfs(board, 0, i);
            //System.out.print(board[0][i] + "");
            if(board[row - 1][i] == 'O') boundaryDfs(board, row - 1, i);
            //System.out.print(board[row - 1][i] + "");
        }
        
        //process '*' back to '0' and any 'O' not on a boarder to an 'X'
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                    //System.out.println(board[i][j] + "");
                }else if(board[i][j] == '*'){
                    board[i][j] = 'O';
                    //System.out.println(board[i][j] + "");
                }
            }
        }
    }
    public void boundaryDfs(char[][] board, int i, int j){
        board[i][j] = '*';
        
        int[] xAxis = {-1, 0, 1, 0};
        int[] yAxis = {0, 1, 0, -1};
        
        //4 directions
        for(int k = 0; k < 4; k++){
            int x = i + xAxis[k];
            int y = j + yAxis[k];
            
            if(x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == '0'){
                boundaryDfs(board, x, y);
            }
        }  
    }
}
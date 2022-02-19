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
    final char temp = '*';
    final char X = 'X';
    final char O = 'O';
    int m, n;
    char[][] board;

    public void solve(char[][] board) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        // iterate the columns border to find O
        for (int row = 0; row < m; row++) {
            dfs(row, 0);
            dfs(row, n - 1);
        }
        // iterate the rows border to find O
        for (int col = 0; col < n; col++) {
            dfs(0, col);
            dfs(m - 1, col);
        }
        // traverse the grid to convert O to X
        for (int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++){
                if(board[row][col] == temp){
                    board[row][col] = O;
                }else if(board[row][col] == O){
                    board[row][col] = X;
                }
            }
        }
        
    }

    private void dfs(int row, int col) {
        if(row < 0 || row == m || col == n || col < 0) return;
        if(board[row][col] != O) return;
        board[row][col] = temp;
        //dfs all directions
        dfs(row + 1, col);
        dfs(row - 1, col);
        dfs(row, col + 1);
        dfs(row, col - 1);
    }
}
/*
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

 

Example 1:

Input: board = [["5","3",".",".","7",".",".",".","."],
				["6",".",".","1","9","5",".",".","."],
				[".","9","8",".",".",".",".","6","."],
				["8",".",".",".","6",".",".",".","3"],
				["4",".",".","8",".","3",".",".","1"],
				["7",".",".",".","2",".",".",".","6"],
				[".","6",".",".",".",".","2","8","."],
				[".",".",".","4","1","9",".",".","5"],
				[".",".",".",".","8",".",".","7","9"]]

Output: board = [["5","3","4","6","7","8","9","1","2"],
		 		 ["6","7","2","1","9","5","3","4","8"],
		         ["1","9","8","3","4","2","5","6","7"],
		         ["8","5","9","7","6","1","4","2","3"],
		         ["4","2","6","8","5","3","7","9","1"],
		         ["7","1","3","9","2","4","8","5","6"],
		         ["9","6","1","5","3","7","2","8","4"],
		         ["2","8","7","4","1","9","6","3","5"],
		         ["3","4","5","2","8","6","1","7","9"]]

Explanation: The input board is shown above and the only valid solution is shown below:

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit or '.'.
It is guaranteed that the input board has only one solution.
*/
class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
        solve(board);
    }
    public boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){//row
            for(int j = 0; j < board[0].length; j++){//column
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){//Try 1 through 9
                        if(isValid(board, i, j, c)){
                            board[i][j] = c; //Put c for this cell

                            if(solve(board))
                                return true; //If it's the solution return true
                            else
                                board[i][j] = '.'; //Otherwise go back
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValid(char[][] board, int row, int col, char c){
        int nRow = 3 * (row / 3); //normalized row
        int nCol = 3 * ( col /3); //normalized column
        for(int i = 0; i < 9; i++){
            if(board[i][col] == c) return false; //check row
            if(board[row][i] == c) return false; //check colum
            if(board[nRow + i / 3][nCol + i % 3] == c) return false; //check 3x3 block
        }
        return true;
    }
}
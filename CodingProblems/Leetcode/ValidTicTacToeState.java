/*
Given a Tic-Tac-Toe board as a string array board, return true if and only if it is possible to reach this board position during the course of a 
valid tic-tac-toe game.

The board is a 3 x 3 array that consists of characters ' ', 'X', and 'O'. The ' ' character represents an empty square.

Here are the rules of Tic-Tac-Toe:

Players take turns placing characters into empty squares ' '.
The first player always places 'X' characters, while the second player always places 'O' characters.
'X' and 'O' characters are always placed into empty squares, never filled ones.
The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
The game also ends if all squares are non-empty.
No more moves can be played if the game is over.

Example 1:

Input: board = ["O  ","   ","   "]
Output: false
Explanation: The first player always plays "X".

Example 2:

Input: board = ["XOX"," X ","   "]
Output: false
Explanation: Players take turns making moves.

Example 3:

Input: board = ["XOX","O O","XOX"]
Output: true
 

Constraints:

board.length == 3
board[i].length == 3
board[i][j] is either 'X', 'O', or ' '.
*/
class Solution {
    public boolean didXWin(String[] board){
    for(String row : board)
        if(row.equals("XXX"))
            return true;
    
    for(int i = 0; i < 3; i++)
        if(board[0].charAt(i) == 'X' && board[1].charAt(i) == 'X' && board[2].charAt(i) == 'X')
            return true;
    
    if(board[0].charAt(0) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(2) == 'X')
        return true;
    
    if(board[0].charAt(2) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(0) == 'X')
        return true;
    
    return false;
}

public boolean didOWin(String[] board){
    for(String row : board)
        if(row.equals("OOO"))
            return true;
    
    for(int i = 0; i < 3; i++)
        if(board[0].charAt(i) == 'O' && board[1].charAt(i) == 'O' && board[2].charAt(i) == 'O')
            return true;
    
    if(board[0].charAt(0) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(2) == 'O')
        return true;
    
    if(board[0].charAt(2) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(0) == 'O')
        return true;
    
    return false;
}

public boolean validTicTacToe(String[] board) {
    int countX = 0, countO = 0;
    
    boolean didXWin = didXWin(board),
            didOWin = didOWin(board);
    
    if(didXWin && didOWin)
        return false;
    
    for(String row : board){
        for(char ch : row.toCharArray()){
            if(ch == 'O')
                countO++;
            else if(ch == 'X')
                countX++;
        }
    }
    
    if(didXWin){
        return countO == countX - 1;
    }
    
    if(didOWin){
        return countO == countX;
    }
    
    return countO == countX || countO == countX - 1;
}
}
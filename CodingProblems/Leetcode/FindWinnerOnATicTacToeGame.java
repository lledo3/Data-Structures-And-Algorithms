/*
Tic-tac-toe is played by two players A and B on a 3 x 3 grid. The rules of Tic-Tac-Toe are:

Players take turns placing characters into empty squares ' '.
The first player A always places 'X' characters, while the second player B always places 'O' characters.
'X' and 'O' characters are always placed into empty squares, never on filled ones.
The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
The game also ends if all squares are non-empty.
No more moves can be played if the game is over.
Given a 2D integer array moves where moves[i] = [rowi, coli] indicates that the ith move will be played on grid[rowi][coli]. 
return the winner of the game if it exists (A or B). In case the game ends in a draw return "Draw". If there are still movements 
to play return "Pending".

You can assume that moves is valid (i.e., it follows the rules of Tic-Tac-Toe), the grid is initially empty, and A will play first.

Example 1:

Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
Output: "A"
Explanation: A wins, they always play first.

Example 2:

Input: moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
Output: "B"
Explanation: B wins.

Example 3:

Input: moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
Output: "Draw"
Explanation: The game ends in a draw since there are no moves to make.
 

Constraints:

1 <= moves.length <= 9
moves[i].length == 2
0 <= rowi, coli <= 2
There are no repeated elements on moves.
moves follow the rules of tic tac toe.
*/
class Solution {
    public String tictactoe(int[][] moves) {
    char[][] resultBoard = new char[3][3];
    char ch = 'X';
    String result;

    for (int i = 0; i < resultBoard.length; i++)
        for (int j = 0; j < resultBoard[0].length; j++)
            resultBoard[i][j] = ' ';

    for (int i = 0; i < moves.length; i++) {
        resultBoard[moves[i][0]][moves[i][1]] = ch;

        if (ch == 'X')
            ch = 'O';
        else
            ch = 'X';

        result = checkWinner(resultBoard);

        if (result != "nothing")
            return result;
    }

    if (moves.length < 9)
        return "Pending";

    return "Draw";
}

public String checkWinner(char[][] resultBoard) {
    // Check rows
    for (int i = 0; i <= 2; i++) {
        if (resultBoard[i][0] != ' ' && resultBoard[i][0] == resultBoard[i][1] && resultBoard[i][1] == resultBoard[i][2]) {
            if (resultBoard[i][0] == 'X')
                return "A";

            return "B";
        }
    }

    // Check colomns
    for (int j = 0; j <= 2; j++) {
        if (resultBoard[0][j] != ' ' && resultBoard[0][j] == resultBoard[1][j] && resultBoard[1][j] == resultBoard[2][j]) {
            if (resultBoard[0][j] == 'X')
                return "A";

            return "B";
        }
    }

    // Check diagonals 
    if (resultBoard[1][1] != ' ' && ((resultBoard[0][0] == resultBoard[1][1] && resultBoard[1][1] == resultBoard[2][2]) ||
                                     (resultBoard[0][2] == resultBoard[1][1] && resultBoard[1][1] == resultBoard[2][0]))) {
        if (resultBoard[1][1] == 'X')
            return "A";

        return "B";
    }

    return "nothing";
}
}
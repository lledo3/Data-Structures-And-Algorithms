/*
Backtracking
Given a 2D board that represents a word search puzzle and a string word, return whether or the given 
word can be formed in the puzzle by only connecting cells horizontally and vertically.

Ex: Given the following board and words…

board =
[
  ['C','A','T','F'],
  ['B','G','E','S'],
  ['I','T','A','E']
]

word = "CAT", return true
word = "TEA", return true
word = "SEAT", return true
word = "BAT", return false
*/
public boolean exist(char[][] board, String word) {
    for(int i = 0; i < board.length; i++) {
        for(int j = 0; j < board[i].length; j++) {
            if(board[i][j] == word.charAt(0) && search(board, i, j, 0, word)) {
                return true;
            }
        }
    }

    return false;
}

public boolean search(char[][] board, int i, int j, int count, String word) {
    if(count == word.length()) {
        return true;
    }

    if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(count)) {
        return false;
    }

    char temp = board[i][j];
    board[i][j] = ' ';
    boolean found = search(board, i + 1, j, count + 1, word)
        || search(board, i - 1, j, count + 1, word)
        || search(board, i, j + 1, count + 1, word)
        || search(board, i, j - 1, count + 1, word);

    board[i][j] = temp;
    return found;
}
/*
Big-O Analysis
Runtime: O(N * 4^M) where N is the total number of cells in our board and M is the length of the word we are searching for. 
This results from (in the worst case) having 4 options at all of our N cells and traversing M neighboring cells from there.
Space complexity: O(M) where M is the length of our word. This results from having M levels of calls on our stack due to our recursion.
*/
/*
A ball is dropped into a special Galton board where at each level in the board the ball can only move right or down. 
Given that the Galton board has M rows and N columns, return the total number of unique ways the ball can arrive at 
the bottom right cell of the Galton board.

Ex: Given the following values of M and N…

M = 2, N = 2, return 2.
The possible paths are DOWN -> RIGHT and RIGHT -> DOWN 
Ex: Given the following values of M and N…

M = 4, N = 3, return 10.
*/
public int galtonBoard(int M, int N) {
    return findPaths(0, 0, new int[M][N]);
}

public int findPaths(int row, int col, int[][] memoize) {
    if (row >= memoize.length || col >= memoize[row].length) {
        return 0;
    } else if (row == memoize.length - 1 || col == memoize[row].length - 1) {
        return 1;
    } else if (memoize[row][col] > 0) {
        return memoize[row][col];
    } else {
        memoize[row][col] = findPaths(row + 1, col, memoize) + findPaths(row, col + 1, memoize);
        return memoize[row][col];
    }
}
/*
Big-O Analysis
Runtime: O(M * N) where M is the total number of rows in our board and N is the total number of columns in our board.
Space complexity: O(M * N) where M is the total number of rows in our board and N is the total number of columns in our board. 
This results from initializing our memoize array to remember solutions to our subproblems.
*/
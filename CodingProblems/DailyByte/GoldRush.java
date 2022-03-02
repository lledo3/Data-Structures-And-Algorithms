/*
Given a 2D matrix that represents a gold mine, where each cell’s value represents an amount of gold, 
return the maximum amount of gold you can collect given the following rules:

You may start and stop collecting gold from any position
You can never visit a cell that contains 0 gold
You cannot visit the same cell more than once
From the current cell, you may walk one cell to the left, right, up, or down
Ex: Given the following gold mine…

goldMine = [
    [0,2,0],
    [8,6,3],
    [0,9,0]
],

return 23 (start at 9 and then move to 6 and 8 respectively)
*/
public int getMaximumGold(int[][] goldMine) {
    int max = 0;
    int[][] directions = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };
    for (int i = 0; i < goldMine.length; i++) {
        for (int j = 0; j < goldMine[i].length; j++) {
            if (goldMine[i][j] != 0) {
                max = Math.max(max, collectGold(goldMine, directions, i, j));
            }
        }
    }

    return max;
}

public int collectGold(int[][] goldMine, int[][] directions, int i, int j) {
    if (i < 0 || i >= goldMine.length || j < 0 || j >= goldMine[i].length || goldMine[i][j] == 0) {
        return 0;
    }

    int original = goldMine[i][j];
    goldMine[i][j] = 0;
    int max = 0;
    for (int[] direction: directions) {
        max = Math.max(max, collectGold(goldMine, directions, i + direction[0], j + direction[1]));
    }

    goldMine[i][j] = original;
    return original + max;
}

/*
Big-O Analysis
Runtime: O(4N) where N is the total number of cells in our gold mine. This results from having four directions to travel at each of our N cells.
Space complexity: O(N) where N is the total number of cells in our grid (this results from having N levels of functions calls on our stack 
due to our recursion).
*/
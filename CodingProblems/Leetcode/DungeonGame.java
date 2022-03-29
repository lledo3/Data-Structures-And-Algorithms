/*
The demons had captured the princess and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of m x n rooms 
laid out in a 2D grid. Our valiant knight was initially positioned in the top-left room and must fight his way through dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons (represented by negative integers), so the knight loses health upon entering these rooms; 
other rooms are either empty (represented as 0) or contain magic orbs that increase the knight's health (represented by positive integers).

To reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

Return the knight's minimum initial health so that he can rescue the princess.

Note that any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.

Example 1:

Input: dungeon = [[-2,-3,3],[-5,-10,1],[10,30,-5]]
Output: 7
Explanation: The initial health of the knight must be at least 7 if he follows the optimal path: RIGHT-> RIGHT -> DOWN -> DOWN.

Example 2:

Input: dungeon = [[0]]
Output: 1
 

Constraints:

m == dungeon.length
n == dungeon[i].length
1 <= m, n <= 200
-1000 <= dungeon[i][j] <= 1000
*/
class Solution {
  int num = Integer.MAX_VALUE;
  int[][] dp;
  int rows, cols;

  public int getMinHealth(int currCell, int nextRow, int nextCol) {
    if (nextRow >= this.rows || nextCol >= this.cols)
      return num;
    int nextCell = this.dp[nextRow][nextCol];
    // hero needs at least 1 point to survive
    return Math.max(1, nextCell - currCell);
  }

  public int calculateMinimumHP(int[][] dungeon) {
    this.rows = dungeon.length;
    this.cols = dungeon[0].length;
    this.dp = new int[rows][cols];
    for (int[] arr : this.dp) {
      Arrays.fill(arr, this.num);
    }
    int currCell, rightHealth, downHealth, nextHealth, minHealth;
    for (int row = this.rows - 1; row >= 0; --row) {
      for (int col = this.cols - 1; col >= 0; --col) {
        currCell = dungeon[row][col];

        rightHealth = getMinHealth(currCell, row, col + 1);
        downHealth = getMinHealth(currCell, row + 1, col);
        nextHealth = Math.min(rightHealth, downHealth);

        if (nextHealth != num) {
          minHealth = nextHealth;
        } else {
          minHealth = currCell >= 0 ? 1 : 1 - currCell;
        }
        this.dp[row][col] = minHealth;
      }
    }
    return this.dp[0][0];
  }
}
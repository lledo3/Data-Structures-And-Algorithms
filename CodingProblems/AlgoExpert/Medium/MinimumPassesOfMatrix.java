/*
Given an M × N matrix of integers whose each cell can contain a negative, zero, or a positive value, 
determine the minimum number of passes required to convert all negative values in the matrix positive.

Only a non-zero positive value at cell (i, j) can convert negative values present at its adjacent cells 
(i-1, j), (i+1, j), (i, j-1), and (i, j+1), i.e., up, down, left and right.

The idea is to use Breadth–first Search as it is the shortest path problem. The algorithm can be implemented as follows:

Create a queue Q and enqueue cell coordinates of all positive numbers in the matrix. 
    Create another queue q to separate the positive numbers involved in the previous pass from the positive numbers in the current pass.
Do till first queue Q is empty:
    Copy contents of the original queue Q to the second queue q and empty the original queue.
    Do till second queue q is empty
        Remove the front node from queue q and check all four adjacent cells of the current cell.
        If any of the four adjacent cells is negative, make its value positive and enqueue it into queue Q.
    Increment number of passes by 1.
If all the nodes in the queue are processed, return the total number of passes.

We can find all the adjacent cells of the given cell by storing the relative position of movement from any cell in an array. 
For example, if the current cell is (x, y), we can move to (x + row[k], y + col[k]) cell for 0 <= k < 4 using the following arrays:

row[] = { -1, 0, 0, 1 }
col[] = { 0, -1, 1, 0 }
 
So, from any position (x, y), we can move to:
 
(x – 1, y)
(x, y – 1)
(x, y + 1)
(x + 1, y)
*/
import java.util.*;

class Program {
	// Below arrays detail all four possible movements from a cell
  // (top, right, bottom, and left)
  private int[] row = { -1, 0, 0, 1 };
  private int[] col = { 0, -1, 1, 0 };
	
	// Find the minimum number of passes required to convert all negative values
  // in the given matrix to positive
  public int minimumPassesOfMatrix(int[][] mat) {
    // Write your code here.
    // base case
        if (mat == null || mat.length == 0) {
            return 0;
        }
 
        // `M × N` matrix
        int M = mat.length;
        int N = mat[0].length;
 
        // create a queue to store cell coordinates of positive integers
        Queue<Point> Q = new ArrayDeque<>();
 
        // enqueue cell coordinates of all positive numbers in the matrix
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (mat[i][j] > 0) {
                    Q.add(new Point(i, j));
                }
            }
        }
 
        // to keep track of the time taken to make all numbers positive
        int passes = 0;
 
        // loop till all reachable negative numbers in the matrix are processed
        while (!Q.isEmpty())
        {
            // use two queues to separate positive numbers involved in the
            // previous pass with positive numbers involved in the current pass
            Queue<Point> q;
 
            // copy contents of the original queue `Q` to another queue `q` and
            // empty the original queue
            q = new ArrayDeque<>(Q);
            Q.clear();
 
            /* Start of the current pass */
 
            // process all cells in the queue
            while (!q.isEmpty())
            {
                // pop front node and process it
                int x = q.peek().x;
                int y = q.peek().y;
                q.poll();
 
                // check all four adjacent cells of the current cell
                for (int k = 0; k < row.length; k++)
                {
                    // if the current adjacent cell is valid and has a negative value
                    if (isValid(x + row[k], y + col[k], M, N) &&
                            mat[x + row[k]][y + col[k]] < 0)
                    {
                        // make the value positive
                        mat[x + row[k]][y + col[k]] = -mat[x + row[k]][y + col[k]];
 
                        // enqueue adjacent cell
                        Q.add(new Point(x + row[k], y + col[k]));
                    }
                }
            }
 
            /* End of the current pass */
 
            // increment number of passes by 1
            passes++;
        }
 
        // return number of passes or
        // -1 if the matrix has an unreachable cell which is negative
        return hasNegative(mat) ? -1 : (passes - 1);
  }
	
	// Function to check whether given coordinates is a valid cell or not
	public boolean isValid(int i, int j, int M, int N) {
			return (i >= 0 && i < M) && (j >= 0 && j < N);
	}
	
	// Returns true if the matrix contains at least one negative value
	public boolean hasNegative(int[][] mat){
			for (int i = 0; i < mat.length; i++)
			{
					for (int j = 0; j < mat[0].length; j++) {
							if (mat[i][j] < 0) {
									return true;
							}
					}
			}
			return false;
	}
}
class Point{
    int x, y;
 
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
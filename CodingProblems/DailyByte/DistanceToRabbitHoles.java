/*
Given a 2D array containing only the following values: -1, 0, 1 where -1 represents an obstacle, 0represents a rabbit hole, 
and 1represents a rabbit, update every cell containing a rabbit with the distance to its closest rabbit hole. 
Note: multiple rabbit may occupy a single rabbit hole and you may assume every rabbit can reach a rabbit hole. 
A rabbit can only move up, down, left, or right in a single move. Ex: Given the following grid…

-1  0  1
 1  1 -1
 1  1  0
your grid should look like the following after running the function...

-1  0  1
 2  1 -1
 2  1  0
Ex: Given the following grid…

 1  1  1
 1 -1 -1
 1  1  0
your grid should look like the following after running the function...

 4  5  6
 3 -1 -1
 2  1  0
*/
public void rabbitHoleDistances(int[][] rooms) {
    for(int i = 0; i < rooms.length; i++) {
        for(int j = 0; j < rooms[i].length; j++) {
            if(rooms[i][j] == 0) {
                dfs(i, j, 0, rooms);
            }
        }
    }
}

public void dfs(int i, int j, int count, int[][] rooms) {
    if(i < 0 || i >= rooms.length || j < 0 || j >= rooms[i].length || rooms[i][j] < count) {
        return;
    }

    rooms[i][j] = count;
    dfs(i + 1, j, count + 1, rooms);
    dfs(i - 1, j, count + 1, rooms);
    dfs(i, j + 1, count + 1, rooms);
    dfs(i, j - 1, count + 1, rooms);
}
/*
Big-O Analysis
Runtime: ON(^2) where N is the number of rows and columns in our gird (this worst case occurs when our grid is all rabbit holes 
and we therefore traverse every other cell for each cell). 
Space complexity: O(N^2) where N is the number of row sand columns in our grid (this overhead is caused by our recursive calls on the stack).
*/
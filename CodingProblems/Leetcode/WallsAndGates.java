/*
You are given an m x n grid rooms initialized with these three possible values.

-1 A wall or an obstacle.
0 A gate.
INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance 
to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

Example 1:

Input: rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
Output: [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]

Example 2:

Input: rooms = [[-1]]
Output: [[-1]]
 

Constraints:

m == rooms.length
n == rooms[i].length
1 <= m, n <= 250
rooms[i][j] is -1, 0, or 2^31 - 1.
*/
class Solution {
    
    public class Position {
        int row;
        int col;
        int distance;//shortest distance to the nearest gate
        
        Position(int row, int col, int distance){
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }
    
    public void wallsAndGates(int[][] rooms) {
        Queue<Position> queue = new LinkedList<>();
        int row = rooms.length;
        int col = rooms[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(rooms[i][j] == 0){
                    queue.add(new Position(i, j, 0));
                }
            }
        }
           
        if(queue.isEmpty()){
            return;
        }
        //BFS approach
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Position p = queue.poll();
                wallsAndGatesHelper(p.row, p.col, p.distance, rooms, queue);
            }
        }
    }
    
    public void wallsAndGatesHelper(int row, int col, int distance, int[][] rooms, Queue<Position> queue){
        if(row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE){//up
            queue.add(new Position(row - 1, col, distance + 1));
            rooms[row - 1][col] = distance + 1;
        }
        if(row < rooms.length - 1 && rooms[row + 1][col] == Integer.MAX_VALUE){//down
            queue.add(new Position(row + 1, col, distance + 1));
            rooms[row + 1][col] = distance + 1;
        }
        if(col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE){//left
            queue.add(new Position(row, col - 1, distance + 1));
            rooms[row][col - 1] = distance + 1;
        }
        if(col < rooms[0].length - 1 && rooms[row][col + 1] == Integer.MAX_VALUE){//right
            queue.add(new Position(row, col + 1, distance + 1));
            rooms[row][col + 1] = distance + 1;
        }
    }
        
}
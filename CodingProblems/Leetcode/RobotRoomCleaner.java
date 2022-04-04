/*
You are controlling a robot that is located somewhere in a room. The room is modeled as an m x n binary grid where 0 represents a wall and 1 
represents an empty slot.

The robot starts at an unknown location in the room that is guaranteed to be empty, and you do not have access to the grid, but you can move 
the robot using the given API Robot.

You are tasked to use the robot to clean the entire room (i.e., clean every empty cell in the room). The robot with the four given APIs can 
move forward, turn left, or turn right. Each turn is 90 degrees.

When the robot tries to move into a wall cell, its bumper sensor detects the obstacle, and it stays on the current cell.

Design an algorithm to clean the entire room using the following APIs:

interface Robot {
  // returns true if next cell is open and robot moves into the cell.
  // returns false if next cell is obstacle and robot stays on the current cell.
  boolean move();

  // Robot will stay on the same cell after calling turnLeft/turnRight.
  // Each turn will be 90 degrees.
  void turnLeft();
  void turnRight();

  // Clean the current cell.
  void clean();
}
Note that the initial direction of the robot will be facing up. You can assume all four edges of the grid are all surrounded by a wall.

 

Custom testing:

The input is only given to initialize the room and the robot's position internally. You must solve this problem "blindfolded". 
In other words, you must control the robot using only the four mentioned APIs without knowing the room layout and the initial robot's position.

Example 1:

Input: room = [[1,1,1,1,1,0,1,1],[1,1,1,1,1,0,1,1],[1,0,1,1,1,1,1,1],[0,0,0,1,0,0,0,0],[1,1,1,1,1,1,1,1]], row = 1, col = 3
Output: Robot cleaned all rooms.
Explanation: All grids in the room are marked by either 0 or 1.
0 means the cell is blocked, while 1 means the cell is accessible.
The robot initially starts at the position of row=1, col=3.
From the top left corner, its position is one row below and three columns right.
Example 2:

Input: room = [[1]], row = 0, col = 0
Output: Robot cleaned all rooms.
 

Constraints:

m == room.length
n == room[i].length
1 <= m <= 100
1 <= n <= 200
room[i][j] is either 0 or 1.
0 <= row < m
0 <= col < n
room[row][col] == 1
All the empty cells can be visited from the starting position.
*/
/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    //Up, Right, Down, Left
    public final int[][] DIRECTIONS = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    public Set<String> visited = new HashSet<>();
    public void cleanRoom(Robot robot) {
        dfs(0, 0, robot, 0);
    }
    public void dfs(int row, int col, Robot robot, int arrow){
        String key = row + "," + col;
        
        if(!visited.contains(key)){
            visited.add(key);
        
            robot.clean();

            for(int i = 0; i < 4; i++){
                if(robot.move()){
                    int[] curDirection = DIRECTIONS[arrow];//arrow is the index of the DIRECTIONS array
                    dfs(row + curDirection[0], col + curDirection[1], robot, arrow);
                }
                //Change robot direction and arrow
                robot.turnRight();//turn clock wise
                arrow = (arrow + 1) % 4;//this allows the arrow to loop back to beginning of the DIRECTIONS array
            }
        }
        //Move Back
        moveBack(robot);
    }
    public void moveBack(Robot robot){
        //Turn 180 degree back
        robot.turnLeft();
        robot.turnLeft();
        
        robot.move();
        
        //Turn back the original direction
        robot.turnRight();
        robot.turnRight();
    }
}
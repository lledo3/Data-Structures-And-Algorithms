/*
Given N points on a Cartesian plane, return the minimum time required to visit all points in the order that they’re given.
Note: You start at the first point and can move one unit vertically, horizontally, or diagonally in a single second.

Ex: Given the following points…

points = [[0, 0], [1,1], [2,2]], return 2.
In one second we can travel from [0, 0] to [1, 1]
In another second we can travel from [1, 1,] to [2, 2]
Ex: Given the following points…

points = [[0, 1], [2, 3], [4, 0]], return 5.
*/
public int travelToPoints(int[][] points) {
    int seconds = 0;
    for (int i = 1; i < points.length; i++) {
        int xMove = Math.abs(points[i][0] - points[i - 1][0]);
        int yMove = Math.abs(points[i][1] - points[i - 1][1]);
        seconds += Math.min(xMove, yMove) + Math.abs(xMove - yMove);
    }

    return seconds;
}
/*
Big-O Analysis
Runtime: O(N) where N is the total number of points in points.
Space complexity: O(1) or constant since regardless of the number of points we have we still only need a few variables to solve our problem.
*/
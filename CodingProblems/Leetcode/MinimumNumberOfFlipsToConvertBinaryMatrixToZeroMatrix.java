/*
Given a m x n binary matrix mat. In one step, you can choose one cell and flip it and all the four neighbors of it 
if they exist (Flip is changing 1 to 0 and 0 to 1). A pair of cells are called neighbors if they share one edge.

Return the minimum number of steps required to convert mat to a zero matrix or -1 if you cannot.

A binary matrix is a matrix with all cells equal to 0 or 1 only.

A zero matrix is a matrix with all cells equal to 0.

Example 1:

Input: mat = [[0,0],[0,1]]
Output: 3
Explanation: One possible solution is to flip (1, 0) then (0, 1) and finally (1, 1) as shown.

Example 2:

Input: mat = [[0]]
Output: 0
Explanation: Given matrix is a zero matrix. We do not need to change it.

Example 3:

Input: mat = [[1,0,0],[1,0,0]]
Output: -1
Explanation: Given matrix cannot be a zero matrix.
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 3
mat[i][j] is either 0 or 1.
*/
class Solution {
	//BFS
    public int minFlips(int[][] mat) {
     	int[][] dirs = {{0,1},{1,0},{0,0},{0,-1},{-1,0}};
        int rows=mat.length, cols=mat[0].length;
        
        int steps=0;

       // bitmask in int
     int start = 0;
        for(int i = 0; i <rows; i++) {
            for(int j = 0; j <cols; j++) {
                start = (start << 1) | mat[i][j];
            }
        }

        Queue<Integer> q = new LinkedList<>(Arrays.asList(start));
        Set<Integer> visited = new HashSet<>(start);
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                int cur = q.poll();
                if(cur == 0) 
                    return steps;
                for(int r=0;r<rows;r++) {
                    for(int c=0;c<cols;c++) {
                        int newPos=cur; 
						// then flip cells around [r][c]
                        for(int[] d:dirs) {
                            int rr=r+d[0], cc=c+d[1];
                            if(rr<0||rr>=rows||cc<0||cc>=cols) 
                                continue;
                            newPos ^= 1<<(rr*cols+cc); 
							// flip
                        }
                        if(visited.contains(newPos)) 
						    continue;
                        visited.add(newPos);
                        q.add(newPos);
                    }
                }
            }
            steps++;
        }
        return -1;
}
}
/*
You are given an empty 2D binary grid grid of size m x n. The grid represents a map where 0's represent water and 1's represent land. 
Initially, all the cells of grid are water cells (i.e., all the cells are 0's).

We may perform an add land operation which turns the water at position into a land. You are given an array positions where 
positions[i] = [ri, ci] is the position (ri, ci) at which we should operate the ith operation.

Return an array of integers answer where answer[i] is the number of islands after turning the cell (ri, ci) into a land.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four 
edges of the grid are all surrounded by water.

Example 1:

Input: m = 3, n = 3, positions = [[0,0],[0,1],[1,2],[2,1]]
Output: [1,1,2,3]
Explanation:
Initially, the 2d grid is filled with water.
- Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land. We have 1 island.
- Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land. We still have 1 island.
- Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land. We have 2 islands.
- Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land. We have 3 islands.
Example 2:

Input: m = 1, n = 1, positions = [[0,0]]
Output: [1]
 

Constraints:

1 <= m, n, positions.length <= 10^4
1 <= m * n <= 10^4
positions[i].length == 2
0 <= ri < m
0 <= ci < n
 

Follow up: Could you solve it in time complexity O(k log(mn)), where k == positions.length?
*/
class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();

        int islands = 0;
        int[] parent = new int[m*n];
        int[] size = new int[m*n];
        int[][] direction = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        // We initialize our disjoint set with all values at -1 to represent the water 
        Arrays.fill(parent, -1);

        for (int[] position : positions) {
            int r = position[0];
            int c = position[1];
            // This root value gives us the coordinate of "position" if we put it in the 1D array parent
            int root = r * n + c;
            // Check for duplicates; if it is a duplicate just record the current island count and continue onto the next coordinate
            if (parent[root] != -1) {
                ans.add(islands);
                continue;
            }
            // We are initializing the parent for the disjoint sets
            parent[root] = root;
            // We increase the size of the island at that coordinate, if its zero it becomes 1 and if not then its whatever size + 1
            size[root]++;
            // We will consider this an extra island for now
            islands++;

            // Check the 4 cardinal direction for potential neighboring islands
            for (int[] dir : direction) {
                int neighborR = r + dir[0];
                int neighborC = c + dir[1];
                int neighborUnion = neighborR * n + neighborC;
                // If any of these conditions are true we don't operate on the neighbor because they're not valid
                if (neighborR < 0 || neighborC < 0 || neighborR >= m || neighborC >= n || parent[neighborUnion] == -1) continue;
                // This is important; we need to see whether the islands are part of the same set or not
                int neighborRoot = find(parent, neighborUnion);
                int parentRoot = find(parent, root);
                // If they aren't, since they're neighboring they SHOULD be in the same set
                if (neighborRoot != parentRoot) {
                    // THIS IS KEY
                    // If the neighbor is land as well, we want to perform a union to have them in the same set
                    union(parent, size, parentRoot, neighborRoot);
                    // This line allows us to maintain the number of islands as if the original islands++ never happened
                    islands--;
                }
            }
            // Record the state of the island
            ans.add(islands);
        }
        return ans;
    }

    public void union(int[] parent, int[] size, int x, int y) {
        // Union by rank
        // Since we can check size, we make the smaller root a child of the larger one
        if (size[x] >= size[y]) {
			// If the set x is larger than y, we merge y into x and increase the tracker of sizes for x by the size of y
            size[x] += size[y];
			// We also set y to point towards the root parent of the set x
            parent[y] = x;
        }
        else {
			// Same as the previous step, but reversed
            size[y] += size[x];
            parent[x] = y;
        }
    }


    public int find(int[] parent, int x) {
        // We have path compression here
        if (parent[x] != x) {
			// Since the root of a set should always be parent[i] = i, we keep recursing until we find that root value i, and set the rest of the children to that parent
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}
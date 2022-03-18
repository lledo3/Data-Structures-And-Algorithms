/*
There are n cities numbered from 0 to n-1. Given the array edges where edges[i] = [fromi, toi, weighti] represents a bidirectional 
and weighted edge between cities fromi and toi, and given the integer distanceThreshold.

Return the city with the smallest number of cities that are reachable through some path and whose distance is at most distanceThreshold, 
If there are multiple such cities, return the city with the greatest number.

Notice that the distance of a path connecting cities i and j is equal to the sum of the edges' weights along that path.

Example 1:

0---3`---1
       / |
      /  |
     4`  1`
    /    |
   /     |
  3--1`--2

`: weight number

Input: n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold = 4
Output: 3
Explanation: The figure above describes the graph. 
The neighboring cities at a distanceThreshold = 4 for each city are:
City 0 -> [City 1, City 2] 
City 1 -> [City 0, City 2, City 3] 
City 2 -> [City 0, City 1, City 3] 
City 3 -> [City 1, City 2] 
Cities 0 and 3 have 2 neighboring cities at a distanceThreshold = 4, but we have to return city 3 since it has the greatest number.

Constraints:

2 <= n <= 100
1 <= edges.length <= n * (n - 1) / 2
edges[i].length == 3
0 <= fromi < toi < n
1 <= weighti, distanceThreshold <= 10^4
All pairs (fromi, toi) are distinct.
*/
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] nbrs = new int[n][n];

        // applying dikstra for each node
        for (int node = 0; node < n; node++) 
            nbrs[node] = dikstra(node, edges, n);

        // NOW TAKE THE VALUES AS PER CONDITION        
        int min = Integer.MAX_VALUE, CITY = 0;
        for (int city = 0; city < n; city++){
            int cnt = 0;
            for (int nbr = 0; nbr < n; nbr++){
                if (nbrs[city][nbr] > 0 && nbrs[city][nbr] <= distanceThreshold)
                    cnt++;
            }
            if (min >= cnt){
                min = cnt;
                CITY = city;
            }
        }
        
        return CITY;
    }
    public int[] dikstra(int node, int[][] edges, int n){
        int[] update = new int[n];
        
        for (int i = 0; i < n; i++){
            update[i] = Integer.MAX_VALUE;   
        }
        
        update[node] = 0;
        
        for (int i = 0; i < update.length; i++){
            for (int j = 0; j < edges.length; j++){
                int src = edges[j][0];
                int dst = edges[j][1];
                int wt = edges[j][2];
                if (update[src] != Integer.MAX_VALUE)
                    update[dst] = Math.min(update[dst], update[src] + wt);
                // since bidirectional
                dst = edges[j][0];
                src = edges[j][1];
                if (update[src] != Integer.MAX_VALUE)
                    update[dst] = Math.min(update[dst], update[src] + wt);
            }
        }
        return update;
    }
}
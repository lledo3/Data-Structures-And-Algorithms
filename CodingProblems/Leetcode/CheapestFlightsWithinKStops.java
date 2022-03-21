/*
There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] 
indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. 
If there is no such route, return -1.

Example 1:

Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
Output: 200
Explanation: The graph is shown.
The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.

Example 2:

Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
Output: 500
Explanation: The graph is shown.
The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
 

Constraints:

1 <= n <= 100
0 <= flights.length <= (n * (n - 1) / 2)
flights[i].length == 3
0 <= fromi, toi < n
fromi != toi
1 <= pricei <= 10^4
There will not be any multiple flights between two cities.
0 <= src, dst, k < n
src != dst
*/
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] g = new int[n][n];
        for (int[] f : flights) {
            g[f[0]][f[1]] = f[2];
        }

        // (1) adding the distance array to track min distance to each node
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE / 2);

        //  PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // (2) change heap to normal queue
        Queue<int[]> heap = new LinkedList<>();

        heap.offer(new int[]{0, src, k + 1});
        distance[src] = 0;

        while (!heap.isEmpty()) {
            int[] cur = heap.poll();
            int price = cur[0], place = cur[1], remainStops = cur[2];
            
          //  if (place == dst) return price;
            
            if (remainStops > 0) {
                for (int i = 0; i < n; i++) {
                    if (g[place][i] > 0 && distance[i] >= price + g[place][i]) {                        
                        heap.offer(new int[]{price + g[place][i], i, remainStops - 1});
                        distance[i] = price + g[place][i];
                    }
                }
            }
        }
        
        return distance[dst] == Integer.MAX_VALUE / 2 ? -1 : distance[dst];
    }
}
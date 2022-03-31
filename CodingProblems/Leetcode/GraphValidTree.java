/*
You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a list of edges where 
edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the graph.

Return true if the edges of the given graph make up a valid tree, and false otherwise.

Example 1:

Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
Output: true

Example 2:

Input: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
Output: false
 

Constraints:

1 <= n <= 2000
0 <= edges.length <= 5000
edges[i].length == 2
0 <= ai, bi < n
ai != bi
There are no self-loops or repeated edges.
*/
class Solution {
    public boolean validTree(int n, int[][] edges) {
        // n must be at least 1
        if (n < 1) return false;

        // create hashmap to store info of edges
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(i, new HashSet<>());
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        // bfs starts with node in label "0"
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int top = queue.remove();
            // if set already contains top, then the graph has cycle
            // hence return false
            if (set.contains(top)) return false;

            for (int node : map.get(top)) {
                queue.add(node);
                // we should remove the edge: node -> top
                // after adding a node into set to avoid duplicate
                // since we already consider top -> node
                map.get(node).remove(top);
            }
            set.add(top);
        }
        return set.size() == n;
    }
}
/*
You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] 
indicates that there is an edge between ai and bi in the graph.

Return the number of connected components in the graph.

Example 1:

Input: n = 5, edges = [[0,1],[1,2],[3,4]]
Output: 2

Example 2:

Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
Output: 1
 

Constraints:

1 <= n <= 2000
1 <= edges.length <= 5000
edges[i].length == 2
0 <= ai <= bi < n
ai != bi
There are no repeated edges.
*/
class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] ids = new int[n];
        //point all nodes to themselves
        for(int i = 0; i < ids.length; i++){
            ids[i] = i;
        }
        for(int[] edge : edges){
            union(edge[0], edge[1], ids);
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < ids.length; i++){
            set.add(find(i, ids));
        }
        return set.size();
    }
    public void union(int edge1, int edge2, int[] ids){
        int parent1 = find(edge1, ids);
        int parent2 = find(edge2, ids);
        ids[parent1] = parent2;
    }
    public int find(int edge, int[] ids){
        if(ids[edge] != edge){
            ids[edge] = find(ids[edge], ids);
        }
        return ids[edge];
    }
}
/*
A tree is an undirected graph in which any two vertices are connected by exactly one path. 
In other words, any connected graph without simple cycles is a tree.

Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] 
indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose 
any node of the tree as the root. When you select a node x as the root, the result tree has height h. 
Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).

Return a list of all MHTs' root labels. You can return the answer in any order.

The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.

Example 1:

Input: n = 4, edges = [[1,0],[1,2],[1,3]]
Output: [1]
Explanation: As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.

Example 2:

Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
Output: [3,4]
 

Constraints:

1 <= n <= 2 * 10^4
edges.length == n - 1
0 <= ai, bi < n
ai != bi
All the pairs (ai, bi) are distinct.
The given input is guaranteed to be a tree and there will be no repeated edges.
*/
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if(n == 0) return res;
        if(n == 1){
            res.add(0);
            return res;
        }
        
        int[] degree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] e : edges){
            degree[e[0]]++;
            degree[e[1]]++;
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        //BFS
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            if(degree[i] == 1){
                q.add(i);
            }
        }
        
        while(n > 2){
            int size = q.size();
            n -= size;
            while(size-- > 0){
                int v = q.poll();
                for(int i : adj.get(v)){
                    degree[i]--;
                    if(degree[i] == 1){
                        q.add(i);
                    }
                }
            }
        }
        res.addAll(q);
        return res;
    }
}
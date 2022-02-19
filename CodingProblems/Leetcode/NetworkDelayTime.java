/*
You are given a network of n nodes, labeled from 1 to n. You are also given times, 
a list of travel times as directed edges times[i] = (ui, vi, wi), 
where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal. 
If it is impossible for all the n nodes to receive the signal, return -1.

Example 1:

Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2

Example 2:

Input: times = [[1,2,1]], n = 2, k = 1
Output: 1

Example 3:

Input: times = [[1,2,1]], n = 2, k = 2
Output: -1
 

Constraints:

1 <= k <= n <= 100
1 <= times.length <= 6000
times[i].length == 3
1 <= ui, vi <= n
ui != vi
0 <= wi <= 100
All the pairs (ui, vi) are unique. (i.e., no multiple edges.)
*/
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //Graph table - constant time search to find the contections between nodes
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] time : times){
            int u = time[0]; //source node
            int v = time[1]; //target node
            int w = time[2]; //time
            if(!graph.containsKey(u)){
                graph.put(u, new LinkedList<int[]>());
            }
            graph.get(u).add(new int[]{v, w});
        }
        
        //Min Heap definition - sorted by the weight
        Queue<int[]> minHeap = new PriorityQueue<>((a,b)->a[1] - b[1]);
        
        //Hashset to track visited nodes
        Set<Integer> visited = new HashSet<>();
        
        minHeap.add(new int[]{k, 0});
        
        int res = 0;
        
        //BFS Implementation
        while(!minHeap.isEmpty()){
            int[] top = minHeap.poll();
            int src = top[0];
            int weight = top[1];
            if(visited.contains(src)){
                continue;
            }
            res = weight;
            visited.add(src);
            if(!graph.containsKey(src)){
                continue;
            }
            for(int[] edge : graph.get(src)){
                int tar = edge[0];
                int tarWeight = edge[1];
                minHeap.add(new int[]{tar, weight + tarWeight});
            }
        }
        return visited.size() == n ? res : -1;
    }
}
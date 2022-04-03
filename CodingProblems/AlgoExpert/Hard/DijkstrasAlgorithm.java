/*
Write a function that computes the lengths of the shortest paths between start
and all of the other vertices in the graph using Dijkstra's algorithm and returns 
them in an array. Each index i in the output array should represent the length 
of the shortest path between start and vertex i. If no path is found from
start to vertext i, then output[i] should -1.

Sample Input:
start = 0
edges = [
  [[1, 7]],
  [[2, 6], [3, 20], [4, 3]],
  [[3, 14]],
  [[4, 2]],
  [],
  [],
]

Sample Output
[0, 7, 13, 27, 10, -1]
*/
import java.util.*;

class Program {
  public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
    // Write your code here.
    int numberOfVer = edges.length;
		
		int[] minDistances = new int[edges.length];
		Arrays.fill(minDistances, Integer.MAX_VALUE);
		minDistances[start] = 0;
		
		Set<Integer> visited = new HashSet<>();
		
		while(visited.size() != numberOfVer){
			int[] getVertexData = getVertexMinDistance(minDistances, visited);
			int vertex = getVertexData[0];
			int currMinDistance = getVertexData[1];
			
			if(currMinDistance == Integer.MAX_VALUE){
				break;
			}
			
			visited.add(vertex);
			
			for(int[] edge : edges[vertex]){
				int destination = edge[0];
				int distanceToDestination = edge[1];
				
				if(visited.contains(destination)){
					continue;
				}
				
				int newPathDistance = currMinDistance + distanceToDestination;
				int currDestinationDistance = minDistances[destination];
				if(newPathDistance < currDestinationDistance){
					minDistances[destination] = newPathDistance;
				}
			}
		}
		
		int[] finalDistances = new int[minDistances.length];
		for(int i = 0; i < minDistances.length; i++){
			int distance = minDistances[i];
			if(distance == Integer.MAX_VALUE){
				finalDistances[i] = -1;
			}else{
				finalDistances[i] = distance;
			}
		}
		return finalDistances;
  }
	public int[] getVertexMinDistance(int[] minDistances, Set<Integer> visited){
		int currMinDistance = Integer.MAX_VALUE;
		int vertex = -1;
		
		for(int i = 0; i < minDistances.length; i++){
			int distance = minDistances[i];
			
			if(visited.contains(i)){
				continue;
			}
			
			if(distance <= currMinDistance){
				vertex = i;
				currMinDistance = distance;
			}
		}
		return new int[]{vertex, currMinDistance};
	}
}

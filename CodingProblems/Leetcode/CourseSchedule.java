/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must 
take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.

Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 

Constraints:

1 <= numCourses <= 10^5
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.
*/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] degree = new int[numCourses];
        for(int i =0; i<numCourses; i++){
            graph.put(i, new ArrayList());
        }
        for(int[] prereq: prerequisites){
            int course = prereq[1];
            int dependent = prereq[0];
            List<Integer> dependentList = graph.get(course);
            dependentList.add(dependent);
            graph.put(course, dependentList);
            degree[dependent]++;         
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<degree.length; i++){
            if(degree[i]==0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int curr = queue.poll();
            numCourses--;
            for(int dep: graph.get(curr)){
                degree[dep]--;
                if(degree[dep]==0){
                    queue.offer(dep);
                }
            }
        }
        return numCourses == 0;
    }
}
/*
You are given an array of points in the X-Y plane points where points[i] = [xi, yi].

Return the minimum area of a rectangle formed from these points, with sides parallel to the X and Y axes. 
If there is not any such rectangle, return 0.

Example 1:

Input: points = [[1,1],[1,3],[3,1],[3,3],[2,2]]
Output: 4

Example 2:

Input: points = [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
Output: 2
 

Constraints:

1 <= points.length <= 500
points[i].length == 2
0 <= xi, yi <= 4 * 10^4
All the given points are unique.
*/
class Solution {
    public int minAreaRect(int[][] points) {
        Map<Integer,Set<Integer>> map = new HashMap<>();
        
        for(int[] p : points){
            if(!map.containsKey(p[0])){
                map.put(p[0], new HashSet<>());
            }
            map.get(p[0]).add(p[1]);
        }
        
        int minArea = Integer.MAX_VALUE;
        
        for(int[] p1 : points){
            for(int[] p2 : points){
                if(p1[0] == p2[0] || p1[1] == p2[1]){
                    continue;
                }
                if(map.get(p2[0]).contains(p1[1]) && map.get(p1[0]).contains(p2[1])){
                    minArea = Math.min(minArea, Math.abs(p2[0] - p1[0]) * Math.abs(p2[1] - p1[1]));
                }   
            }
        }
        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }
}
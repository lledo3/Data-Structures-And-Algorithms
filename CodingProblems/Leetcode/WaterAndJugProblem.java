/*
You are given two jugs with capacities jug1Capacity and jug2Capacity liters. There is an infinite amount of water supply available. 
Determine whether it is possible to measure exactly targetCapacity liters using these two jugs.

If targetCapacity liters of water are measurable, you must have targetCapacity liters of water contained within one or both buckets by the end.

Operations allowed:

Fill any of the jugs with water.
Empty any of the jugs.
Pour water from one jug into another till the other jug is completely full, or the first jug itself is empty.
 

Example 1:

Input: jug1Capacity = 3, jug2Capacity = 5, targetCapacity = 4
Output: true
Explanation: The famous Die Hard example 

Example 2:

Input: jug1Capacity = 2, jug2Capacity = 6, targetCapacity = 5
Output: false

Example 3:

Input: jug1Capacity = 1, jug2Capacity = 2, targetCapacity = 3
Output: true
 

Constraints:

1 <= jug1Capacity, jug2Capacity, targetCapacity <= 10^6
*/
class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity + jug2Capacity < targetCapacity)
             return false;
         Queue<Integer> queue = new LinkedList();
         Set<Integer> visited = new HashSet();
         int[] dirs = new int[]{jug1Capacity, -jug1Capacity, jug2Capacity, -jug2Capacity};
         queue.offer(0);
         visited.add(0);
         while(!queue.isEmpty()){
             int size = queue.size();
             while(size-->0){
                 int curr = queue.poll();
                 if (curr == targetCapacity)
                     return true;
                 for(int dir:dirs){
                     int newCurr = curr + dir;
                     if(newCurr > 0 && newCurr <= (jug1Capacity + jug2Capacity) && !visited.contains(newCurr)){
                         queue.add(newCurr);
                         visited.add(newCurr);
                     }
                 }
             }
         }
         return false;
    }
}
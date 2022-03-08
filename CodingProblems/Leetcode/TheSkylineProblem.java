/*
A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. 
Given the locations and heights of all the buildings, return the skyline formed by these buildings collectively.

The geometric information of each building is given in the array buildings where buildings[i] = [lefti, righti, heighti]:

lefti is the x coordinate of the left edge of the ith building.
righti is the x coordinate of the right edge of the ith building.
heighti is the height of the ith building.
You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

The skyline should be represented as a list of "key points" sorted by their x-coordinate in the form [[x1,y1],[x2,y2],...]. 
Each key point is the left endpoint of some horizontal segment in the skyline except the last point in the list, which always 
has a y-coordinate 0 and is used to mark the skyline's termination where the rightmost building ends. Any ground between the 
leftmost and rightmost buildings should be part of the skyline's contour.

Note: There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...,[2 3],[4 5],[7 5],[11 5],[12 7],...] 
is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...,[2 3],[4 5],[12 7],...]

Example 1:

Input: buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
Output: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
Explanation:
Figure A shows the buildings of the input.
Figure B shows the skyline formed by those buildings. The red points in figure B represent the key points in the output list.

Example 2:

Input: buildings = [[0,2,3],[2,5,3]]
Output: [[0,3],[5,0]]
 

Constraints:

1 <= buildings.length <= 10^4
0 <= lefti < righti <= 2^31 - 1
1 <= heighti <= 2^31 - 1
buildings is sorted by lefti in non-decreasing order.
*/
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int prev = 0;
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();
        for(int[] b : buildings){
            heights.add(new int[]{b[0],-b[2]});
            heights.add(new int[]{b[1],b[2]});
        }
        Collections.sort(heights, (a,b) -> {
           if(a[0] != b[0]) return a[0] - b[0];
            else return a[1] - b[1];
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        pq.offer(0);
        
        for(int[] h : heights){
            if(h[1] < 0){
                pq.offer(-h[1]);
            }else{
                pq.remove(h[1]);
            }
            int curr = pq.peek();
            if(prev != curr){
                List<Integer> temp = new ArrayList<>();
                temp.add(h[0]);
                temp.add(curr);
                res.add(temp);
                prev = curr;
            }
        }
        
        return res;
    }
}


/*
Find the pattern based on the input
Key points for the problem:
1. mark start and end point of each building
    - we can use some flag or mark the height as positive (+) and negative (-) value
    2 9 10 2 -> -10 9 -> 10 (negative value denote the start) (positive value denote the end)
2. mark all consecutive buildings (overlapping)
    [2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]
    [2,-10],[9,10],[3,-15],[7,15],[5,-12],[12,12].......
    sort values in ascending order on x axis:
    [2,-10],[3,-15],[5,-12],[7,15],[9,10],[12,12]
3. get max y value for each x axis value
    PriorityQueue -> define the priority so that biggest building is always on top of the queue
4. everytime the height flips we have an answer
    maintain some previous value for comparison
*/
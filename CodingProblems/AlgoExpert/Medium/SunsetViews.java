/*
Given an array of buildings and a direction that all of the buildings face,
return an array of the indices of the buildings that can see the sunset.

A building can see the sunset if it's strictly taller than all of the
buildings that come after it in the direction that it faces.

The input array named buildings contains positive, non-zero
integers representing the heights of the buildings. A building at index i
thus has a height denoted by buildings[i]. All of the buildings face the same direction, 
and this direction is either east or west, denoted by the input string named direction
, which will always be equal to either "EAST" or "WEST". 
In relation to the input array, you can interpret these directions as right for
east and left for west.

Important note: the indices in the ouput array should be sorted in ascending
order.

Sample Input #1
buildings = [3, 5, 4, 4, 3, 1, 3, 2]
direction = "EAST"

Sample Output #1
[1, 3, 6, 7]
// Below is a visual representation of the sample input.
//    _
//   | |_ _
//  _| | | |_   _
// | | | | | | | |_
// | | | | | |_| | |
// |_|_|_|_|_|_|_|_|

Sample Input #2
buidlings = [3, 5, 4, 4, 3, 1, 3, 2]
direction = "WEST"

Sample Output #2
[0, 1]
// The buildings are the same as in the first sample
// input, but their direction is reversed.
*/
import java.util.*;

class Program {

  public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
    // Write your code here.
		ArrayList<Integer> views = new ArrayList<>();
		
		int start = buildings.length - 1;
		int step = -1;
		
		if(direction.equals("WEST")){
			start = 0;
			step = 1;
		}
		
		int idx = start;
		int runningMaxHeight = 0;
		
		while(idx >= 0 && idx < buildings.length){
			int height = buildings[idx];
			if(height > runningMaxHeight){
				views.add(idx);
			}
			runningMaxHeight = Math.max(runningMaxHeight, height);
			idx += step;
		}
		if(direction.equals("EAST")){
			Collections.reverse(views);
		}
    return views;
  }
}

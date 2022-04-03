/*
Find the largest range in the given array. Range is a set of consecutive integers. The numbers don't have to be adjacent.

EXAMPLE:
[1,11,3,0,15,5,2,4,10,7,12,6] -> [0,7]
*/
import java.util.*;

class Program {
	// time : O(n)  space : O(n)
  public static int[] largestRange(int[] array) {
    // Write your code here.
    HashMap<Integer, Boolean> map = new HashMap<> ();
        for (int x : array)
        { map.put(x, false); }

        int start = array[0];
        int end = array[0];

        for (int x : array)
        {
            if (!map.get(x))
            {
                int [] current = expand(x, map);
                int currentStart = current[0];
                int currentEnd = current[1];
                if (currentEnd - currentStart > end - start)
                {
                    end = currentEnd;
                    start = currentStart;
                }
            }
        }
        return new int[] {start, end};
  }
	public static int [] expand(int x, HashMap<Integer, Boolean> map)
    {
        int start = x;
        int end = x;
        while(map.containsKey(start))
        {
            map.put(start, true);
            start -= 1;
        }
        while(map.containsKey(end))
        {
            map.put(end, true);
            end += 1;
        }
        return new int [] {start + 1, end - 1};
    }
}

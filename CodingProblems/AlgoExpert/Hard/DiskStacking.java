/*
PROBLEM:
Given an array of disks. Each disk has width, depth and height (in order).
Stack them up to achieve maximum height. A disk must have strictly smaller width, depth and height than any disk below it.
Return the disks used in the stack.

EXAMPLE:
[ [2,1,2], [3,2,3], [2,2,8], [2,3,4], [1,3,1], [4,4,5] ] -> [ [2,1,2], [3,2,3], [4,4,5] ]

SOLUTION:
1. Sort & DP -> time : O(n^2) | space : O(n)
- sort by (height + width + depth)
- then dynamic programming on sorted disks
- important part is overiding compare / compareTo
*/
import java.util.*;

class CustomComparator implements Comparator<Integer []> {
    @Override
    public int compare(Integer [] disk1, Integer [] disk2) {
        Integer first = (disk1[0] + disk1[1] + disk1[2]) / 3;
        Integer second = (disk2[0] + disk2[1] + disk2[2]) / 3;
        return first.compareTo(second);
    }
}

class Program {
  public static List<Integer[]> diskStacking(List<Integer[]> disks) {
    // Write your code here.
    Collections.sort(disks, new CustomComparator()); // or disks.sort( (disk1, disk2) -> disk1[2].compareTo(disk2[2]) )

		int[] prevIdx = new int[disks.size()];
		int[] maxHeightYet = new int[disks.size()];

		int maxHeight = 0;
		int maxHeightIdx = -1;
		for (int i = 0; i < disks.size(); i++) {
			Integer[] bottomDisk = disks.get(i);
			maxHeightYet[i] = disks.get(i)[2];
			prevIdx[i] = -1;

			int j = i - 1;
			while (j >= 0) {
				Integer[] topDisk = disks.get(j);
				if (bottomDisk[0] > topDisk[0] && bottomDisk[1] > topDisk[1] && bottomDisk[2] > topDisk[2]) {
					// consider
					if (maxHeightYet[i] < disks.get(i)[2] + maxHeightYet[j]) {
						maxHeightYet[i] = disks.get(i)[2] + maxHeightYet[j];
						prevIdx[i] = j;
					}
				}
				j--;
			}
			if (maxHeight < maxHeightYet[i]) {
				maxHeight = maxHeightYet[i];
				maxHeightIdx = i;
			}
		}

		List<Integer[]> solution = new ArrayList<Integer[]>();
		while (maxHeightIdx != -1){
			solution.add(disks.get(maxHeightIdx));
			maxHeightIdx = prevIdx[maxHeightIdx];
		}
		Collections.reverse(solution);

		return solution;
  }
}

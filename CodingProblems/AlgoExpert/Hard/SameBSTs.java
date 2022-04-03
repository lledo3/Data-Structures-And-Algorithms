/*
PROBLEM:
Given two arrays of integers each representing BSTs (formed by inserting elements in array left to right)
- without actually constructing a BST return if the arrays represent the same BSTs

EXAMPLE:
[10,15,8,5], [10,8,15,5] -> true
both represent the BST
        10
       /  \
      8    15
     /
    5

LOGIC:
- root value & length of arrays needs to be same
- values less than root will be in left subtree & greater than root will be in right subtree
- use recursion to check roots of Left-Left & Right-Right subtrees of the given arrays
SOLUTIONS:
1. Recursion : time -> O(n^2) | space -> O(n^2) - at each level of recursion we have O(n) | n is the length of arrays
*/
import java.util.*;

class Program {
  public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
    // Write your code here.
        if (arrayOne.size() == 0 && arrayTwo.size() == 0) { return true; }
        if (arrayOne.size() != arrayTwo.size() || arrayOne.get(0).intValue() != arrayTwo.get(0).intValue()) { return false; }

        List<Integer> firstLeftSubtree = smallerThanRoot(arrayOne);
        List<Integer> secondLeftSubtree = smallerThanRoot(arrayTwo);

        List<Integer> firstRightSubtree = equalOrGreaterThanRoot(arrayOne);
        List<Integer> secondRightSubtree = equalOrGreaterThanRoot(arrayTwo);

        return sameBsts(firstLeftSubtree, secondLeftSubtree) && sameBsts(firstRightSubtree, secondRightSubtree);
  }
        public static List<Integer> smallerThanRoot(List<Integer> array)
    {
        List<Integer> smaller = new ArrayList<Integer>();
        if (array.size() < 2) { return smaller; }

        int root = array.get(0).intValue();
        for (int i = 1; i < array.size(); ++i)
        {
            if ( array.get(i).intValue() < root) { smaller.add(array.get(i).intValue()); }
        }
        return smaller;
    }

    public static List<Integer> equalOrGreaterThanRoot(List<Integer> array)
    {
        List<Integer> larger = new ArrayList<Integer>();
        if (array.size() < 2) { return larger; }

        int root = array.get(0).intValue();
        for (int i = 1; i < array.size(); ++i)
        {
            if ( array.get(i).intValue() >= root) { larger.add(array.get(i).intValue()); }
        }
        return larger;
    }
}

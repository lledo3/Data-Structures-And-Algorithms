/*
  Write a function that takes in a non-empty array of distinct integers and an
  integer representing a target sum. The function should find all quadruplets in
  the array that sum up to the target sum and return a two-dimensional array of
  all these quadruplets in no particular order.


  If no four numbers sum up to the target sum, the function should return an
  empty array.

  Sample Input: array = [7, 6, 4, -1, 1, 2] targetSum = 16

  Sample Output: [[7, 6, 4, -1], [7, 6, 1, 2]] // the quadruplets could be ordered differently

*/
import java.util.*;

class Program {
  public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
    // Write your code here.
    List<Integer[]> ans = new ArrayList<>();
    Arrays.sort(array);

    for (int i = 0; i < array.length - 3; i++) {

      if (i != 0 && array[i] == array[i - 1]) {
        continue;
      }

      for (int j = i + 1; j < array.length - 2; j++) {

        if (j != i + 1 && array[j] == array[j - 1]) {
          continue;
        }

        int left = j + 1;
        int right = array.length - 1;

        while (left < right) {
          int sum = array[i] + array[j] + array[left] + array[right];

          if (sum < targetSum) {
            left++;
          } else if (sum > targetSum) {
            right--;
          } else {
            // sum == target
            Integer[] combination = {array[i],array[j],array[left],array[right]};
            ans.add(combination);

            left++;
            right--;

            while (left < right && array[left] == array[left - 1]) {
              left++;
            }

            while (left < right && array[right] == array[right + 1]) {
              right--;
            }
          }
        }
      }
    }
    return ans;
  }
}

/*
PROBLEM:
Given array of items with values and weights (in order) and maximum capacity of knapsack.
Maximize value in knapsack without exceeding capacity.
- items cannot be repeated
- assume there will be only one combination of items that maximizes the total value in knapsack
Output Format -> [[max_value_within_capacity], [indexes of items chosen]]

EXAMPLE:
[ [1,2], [4,3], [5,6], [6,7] ], 10 ->  [ [10], [1,3]]

LOGIC:
- item can be either added to knapsack or left out
- create a 2D array with rows representing the items until that point | col representing capacity | entry representing max_value_achievable_till
if capacity > currentWeight:
    - then item can be added
    - maxValue[row][col] = max (item not added, item added)
    - maxValue[row][col] = max (maxValue[row - 1][col], maxValues[row - 1][c - currentWeight] + currentValue)
- in backtracking just check if we added the item or not (currentValue == value at [row - 1] or not)

SOLUTION:
1. Dynamic Programming & Backtracking (to find indexes) -> time : O(nc) | space : O(nc)
*/
import java.util.*;

class Program {
  public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
    // Write your code here.
    int maxValues [][] = new int[items.length + 1][capacity+1];

    for (int row = 1; row < maxValues.length; ++row){
        int currentValue = items[row - 1][0];
        int currentWeight = items[row - 1][1];

        for (int c = 0; c <= capacity; ++c){
            if (c < currentWeight){
                // item not added
                maxValues[row][c] = maxValues[row - 1][c];
            }
            else{
                // item can be added
                maxValues[row][c] = Math.max(maxValues[row - 1][c], maxValues[row - 1][c - currentWeight] + currentValue);
            }
        }
    }
    return generateSolution(maxValues, items);
  }
    public static List<List<Integer>> generateSolution(int[][] maxValues, int[][] items){
        List<List<Integer>> solution = new ArrayList<List<Integer>> ();
        List<Integer> maxValue =  new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();

        int row = maxValues.length - 1;
        int col = maxValues[0].length - 1;
        maxValue.add(maxValues[row][col]);
        solution.add(maxValue);

        while (row > 0 && col >= 0){
            // checks if we added the item to the knapsack?
            if (maxValues[row][col] == maxValues[row - 1][col]){// not added
                row = row - 1;
            }else{ // added
                indexes.add(0, row - 1); // insert at front otherwise need to reverse
                row = row - 1;
                col = col -  items[row][1]; // itemWeight
            }
        }
        solution.add(indexes);
        return solution;
    }
}

/*
Write a function that takes in an array of unique integers and returns its powerset.

The powerset P(X) of set X is the set of all subsets of X. For example, the pwoerset
of [1,2] is [[], [1], [2], [1,2]].

Note that the sets in the powerset do not need to be in any particular order.
*/
import java.util.*;

class Program {
  public static List<List<Integer>> powerset(List<Integer> array) {
    // Write your code here.
    List<List<Integer>> solution = new ArrayList<>();
	solution.add(new ArrayList<Integer>());

	for (Integer elem : array){
		int length = solution.size();
		for (int i = 0; i < length; ++i){
			ArrayList<Integer> current = new ArrayList<Integer> (solution.get(i));
			current.add(elem);
			solution.add(current);
		}
	}
	return solution;
  }
}
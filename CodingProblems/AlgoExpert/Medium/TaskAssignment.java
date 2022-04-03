/*
You're given an integer k representing a number of workers and an
  array of positive integers representing durations of tasks that must be
  completed by the workers. Specifically, each worker must complete two unique
  tasks and can only work on one task at a time. The number of tasks will always
  be equal to 2k such that each worker always has exactly two tasks
  to complete. All tasks are independent of one another and can be completed in
  any order. Workers will complete their assigned tasks in parallel, and the
  time taken to complete all tasks will be equal to the time taken to complete
  the longest pair of tasks (see the sample output for an explanation).


  Write a function that returns the optimal assignment of tasks to each worker
  such that the tasks are completed as fast as possible. Your function should
  return a list of pairs, where each pair stores the indices of the tasks that
  should be completed by one worker. The pairs should be in the following
  format: where the order of and task2  doesn't matter. Your function can return the pairs in any
  order. If multiple optimal assignments exist, any correct answer will be
  accepted.

  Sample Input
  k = 3
  task  = [1, 3, 5, 3, 1, 4]

  Sample Output
  [
  [0, 2], // tasks[0] = 1, tasks[2] = 5 | 1 + 5 = 6
  [4, 5], // tasks[4] = 1, tasks[5] = 4 | 1 + 4 = 5
  [1, 3], // tasks[1] = 3, tasks[3] = 3 | 3 + 3 = 6
  ] // The fastest time to complete all tasks is 6.

  // Note: there are multiple correct answers for this sample input.
  // The following is an example of another correct answer:
  // [
  // [2, 4],
  // [0, 5],
  // [1, 3]
  // [
*/
import java.util.*;
/*
COMPLEXITY : 
		TIME = O(NlogN) space
		SPACE = O(N) space : storing hashmap and indices via LinkedList data structure
		Referneces are really powerful too : address.function() invocation is going on UNDER THE HOOD() for objects ( e.g. arraylist.addLast())
*/
class Program {

  public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
    // Write your code here.
    ArrayList<ArrayList<Integer>> assignment = new ArrayList<ArrayList<Integer>>();
		HashMap<Integer, LinkedList<Integer>> hm = new HashMap<Integer, LinkedList<Integer>>();
		for(int i = 0; i < tasks.size(); ++i)
		{
			int key = tasks.get(i);
			LinkedList<Integer> cur;
			if(!hm.containsKey(key))
				cur = new LinkedList<Integer>();
			else
				cur = hm.get(key);
			cur.addLast(i);
			hm.put(key, cur);
		}
		
		// Iterate over tasks ArrayList
		Collections.sort(tasks);
		for(int i = 0; i < (tasks.size()/2); ++i)
		{
			int task_one = tasks.get(i);
			int task_two = tasks.get(tasks.size() - 1 - i);
			ArrayList<Integer> newTaskPair = new ArrayList<Integer>();
			newTaskPair.add(hm.get(task_one).getFirst());
			newTaskPair.add(hm.get(task_two).getFirst());
			hm.get(task_one).removeFirst();
			hm.get(task_two).removeFirst();
			assignment.add(newTaskPair);
		}
		
		return assignment;
  }
}

/*
ROUGH
-----
Input -> list of jobs ; dependencies  d1 -> d2
Output -> order of execution

EXAMPLE
========
Input : [1,2,3,4], [ [1,2], [1,3], [3,2], [4,2], [4,3]]
Output : [1,4,3,2] or [4,1,3,2]

LOGIC (DFS)
===========
create hash map for each job
create set for each traversed
go through the dependencies
at each job : add list of dependencies | O(d)
{
1 : []
2 : [1, 4]
3 : [1, 2, 4]
4 : []
}
for each key | if not traversed
if empty -> add
if not empty -> go to first node & remove first node O(n)
also need cycle detection

SOLUTION
========
1. DFS
time : O(j + d) | space : O(j + d)
space complexity of a graph outweighs the complexity you get from DFS
*/
import java.util.*;

class Program {
  public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
    // Write your code here.
    Set<Integer> traversed = new HashSet<Integer> ();
		Map<Integer, List<Integer> > dependencies = new HashMap<>();
		addDependencies(deps, dependencies);

		ArrayList<Integer> solution = new ArrayList<>();
		for (int job : jobs)
		{
				Set<Integer> currentCall = new HashSet<Integer> ();
				boolean cycle = traverse(job, traversed, dependencies, solution, currentCall );
				if (cycle) { return new ArrayList<Integer>(); }
		}
		return solution;
  }
	public static void addDependencies(List<Integer[]> deps, Map<Integer, List<Integer> > dependencies )
    {
        for (Integer [] pair : deps)
        {
            int job = pair[1];
            int dependsOn = pair[0];

            if (!dependencies.containsKey(job))
            {
                ArrayList<Integer> d = new ArrayList<Integer> ();
                d.add(dependsOn);
                dependencies.put(job, d);
            }
            else
            {
                List<Integer> d  = dependencies.get(job);
                d.add(dependsOn);
                dependencies.put(job, d);
            }
        }
    }

    public static boolean traverse(int job, Set<Integer> traversed, Map<Integer, List<Integer>> dependencies, ArrayList<Integer> solution, Set<Integer> currentCall )
    {
        if (currentCall.contains(job)) { return true; }
        currentCall.add(job);

        if (traversed.contains(job)) { return false; }

        boolean cycle = false;
        if (dependencies.containsKey(job))
        {
            List<Integer> dependsOn = dependencies.get(job); // dependsOn
            for (int d : dependsOn)
            {
                if (traversed.contains(d)) { continue; }
                cycle = cycle || traverse(d, traversed, dependencies, solution, currentCall);
            }
        }
        solution.add(job);
        traversed.add(job);
        currentCall.remove(job);
        return cycle;
    }
}

/*
You are given two lists of integers and an integer representing a process id to kill. One of the lists represents a 
list of process ids and the other represents a list of each of the processes’ corresponding (by index) parent ids. 
When a process is killed, all of its children should be reaped (i.e. also killed). Return a list of all the process ids 
that are killed as a result of killing the requested process.

Ex: Given the following…

pid =  [2, 4, 3, 7]
ppid = [0, 2, 2, 3]
kill = 3
the tree of processes can be represented as follows:
           2
         /   \
        4     3
             /
            7
return [3, 7] as killing process 3 will also require killing its child (i.e. process 7).
*/
public List<Integer> killDescendants(List<Integer> pid, List<Integer> ppid, int kill) {
    Map<Integer, List<Integer>> parentToChildren = new HashMap<>();
    for (int i = 0; i < ppid.size(); i++) {
        parentToChildren.putIfAbsent(ppid.get(i), new ArrayList<>());
        parentToChildren.get(ppid.get(i)).add(pid.get(i));
    }

    List<Integer> killed = new ArrayList<>();
    Queue<Integer> queue = new LinkedList<>();
    queue.add(kill);
    while (!queue.isEmpty()) {
        int current = queue.remove();
        killed.add(current);
        if (parentToChildren.containsKey(current)) {
            queue.addAll(parentToChildren.get(current));
        }
    }

    return killed;
}
/*
Big-O Analysis
Runtime: O(N) where N is the number of processes we’re given. 
Space complexity: O(N) where N is the number of processes we’re given.
*/
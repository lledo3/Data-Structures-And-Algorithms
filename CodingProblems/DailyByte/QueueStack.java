/*
Design a class to implement a stack using only a single queue. 
Your class, QueueStack, should support the following stack methods: 
push() (adding an item), 
pop() (removing an item), 
peek() (returning the top value without removing it), 
and empty() (whether or not the stack is empty).
*/
class QueueStack {
    Queue<Integer> queue;

    // Initializes our QueueStack.
    public QueueStack() {
        queue = new LinkedList<Integer>();
    }

    // Adds a value to the QueueStack.
    public void push(int val) {
        int size = queue.size();
        queue.add(val);
        for (int i = 0; i < size; i++) {
            queue.add(queue.remove());
        }
    }

    // Returns the top value of our QueueStack.
    public int pop() {
        if (empty()) {
            return -1;
        }

        return queue.remove();
    }

    // Returns the top value of our QueueStack,
    // but does not remove it. Returns -1
    // if the QueueStack is empty.
    public int peek() {
        if (empty()) {
            return -1;
        }

        return queue.peek();
    }

    // Returns whether or not our QueueStack is empty.
    public bolean empty() {
        return queue.size() == 0;
    }
}
/*
Big-O Analysis
Runtime: All of our operations run in constant time except push() which is O(M) where M is the current 
number of elements in our QueueStack (because every time we add a new item we must iterate through our entire queue)
Space complexity: O(N) where N is the total number of items we are allowed to hold in our queue.
*/
/*
Write a MinMaxStack class for a Min Max Stack. The class should support:
Pushing and popping values on and off the stack.
Peeking at the value at the top of the stack.
Getting both the minimum and the maximum values in the stack at any given point in time.

All class methods, when considered independently, should run in constant time
and with constant space.
*/
import java.util.*;

class Program {
  // Feel free to add new properties and methods to the class.
  static class MinMaxStack {
		List<Map<String,Integer>> minMaxStack = new ArrayList<>();
		List<Integer> stack = new ArrayList<>();
		
		//O(1) time | O(1) space
    public int peek() {
      // Write your code here.
      return stack.get(stack.size() - 1);
    }
		
		//O(1) time | O(1) space
    public int pop() {
      // Write your code here.
			minMaxStack.remove(minMaxStack.size() - 1);
      return stack.remove(stack.size() - 1);
    }
		
		//O(1) time | O(1) space
    public void push(Integer number) {
      // Write your code here.
		Map<String,Integer> newMinMax = new HashMap<>();
		newMinMax.put("min", number);
		newMinMax.put("max", number);
		if(minMaxStack.size() > 0){
			Map<String,Integer> lastMinMax = new HashMap<>(minMaxStack.get(minMaxStack.size() - 1));
			newMinMax.replace("min", Math.min(lastMinMax.get("min"), number));
			newMinMax.replace("max", Math.max(lastMinMax.get("max"), number));
		}
		minMaxStack.add(newMinMax);
		stack.add(number);
    }
		
		//O(1) time | O(1) space
    public int getMin() {
      // Write your code here.
      return minMaxStack.get(minMaxStack.size() - 1).get("min");
    }
		
		//O(1) time | O(1) space
    public int getMax() {
      // Write your code here.
      return minMaxStack.get(minMaxStack.size() - 1).get("max");
    }
  }
}

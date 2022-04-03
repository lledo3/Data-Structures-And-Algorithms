/*
You're given two positive integers representing the height of a staircase and
the maximum number of steps that you can advance up the staircase at a time.
Write a function that returns the number of ways in which you can climb the
staircase.

For example, if you were given a staircase of height = 3 and maxSteps = 2
you could climb the staircase in 3 ways. You could take 1 step, 1 step, then 1 step, 
you could also take 1 step, then 2 steps, and you could take 2 steps, then 1 step.

Note that maxSteps <= height will always be true.

Sample Input
height = 4
maxSteps = 2

Sample Output
5
// You can climb the staircase in the following ways: 
// 1, 1, 1, 1
// 1, 1, 2
// 1, 2, 1
// 2, 1, 1
// 2, 2
*/
import java.util.*;

class Program {

  public int staircaseTraversal(int height, int maxSteps) {
    // Write your code here.
    return waysToTop(height, maxSteps);
  }
	public int waysToTop(int height, int maxSteps){
		if(height <= 1){
			return 1;
		}
		int numOfWays = 0;
		for(int step = 1; step < Math.min(maxSteps, height) + 1; step++){
			numOfWays += waysToTop(height - step, maxSteps);
		}
		return numOfWays;
	}
}
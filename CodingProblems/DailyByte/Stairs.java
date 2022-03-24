/*
Given a staircase with N steps and the ability to climb either one or two steps at a time, return the total number of ways 
to arrive at the top of the staircase.

Ex: Given the following value of N…

N = 2, return 2
1 step + 1 step
2 steps
Ex: Given the following value of N…

N = 3, return 3
1 step + 1 step + 1 step
1 step + 2 steps
2 steps + 1 step
*/
public int stairs(int n) {
    if(n == 1) {
        return 1;
    }

    int first = 1;
    int second = 2;
    for(int i = 3; i <= n; i++) {
        int next = first + second;
        first = second;
        second = next;
    }

    return second;
}
/*
Big-O Analysis
Runtime: O(N) where N is the number of steps in the staircase.
Space complexity: O(1) or constant as regardless of the size of N we only need a few variables to solve our problem.
*/
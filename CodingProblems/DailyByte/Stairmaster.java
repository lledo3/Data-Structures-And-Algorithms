/*
Given a staircase where the ith step has a non-negative cost associated with it given by cost[i], 
return the minimum cost of climbing to the top of the staircase. You may climb one or two steps at 
a time and you may start climbing from either the first or second step.

Ex: Given the following cost array…

cost = [5, 10, 20], return 10.

Ex: Given the following cost array…

cost = [1, 5, 10, 3, 7, 2], return 10.
*/
public int minCostStairs(int[] cost) {
    int[] memoize = new int[cost.length];
    return Math.min(climbSteps(cost.length - 1, cost, memoize), climbSteps(cost.length - 2, cost, memoize));
}

public int climbSteps(int step, int[] cost, int[] memoize) {
    if (step == 0 || step == 1) {
        return cost[step];
    } else if (memoize[step] != 0) {
        return memoize[step];
    } else {
        memoize[step] = cost[step] + Math.min(climbSteps(step - 1, cost, memoize), climbSteps(step - 2, cost, memoize));
        return memoize[step];
    }
}
/*
Big-O Analysis
Runtime: O(N) where N is the total number of elements in cost.
Space complexity: O(N) where N is the total number of elements in cost. This extra space results in our memoize array.
*/
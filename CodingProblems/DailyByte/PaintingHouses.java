/*
You are tasked with painting a row of houses in your neighborhood such that each house is painted either red, blue, or green. 
The cost of painting the ith house red, blue or green, is given by costs[i][0], costs[i][1], and costs[i][2] respectively. 
Given that you are required to paint each house and no two adjacent houses may be the same color, return the minimum cost to paint all the houses.

Ex: Given the following costs array…

costs = [[1, 3, 5],[2, 4, 6],[5, 4, 3]], return 8.
Paint the first house red, paint the second house blue, and paint the third house green.
*/
public minimumCostToPaintHouses(int[][] costs) {
    if(costs == null || costs.length == 0) {
        return 0;
    }

    for(int i = 1; i < costs.length; i++) {
        costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
        costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
        costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
    }

    return Math.min(costs[costs.length - 1][0], Math.min(costs[costs.length - 1][1], costs[costs.length - 1][2]));
}
/*
Big-O Analysis
Runtime: O(N) where N is the total number of houses we are given (i.e. costs.length).
Space complexity: O(1) or constant since we are reusing the costs matrix we are given in the problem.
*/
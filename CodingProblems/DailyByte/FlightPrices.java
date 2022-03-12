/*
A company is booking flights to send its employees to its two satellite offices A and B. 
The cost of sending the ith employee to office A and office B is given by prices[i][0] and prices[i][1] respectively. 
Given that half the employees must be sent to office A and half the employees must be sent to office B, return the 
minimum cost the company must pay for all their employees’ flights.

Ex: Give the following prices…

prices = [[40,30],[300,200],[50,50],[30,60]], return 310
Fly the first personn to office B.
Fly the second person to office B.
Fly the third person to office A.
Fly the fourth person to office A.
*/
public int flightCosts(int[][] prices) {
    Arrays.sort(prices, (a, b) -> {
        return a[0] - a[1] - (b[0] - b[1]);
    });

    int minCost = 0;
    for (int i = 0; i < prices.length; i++) {
        if (i < prices.length / 2) {
            minCost += prices[i][0];
        } else {
            minCost += prices[i][1];
        }
    }

    return minCost;
}
/*
Big-O Analysis
Runtime: O(NlogN) where N is the total number of elements in prices. This overhead results from sorting our prices.
Space complexity: O(1) or constant as the memory we use to solve the problem does not scale as the number of elements in prices gets larger.
*/
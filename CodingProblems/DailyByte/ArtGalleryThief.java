/*
You’ve broken into an art gallery and want to maximize the value of the paintings you steal. All the paintings you steal you place in your 
bag which can hold at most W pounds. Given that the weight and value of the ith painting is given by weights[i] and values[i] respectively, 
return the maximum value you can steal.

Ex: Given the following W, weights array and values array…

W = 10, weights = [4, 1, 3], values = [4, 2, 7], return 13.

Ex: Given the following W, weights array and values array…

W = 5, weights = [2, 4, 3], values = [3, 7, 2], return 7.

Ex: Given the following W, weights array and values array…

W = 7, weights = [1, 3, 4], values = [3, 5, 6], return 11.
*/
public int robMuseum(int W, int[] weights, int[] values) {
    int[][] dp = new int[values.length + 1][W + 1];
    for (int i = 0; i < dp.length; i++) {
        for (int j = 0; j < dp[i].length; j++) {
            if (i == 0 || j == 0) {
                dp[i][j] = 0;
            } else if (j < weights[i]) {
                dp[i][j] = dp[i - 1][j];
            } else {
                dp[i][j] = Math.max(values[i] + dp[i - 1][j - weights[i]], dp[i - 1][j]);
            }
        }
    }

    return dp[values.length][W];
}
/*
Big-O Analysis
Runtime: O(N * M) where N is the length of weights and M is the length of values.
Space complexity: O(N * M) where N is the length of weights and M is the length of values. This results from our dp array.
*/
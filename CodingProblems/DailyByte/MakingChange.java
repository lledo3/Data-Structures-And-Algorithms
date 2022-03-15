/*
Given an array that represents different coin denominations and an amount of change you need to make, return the fewest number of 
coins it takes to make the given amount of change.
Note: If it is not possible to create the amount of change with the coins you’re given, return -1.

Ex: Given the following denominations and amount…

coins = [1,5, 10, 25], amount = 78, return 6
Take three 25 coins and three 1 coins for a total of 6 coins.
*/
public int coinChange(int[] coins, int amount) {
    if (amount < 1) {
        return 0;
    }

    return makeChange(coins, amount, new int[amount]);
}

public int makeChange(int[] coins, int remaining, int[] memoize) {
    if (remaining < 0) {
        return -1;
    }
    if (remaining == 0) {
        return 0;
    }
    if (memoize[remaining - 1] != 0) {
        return memoize[remaining - 1];
    }

    int min = Integer.MAX_VALUE;
    for (int coin: coins) {
        int numCoins = makeChange(coins, remaining - coin, memoize);
        if (numCoins >= 0 && numCoins < min) {
            min = 1 + numCoins;
        }
    }
    memoize[remaining - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
    return memoize[remaining - 1];
}
/*
Big-O Analysis
Runtime: O(N*M) where N is the amount that we’re given and M is the total number of denominations we’re given (i.e. coins.length).
Space complexity: O(N) where N is the amount we’re given. This results from creating an integer array of size N to memoize the results of subproblems.
*/
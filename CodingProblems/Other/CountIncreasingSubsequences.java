/*
Given an array arr of size n. Find the number of triples (i, j, k) where:

i < j < k
arr[i] < arr[j] < arr[k]

Example 1:

Input: arr = [1, 2, 3, 4, 5]
Output: 10
Explanation:
1. 1 2 3
2. 1 2 4
3. 1 2 5
4. 1 3 4
5. 1 3 5
6. 1 4 5
7. 2 3 4
8. 2 3 5
9. 2 4 5
10. 3 4 5

Example 2:

Input: arr = [1, 2, 3, 5, 4]
Output: 7

Example 3:

Input: arr = [5, 4, 3, 2, 1]
Output: 0
Follow-up:
Count number of increasing subsequences in the array arr of size k.

Example 1:

Input: arr = [1, 2, 3, 4, 5], k = 4
Output: 5
Explanation:
1. 1 2 3 4
2. 1 2 3 5
3. 1 2 4 5
4. 1 3 4 5
5. 2 3 4 5
*/
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        System.out.println(solveMain(new int[]{1, 2, 3, 4, 5}));
        System.out.println(solveMain(new int[]{1, 2, 3, 5, 4}));
        System.out.println(solveMain(new int[]{5, 4, 3, 2, 1}));
        
        // extension
        System.out.println(solveMain(new int[]{1, 2, 3, 4, 5}, 4));
    }
    
    public static int solveMain(int [] arr) {
        return solveMain(arr, 3);
    }
    
    public static int solveMain(int [] arr, int k) {
        int sol = 0;
        Integer [][] dp = new Integer[arr.length][k + 1];
        for(int i = 0; i < arr.length; ++i)
            sol += solve(arr, i, k - 1, dp);
        return sol;
    }
    //Top down approach
    public static int solve(int [] arr, int index, int nums, Integer [][] dp){
        if(nums == 0) return 1;
        if(index >= arr.length) return 0;
        if(dp[index][nums] != null) return dp[index][nums];
        // use arr[index]
        int sol = 0;
        for(int i = index + 1; i < arr.length; ++i){
            if(arr[i] > arr[index]) 
                sol += solve(arr, i, nums - 1, dp);
        }
        dp[index][nums] = sol;
        return sol;
    }
}
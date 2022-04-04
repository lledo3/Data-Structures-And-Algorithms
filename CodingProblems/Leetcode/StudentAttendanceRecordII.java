/*
An attendance record for a student can be represented as a string where each character signifies whether the student was 
absent, late, or present on that day. The record only contains the following three characters:

'A': Absent.
'L': Late.
'P': Present.
Any student is eligible for an attendance award if they meet both of the following criteria:

The student was absent ('A') for strictly fewer than 2 days total.
The student was never late ('L') for 3 or more consecutive days.
Given an integer n, return the number of possible attendance records of length n that make a student eligible for an attendance award. 
The answer may be very large, so return it modulo 109 + 7.

Example 1:

Input: n = 2
Output: 8
Explanation: There are 8 records with length 2 that are eligible for an award:
"PP", "AP", "PA", "LP", "PL", "AL", "LA", "LL"
Only "AA" is not eligible because there are 2 absences (there need to be fewer than 2).

Example 2:

Input: n = 1
Output: 3
Example 3:

Input: n = 10101
Output: 183236316
 

Constraints:

1 <= n <= 10^5
*/
/*
In the brute force approach, we actually form every possible string comprising of the letters "A", "P", "L" and 
check if the string is rewardable by checking it against the given criterias. In order to form every possible string, 
we make use of a recursive gen(string, n) function. At every call of this function, we append the letters "A", "P" and "L" 
to the input string, reduce the required length by 1 and call the same function again for all the three newly generated strings.

Complexity Analysis

Time complexity : O(3^n) combinations.
Space complexity : O(n^n) Recursion tree can grow upto depth n and each node contains string of length O(n).
*/
public class Solution {
	//brute force
    int count,M=1000000007;
    public int checkRecord(int n) {
        count = 0;
        gen("", n);
        return count;
    }
    public void gen(String s, int n) {
        if (n == 0 && checkRecord(s))
            count=(count+1)%M;
        else if (n > 0) {
            gen(s + "A", n - 1);
            gen(s + "P", n - 1);
            gen(s + "L", n - 1);
        }
    }
    public boolean checkRecord(String s) {
        int count = 0;
        for (int i = 0; i < s.length() && count < 2; i++)
            if (s.charAt(i) == 'A')
                count++;
        return s.length() > 0 && count < 2 && s.indexOf("LLL") < 0;
    }
}
/*----------------------------------------------------------------------------------*/
class Solution {
	//optimal - DP
    public static final long MOD = (long) 1e9 + 7;
    public int checkRecord(int n) {
        if(n == 0) return 0;
        
        //dp[i][j] means
        //has i A in the past, 0, 1
        //has j consecutive L at last, 0, 1, 2
        long[][] dp = new long[2][3];
        
        //first day
        dp[1][0] = 1; //A
        dp[0][1] = 1; //L
        dp[0][0] = 1; //P
        for(int i = 1; i != n; i++){
            long[][] prev = dp;
            dp = new long[2][3];
            
            //got an A
            dp[1][0] = (prev[0][0] + prev[0][1] + prev[0][2]) % MOD;
            
            //got an L
            dp[0][1] = prev[0][0];
            dp[1][1] = prev[1][0];
            dp[0][2] = prev[0][1];
            dp[1][2] = prev[1][1];
            
            //got a P
            dp[0][0] = (prev[0][0] + prev[0][1] + prev[0][2]) % MOD;
            dp[1][0] = (dp[1][0] + prev[1][0] + prev[1][1] + prev[1][2]) % MOD;
        }
        long res = 0;
        for(long[] line : dp){
            for(long v : line){
                res += v;
            }
        }
        return (int) (res % MOD);
    }
}
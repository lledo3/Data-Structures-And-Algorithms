/*
In a gym hallway there are N lockers. You walk back and forth down the hallway opening and closing lockers. On your first pass 
you open all the lockers. On your second pass, you close every other locker. On your third pass you open every third locker. 
After walking the hallway N times opening/closing lockers in the previously described manner, how many locker are left open?

Ex: Given the following value of N…

N = 1, return 1.
You walk down the hallway once and open the only locker.
Ex: Given the following value of N…

N = 2, return 1.
You walk down the hallway and open both lockers.
You walk back down the hallway and close the last locker.
*/
public int gymLockers(int n) {
    return (int)Math.sqrt(n);
}
/*
Big-O Analysis
Runtime: O(1) or constant.
Space complexity: O(1) or constant.
*/
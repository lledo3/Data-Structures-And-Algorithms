/*
Given a positive integer N, return whether or not it has alternating bit values.

Ex: Given the following value for N…

N = 5, return true.
5 in binary is 101 which alternates bit values between 0 and 1.
Ex: Given the following value for N…

N = 8, return false
8 in binary is 1000 which does not alternate bit values between 0 and 1.
*/
public boolean flipFloppingBits(int N) {
    int last = N % 2;
    N >>= 1;
    while(N > 0) {
        int current = N % 2;
        if(current == last) {
            return false;
        }

        last = current;
        N >>= 1;
    }

    return true;
}
/*
Big-O Analysis
Runtime: O(1) or constant since every integer in Java will have a fixed number of bits (32).
Space complexity: O(1) or constant.
*/
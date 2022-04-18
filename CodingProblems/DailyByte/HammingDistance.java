/*
Given two integers x and y, return the hamming distance between the two numbers.
Note: The hamming distance between two numbers is the number of bit positions in which the bits differ.

Ex: Given the following integers x and y…

x = 2, y = 4, return 2.
2 in binary is 0 0 1 0
4 in binary is 0 1 0 0
therefore the number of positions in which the bits differ is two.
*/
public int hammingDistance(int x, int y) {
    int result = 0;
    while(x > 0 || y > 0) {
        result += (x % 2) ^ (y % 2);
        x >>= 1;
        y >>= 1;
    }

    return result;
}
/*
Big-O Analysis
Runtime: O(1) or constant since all integers in Java will content 32 bits which is of fixed size.
Space complexity: O(1) or constant.
*/
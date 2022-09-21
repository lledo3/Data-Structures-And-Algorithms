/*
Given a 32 bit signed integer, reverse it and return the result.
Note: You may assume that the reversed integer will always fit within the bounds of the integer data type.

Ex: Given the following integer num…

num = 550, return 55
Ex: Given the following integer num…

num = -37, return -73
*/
public int reverse(int num) {
    int result = 0;
    while(num != 0) {
        result = result * 10 + num % 10;
        num /= 10;
    }

    return result;
}
/*
Big-O Analysis
Runtime: O(1) or constant since we will only ever need to process 32 bits of an integer.
Space complexity: O(1) or constant.
*/
/*
Given a positive number, return its complementary number.
Note: The complement of a number is the number that results from flipping every bit in the original number. 
(i.e. zero bits become one bits and one bits become zero bits).

Ex: Given the following number…

number = 27, return 4.
27 in binary (not zero extended) is 11011.
Therefore, the complementary binary is 00100 which is 4.
*/
public int complementaryNumber(int number) {
    int result = 0;
    int power = 1;
    while(number > 0) {
        result += power * ((number % 2) ^ 1);
        power = power <<= 1;
        number >>= 1;
    }

    return result;
}
/*
Big-O Analysis
Runtime: O(logN) where N is the origin number we’re given.
Space complexity: O(1) or constant.
*/
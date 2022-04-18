/*
Given a character array, compress it in place and return the new length of the array.
Note: You should only compress the array if its compressed form will be at least as short as the length of its original form.

Ex: Given the following character array chars…

chars = ['a', 'a', 'a', 'a', 'a', 'a'], return 2.
chars should be compressed to look like the following:
chars = ['a', '6']
Ex: Given the following character array chars…

chars = ['a', 'a', 'b', 'b', 'c', 'c'], return 6.
chars should be compressed to look like the following:
chars = ['a', '2', 'b', '2', 'c', '2']
Ex: Given the following character array chars…

chars = ['a', 'b', 'c'], return 3.
In this case we chose not to compress chars.
*/
public int compress(char[] chars) {
    int index = 0;
    int i = 0;
    while (i < chars.length) {
        int j = i;
        while (j < chars.length && chars[j] == chars[i]) {
            j++;
        }

        chars[index++] = chars[i];
        if (j - i > 1) {
            String count = j - i + "";
            for (char c: count.toCharArray()) {
                chars[index++] = c;
            }
        }

        i = j;
    }

    return index;
}
/*
Big-O Analysis
Runtime: O(N) where N is the total number of character in chars.
Space complexity: O(1) or constant since we compress our array in-place.
*/
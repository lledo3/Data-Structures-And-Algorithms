/*
Given two strings s and t return whether or not s is a subsequence of t.
Note: You may assume both s and t only consist of lowercase characters and both have a length of at least one.

Ex: Given the following strings s and t…

s = "abc", t = "aabbcc", return true.
Ex: Given the following strings s and t…

s = "cpu", t = "computer", return true.
Ex: Given the following strings s and t…

s = "xyz", t = "axbyc", return false.
*/
public boolean isSubsequence(String s, String t) {
    int index = 0;
    for (int i = 0; i < t.length(); i++) {
        if (s.charAt(index) == t.charAt(i)) {
            index++;
        }
        if (index == s.length()) {
            return true;
        }
    }

    return false;
}
/*
Big-O Analysis
Runtime: O(N) where N is the length of t. This is because in the worst case, we’ll have to iterate through all characters 
in t only to determine that s is not a subsequence of t.
Space complexity: O(1) or constant as we only need our index variable to solve our problem regardless of the size of s and t.
*/
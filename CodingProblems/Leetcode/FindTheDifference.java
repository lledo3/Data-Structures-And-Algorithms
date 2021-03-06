/*
You are given two strings s and t.

String t is generated by random shuffling string s and then add one more letter at a random position.

Return the letter that was added to t.

Example 1:

Input: s = "abcd", t = "abcde"
Output: "e"
Explanation: 'e' is the letter that was added.

Example 2:

Input: s = "", t = "y"
Output: "y"
 

Constraints:

0 <= s.length <= 1000
t.length == s.length + 1
s and t consist of lowercase English letters.
*/
class Solution {
	//TC: O(nlogn) SC:O(n)
    public char findTheDifference(String s, String t) {
        // Sort both the strings
        char[] sortedS = s.toCharArray();
        char[] sortedT = t.toCharArray();
        Arrays.sort(sortedS);
        Arrays.sort(sortedT);

        // Character by character comparison
        int i = 0;
        while (i < s.length()) {
            if (sortedS[i] != sortedT[i]) {
                return sortedT[i];
            }
            i += 1;
        }

        return sortedT[i];
    }
}
/*---------------------------------------------------------------------------------------------------------*/
class Solution {
	//TC: O(n) SC: O(1)
    public char findTheDifference(String s, String t) {

        char extraChar = '\0';

        // Prepare a counter for string s.
        // This hash map holds the characters as keys and respective frequency as value.
        HashMap <Character,Integer> counterS = new HashMap <>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            counterS.put(ch, counterS.getOrDefault(ch, 0) + 1);
        }

        // Iterate through string t and find the character which is not in s.
        for (int i = 0; i < t.length(); i += 1) {
            char ch = t.charAt(i);
            int countOfChar = counterS.getOrDefault(ch, 0);
            if (countOfChar == 0) {
                extraChar = ch;
                break;
            } else {

                // Once a match is found we reduce frequency left.
                // This eliminates the possibility of a false match later.
                counterS.put(ch, countOfChar - 1);
            }
        }
        return extraChar;
    }
}
/*
Algorithm

Store all the characters of string s in a hash map called counterS. The key would be the character and value would be number of times 
the character appeared in the string.

Now, iterate through string t and for each character, check if it is present in the hash map counterS.

If the character is present in counterS then we just decrement the corresponding value by 1.

If the character is not present in counterS or has a frequency of zero in counterS it means we have found the extra character of string t.
*/
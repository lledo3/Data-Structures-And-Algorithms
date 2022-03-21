/*
Given a string s and a list of words representing a dictionary, return whether or not the entirety of s can be segmented into dictionary words.
Note: You may assume all characters in s and the dictionary are lowercase.

Ex: Given the following string s and dictionary…

s = "thedailybyte", dictionary = ["the", "daily", "byte"], return true.

Ex: Given the following string s and dictionary…

s = "pizzaplanet", dictionary = ["plane", "pizza"], return false.
*/
public boolean segmentWords(String s, List<String> dictionary) {
    Set<String> words = new HashSet<>(dictionary);
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;
    for (int i = 0; i <= s.length(); i++) {
        for (int j = 0; j < i; j++) {
            if (dp[j] && words.contains(s.substring(j, i))) {
                dp[i] = true;
                break;
            }
        }
    }

    return dp[s.length()];
}
/*
Big-O Analysis Runtime: 
Time complexity: O(N^2) where N is the total number of characters in s. 
This results from our two nested loops as well as the s.substring() calls which requires O(N) time.
Space complexity: O(N) where N is the total number of character in s.
*/
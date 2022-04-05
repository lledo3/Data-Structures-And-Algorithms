/*
Given two strings, passage and text return whether or not the characters in text can be used to form the given passage.
Note: Each character in text may only be used once and passage and text will only contain lowercase alphabetical characters.

Ex: Given the following passage and text…

passage = "bat", text = "cat", return false.
Ex: Given the following passage and text…

passage = "dog" text = "didnotgo", return true.
*/
public boolean characterScramble(String passage, String text) {
    HashMap<Character, Integer> counts = new HashMap<>();
    for(char c: text.toCharArray()) {
        counts.put(c, counts.getOrDefault(c, 0) + 1);
    }

    for(char c: passage.toCharArray()) {
        if(!counts.containsKey(c) || counts.get(c) <= 0) {
            return false;
        }

        counts.put(c, counts.get(c) - 1);
    }

    return true;
}
/*
Big-O Analysis
Runtime: O(N + M) where N is the number of characters in passage and M is the number of characters in text. 
This results from us iterating through both of them entirely.
Space complexity: O(1) or constant since we know our hash map can only grow to a maximum size of 26 
(restricted by the constraint that we will only encounter lowercase alphabetical characters).
*/
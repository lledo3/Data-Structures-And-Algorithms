/*
Given a string, return the index of its first unique character. If a unique character does not exist, return -1.

Ex: Given the following strings...

"abcabd", return 2
"thedailybyte", return 1
"developer", return 0
*/
public int firstUniqChar(String s) {
    Map<Character, Integer> charIndices = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
        char current = s.charAt(i);
        if (charIndices.containsKey(current)) {
            charIndices.put(current, Integer.MAX_VALUE);
        } else {
            charIndices.put(current, i);
        }
    }

    int min = Integer.MAX_VALUE;
    for (char c: charIndices.keySet()) {
        min = Math.min(min, charIndices.get(c));
    }

    return min == Integer.MAX_VALUE ? -1 : min;
}
/*
Big-O Analysis
Runtime: O(N) where N is the number of characters in s.
Space complexity: O(N) where N is the number of characters in s.
*/
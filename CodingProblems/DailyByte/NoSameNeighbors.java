/*
Given a string, check if it can be modified such that no two adjacent characters are the same. If it is possible, 
return any string that satisfies this condition and if it is not possible return an empty string.

Ex: Given the following string s…

s = "abb", return "bab".
Ex: Given the following string s…

s = "xxxy", return "" since it is not possible to modify s such that no two adjacent characters are the same.

*/
public String noSameNeighbors(String s) {
    Map<Character, Integer> counts = new HashMap<>();
    for (char c: s.toCharArray()) {
        counts.put(c, counts.getOrDefault(c, 0) + 1);
    }

    PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> counts.get(b) - counts.get(a));
    maxHeap.addAll(counts.keySet());

    StringBuilder result = new StringBuilder();
    while (maxHeap.size() > 1) {
        char current = maxHeap.remove();
        char next = maxHeap.remove();
        result.append(current);
        result.append(next);
        counts.put(current, counts.get(current) - 1);
        counts.put(next, counts.get(next) - 1);
        if (counts.get(current) > 0) {
            maxHeap.add(current);
        }
        if (counts.get(next) > 0) {
            maxHeap.add(next);
        }
    }

    if (!maxHeap.isEmpty()) {
        char last = maxHeap.remove();
        if (counts.get(last) > 1) {
            return "";
        }
        result.append(last);
    }

    return result.toString();
}
/*
Big-O Analysis
Runtime: O(NlogN) where N is the total number of elements in s. This results from adding our N elements to our heap and removing them all.
Space complexity: O(N) where N is the total number of elements in s.
*/
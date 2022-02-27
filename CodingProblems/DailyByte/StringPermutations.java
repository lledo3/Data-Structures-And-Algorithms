/*
Backtracking
Given a string s consisting of only letters and digits, where we are allowed to transform any 
letter to uppercase or lowercase, return a list containing all possible permutations of the string.

Ex: Given the following string…

S = "c7w2", return ["c7w2", "c7W2", "C7w2", "C7W2"]
*/
public List<String> stringPermutations(String S) {
    List<String> permutations = new ArrayList<String>();     
    generatePermutations(S, 0, permutations, "");
    return permutations;
}

public void generatePermutations(String S, int index, List<String> permutations, String current) {
    if(index >= S.length()) {
        permutations.add(current);
        return;
    }

    char c = S.charAt(index);
    if(Character.isLetter(c)) {
        generatePermutations(S, index + 1, permutations, current + Character.toUpperCase(c));
        generatePermutations(S, index + 1, permutations, current + Character.toLowerCase(c));
    } else {
        generatePermutations(S, index + 1, permutations, current + c);
    }
}

/*
Big-O Analysis
Runtime: O(2N) where N is the total number of characters in S. This results from us having 2 choices at every character in the worst case 
(i.e. uppercase the current letter and lowercase the current letter)
Space complexity: O(2N) where N is the total number of characters in S. This results from us storing all 2N permutations of S.
*/
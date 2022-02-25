/*
Given a string representing your stones and another string representing a list of jewels, 
return the number of stones that you have that are also jewels.

Ex: Given the following jewels and stones...

jewels = "abc", stones = "ac", return 2
jewels = "Af", stones = "AaaddfFf", return 3
jewels = "AYOPD", stones = "ayopd", return 0
*/
public int numJewelsFromStones(String stones, String jewels) {
    int jewelCount = 0;
    for (int i = 0; i < stones.length(); i++) {
        for (int j = 0; j < jewels.length(); j++) {
            if (stones.charAt(i) == jewels.charAt(j)) {
                jewelCount++;
            }
        }
    }

    return jewelCount;
}
/*
Big-O Analysis
Runtime: O(nm)
*/
public int numJewelsFromStones(String stones, String jewels) {
    HashSet<Character> jewelsSet = new HashSet<Character>();
    for(char c: jewels.toCharArray()) {
        jewelsSet.add(c);
    }

    int numJewels = 0;
    for(char c: stones.toCharArray()) {
        if(jewelsSet.contains(c)) {
            numJewels++;
        }
    }

    return numJewels;
}
/*
Big-O Analysis
Runtime: O(N + M) since we will need to iterate through all of our jewels to throw them into a hash set (let’s call it N jewels) 
and all of our stones to validate whether or not each one is a jewel (let’s call it M stones).
Space complexity: O(N) as we will throw each of our jewels into our hash set.
*/
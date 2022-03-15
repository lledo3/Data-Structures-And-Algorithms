/*
Given a message that is encoded using the following encryption method…

A -> 1
B -> 2
C -> 3
...
Z -> 26
Return the total number of ways it can be decoded.
Note: ‘0’ has no mapping and a character following a ‘0’ also has no mapping (i.e. “03”)


Ex: Given the following message…

message = "23", return 2.
The message can be decrypted as "BC" (i.e. 2 -> B, 3 -> C)
The message can also be decrypted as "W" (i.e. 23 -> W)
Ex: Given the following message…

message = "1234", return 3.
*/
public int numDecodings(String message) {
        if (message == null || message.length() == 0) {
            return 0;
        }

        return decryptMessage(0, message, new HashMap<Integer, Integer>());
    }

    public int decryptMessage(int index, String message, Map<Integer, Integer> memoize) {
        if (index >= message.length()) {
            return 1;
        }
        if (message.charAt(index) == '0') {
            return 0;
        }
        if (index == message.length() - 1) {
            return 1;
        }
        if (memoize.containsKey(index)) {
            return memoize.get(index);
        }

        int waysToDecrypt = decryptMessage(index + 1, message, memoize);
        if (Integer.parseInt(message.substring(index, index + 2)) <= 26) {
            waysToDecrypt += decryptMessage(index + 2, message, memoize);
        }

        memoize.put(index, waysToDecrypt);
        return waysToDecrypt;
    }
/*
Big-O Analysis
Runtime: O(N) where N is the total number of characters in our message.
Space complexity: O(N) where N is the total number of characters in our array. This results from storing at most N elements in our memoize hash map.
*/
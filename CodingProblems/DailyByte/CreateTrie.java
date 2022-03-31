/*
Implement a trie class that supports insertion and search functionalities.
Note: You may assume only lowercase alphabetical characters will added to your trie.

Ex: Given the following operations on your trie…

Trie trie = new Trie()
trie.insert("programming");
trie.search("computer") // returns false.
trie.search("programming") // returns true.
*/
class Node {
    public Node[] children;
    public String word;

    public Node() {
        children = new Node[26];
        word = "";
    }
}

class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node current = root;
        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new Node();
            }
            current = current.children[c - 'a'];
        }

        current.word = word;
    }

    public boolean search(String word) {
        Node current = root;
        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                return false;
            }

            current = current.children[c - 'a'];
        }

        return current.word.equals(word);
    }
}
/*
Big-O Analysis
Runtime of insert and search: O(N) where N is the length of the string we’re inserting or searching for.
Space complexity of insert and search: O(N) where N is the length of the string and O(1) respectively.
*/
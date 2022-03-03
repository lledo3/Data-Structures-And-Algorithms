/*
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. 
There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 

Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
 

Constraints:

1 <= word.length, prefix.length <= 2000
word and prefix consist only of lowercase English letters.
At most 3 * 10^4 calls in total will be made to insert, search, and startsWith.
*/
class Trie {
    private Node root;
    public Trie() {
        root = new Node('\0'); // empty character
    }
    
    public void insert(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new Node(c); //do c -'a' because char a certain decimal value
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }
    //helper function
    public Node getNode(String word){ //return the very last word in the node
        Node curr = root;
        for(int i = 0; i < word.length(); i++){
           char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                return null;
            }
            curr = curr.children[c - 'a'];
        }
        return curr;
    }
    
    public boolean search(String word) {
        Node node = getNode(word);
        return node != null && node.isWord;
    }
    
    public boolean startsWith(String prefix) {
        return getNode(prefix) != null;
    }
    
    class Node {
        char c;
        boolean isWord;
        Node[] children;
        
        public Node(char c){
            this.c = c;
            isWord = false;
            children = new Node[26];
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
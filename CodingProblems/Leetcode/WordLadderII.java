/*
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a 
sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation 
sequences from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be 
returned as a list of the words [beginWord, s1, s2, ..., sk].

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
Explanation: There are 2 shortest transformation sequences:
"hit" -> "hot" -> "dot" -> "dog" -> "cog"
"hit" -> "hot" -> "lot" -> "log" -> "cog"

Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: []
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 

Constraints:

1 <= beginWord.length <= 5
endWord.length == beginWord.length
1 <= wordList.length <= 1000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.
*/
class Solution {
    private class Node {
        public String value;
        public Node previous;
        Node(String value) { this.value = value; }
        Node(String value, Node previous) {
            this.value = value;
            this.previous = previous;
        }
    }

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> list = new HashSet<>(wordList);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(beginWord));
        while (!queue.isEmpty()) {
            int size = queue.size();
            while(size-->0){
                Node head = queue.poll();
                for (String neighborStr : neighbors(list, head.value)) {
                    Node neighbor = new Node(neighborStr, head);
                    if (neighbor.value.equals(endWord)) {
                        addNode(res, neighbor);
                        break;
                    }
                    queue.offer(neighbor);
                }
            }
            if (res.size() > 0) break;
        }
        return res;
    }
    


    private Set<String> neighbors(Set<String> list, String s) {
            list.remove(s);
            Set<String> res = new HashSet<>();
            char[] chars = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (chars[i] == ch) continue;
                    char tmp = chars[i];
                    chars[i] = ch;
                    String word = new String(chars);
                    if (list.contains(word)) res.add(word);
                    chars[i] = tmp;
                }
            }
            return res;
        }


     private void addNode(List<List<String>> list, Node p) {
        LinkedList<String> ladder = new LinkedList<>();
        while (p != null) {
            ladder.addFirst(p.value);
            p = p.previous;
        }
        list.add(ladder);
    }

}
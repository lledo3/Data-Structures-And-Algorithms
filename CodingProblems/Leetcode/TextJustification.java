/*
Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and 
is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary 
so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, 
the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left-justified and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.
 

Example 1:

Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]

Example 2:

Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
Note that the second line is also left-justified becase it contains only one word.

Example 3:

Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]
 

Constraints:

1 <= words.length <= 300
1 <= words[i].length <= 20
words[i] consists of only English letters and symbols.
1 <= maxWidth <= 100
words[i].length <= maxWidth
*/
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        
        int i = 0;
        int n = words.length;
        while(i < n){
            int j = i + 1;
            int lineLen = words[i].length();
            while(j < n && (lineLen + words[j].length() + (j - i - 1) < maxWidth)){
                lineLen += words[j].length();
                j++;
            }
            int diff = maxWidth - lineLen;
            int numOfWords = j - i;
            if(numOfWords == 1 || j >= n){//left justify
                res.add(leftJustify(words, diff, i, j));
            }else{
                res.add(middleJustify(words, diff, i, j));
            }
            i = j;
        }
        return res;
    }
    public String leftJustify(String[] words, int diff, int i, int j){
        int spacesOnRight = diff - (j - i - 1);
        StringBuilder sb = new StringBuilder(words[i]);
        for(int k = i + 1; k < j; k++){
            sb.append(" " + words[k]);
        }
        sb.append(" ".repeat(spacesOnRight));
        
        return sb.toString();
    }
    public String middleJustify(String[] words, int diff, int i, int j){
        int spacesNeeded =  j - i - 1;
        int spaces = diff / spacesNeeded;
        int extraSpaces = diff % spacesNeeded;
        StringBuilder sb = new StringBuilder(words[i]);
        for(int k = i + 1; k < j; k++){
            int spacesToApply = spaces + (extraSpaces-- > 0 ? 1 : 0);
            sb.append(" ".repeat(spacesToApply) + words[k]);
        }
        return sb.toString();
    }
}
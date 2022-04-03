/*
Write a function that takes in an array of words and returns the smallest
array of characters needed to form all of the words. The characters don't need
to be in any particular order.


For example, the characters ["y", "r", "o", "u"] are needed to form the words
["your", "you", "or", "yo"].

Note: the input words won't contain any spaces; however, they might contain
punctuation and/or special characters.

Sample Input:
words = ["this", "that", "did", "deed", "them!", "a"]

Sample Output:
["t", "t", "h", "i", "s", "a", "d", "d", "e", "e", "m", "!"]
// The characters could be ordered differently.
*/
import java.util.*;

class Program {

  public char[] minimumCharactersForWords(String[] words) {
    // Write your code here.
		Map<Character,Integer> maxFreq = new HashMap<>();
		for(String word : words){
			Map<Character,Integer> charFreq = countCharFreq(word);
			updateMaxFreq(charFreq, maxFreq);
		}
    return makeArray(maxFreq);
  }
	
	public Map<Character,Integer> countCharFreq(String word){
		Map<Character,Integer> charFreq = new HashMap<>();
		for(char c : word.toCharArray()){
			charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
		}
		return charFreq;
	}
	
	public void updateMaxFreq(Map<Character,Integer> charFreq, Map<Character,Integer> maxFreq){
		for(Map.Entry<Character,Integer> freq :charFreq.entrySet()){
			char c = freq.getKey();
			int characterFreq = freq.getValue();
			
			if(maxFreq.containsKey(c)){
				maxFreq.put(c, Math.max(characterFreq, maxFreq.get(c)));
			}else{
				maxFreq.put(c, characterFreq);
			}
		}
	}
	
	public char[] makeArray(Map<Character,Integer> maxFreq){
		List<Character> characters = new ArrayList<>();
		for(Map.Entry<Character,Integer> frequency : maxFreq.entrySet()){
			char c = frequency.getKey();
			int characterFreq = frequency.getValue();
			
			for(int i = 0; i < characterFreq; i++){
				characters.add(c);
			}
		}
		char[] characterArray = new char[characters.size()];
		for(int i = 0; i < characters.size(); i++){
			characterArray[i] = characters.get(i);
		}
		return characterArray;
	}
}

/*
Leetcode 76
Given an array of unique characters arr and a string str, Implement a function getShortestUnqiueSubstring that finds the smallest substring of str
containing all the characters in arr. Return "" (empty string) if such a substring doesn't exist.

Come up with an asymptotically optimal solution and analyze the time and space complexities.

Example:
input: arr = ['x','y','z'], str = "xyyzyzyx"
output: "zyx"

Constraints:
[time limit] 5000ms
[input] array.character arr: 1 <= arr.length <= 30
[output] string str: 1 <= str.length() <= 500
*/

public static String getShortestUnqiueSubstring(char[] arr, String str){
	if(str.length() < arr.length) return ""; 

	int count = 0; 
	while (count < str.length() - arr.length + 1){ 
		String sub = str.substring(count, arr.length + count); 
		if(containsAllWords(sub,arr)) 
			return sub; 
		count++; 
	} 
	return ""; 
}

public static boolean containsAllWords(String word, char [] keywords) { 
	for (char k : keywords) 
		if (!word.contains(String.valueOf(k))) 
			return false; 
		return true; 
	}
/*
Write a function that takes in an array of strings and groups anagrams together.

Anagrams are strings made up of exactly the same letters, where order doesn't
matter. For example, "cinema" and "iceman" are anagrams; similarly, "foo"
and "ofo" are anagrams.

Your function should return a list of anagram groups in no particular order.

Sample Input:
words = ["yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp"]

Sample Output:
[["yo", "oy"], ["flop", "olfp"], ["act", "tac", "cat"], ["foo"]]
*/
import java.util.*;

class Program {
  public static List<List<String>> groupAnagrams(List<String> words) {
    // Write your code here.
    List<List<String>> solution = new ArrayList<List<String>> ();

	// sort each word
	ArrayList<String> sortedWords = new ArrayList<String> ();
	for (String word : words)
	{
			char [] sorted = word.toCharArray();
			Arrays.sort(sorted);
			sortedWords.add(new String(sorted));
	}

	// make groups
	HashMap<String, ArrayList<String>> map = new HashMap<>();
	for (int i = 0; i < sortedWords.size(); ++i)
	{
		if (map.containsKey(sortedWords.get(i)))
		{
			ArrayList<String> group = map.get(sortedWords.get(i));
			group.add(words.get(i));
			map.put(sortedWords.get(i), group);
		}
		else
		{
			ArrayList<String> group = new ArrayList<String>();
			group.add(words.get(i));
			map.put(sortedWords.get(i), group);
		}
	}

	// add groups to solution
	for (String sorted : map.keySet() )
	{
		ArrayList<String> group = map.get(sorted);
		solution.add(group);
	}

	return solution;
  }
}
/*---------------------------------------------------------------------------------------------*/
import java.util.*;

class Program {
	// time : O(w^2 * n) | space : O(n + w)
  public static List<List<String>> groupAnagrams(List<String> words) {
    // Write your code here.
     List<List<String>> solution = new ArrayList<List<String>> ();

        List<Boolean> visited = new ArrayList<> ();
        for (String word : words) { visited.add(false); }

        for (int i = 0; i < words.size(); i++)
        {
            if (!visited.get(i))
            {
                visited.set(i, true);
                ArrayList<String> current = new ArrayList<String> ();
                current.add(words.get(i));
                for (int j = i + 1; j < words.size(); j++)
                {
                    if (areAnagrams(words.get(i), words.get(j)))
                    {
                        current.add(words.get(j));
                        visited.set(j, true);
                    }
                }
                solution.add(current);
            }
        }
        return solution;
  }
	// helper function - checks if two strings are anagrams
    public static boolean areAnagrams(String first, String second)
    {
        if (first.length() != second.length()) { return false; }

        HashMap<Character, Integer> charCountFirst = new HashMap<>();
        for (char c : first.toCharArray())
        {
            if (charCountFirst.containsKey(c)) { charCountFirst.put(c, charCountFirst.get(c) + 1); }
            else { charCountFirst.put(c,1); }
        }

        HashMap<Character, Integer> charCountSecond = new HashMap<>();
        for (char c : second.toCharArray())
        {
            if (charCountSecond.containsKey(c)) { charCountSecond.put(c, charCountSecond.get(c) + 1); }
            else { charCountSecond.put(c,1); }
        }

        for (Character c : charCountFirst.keySet())
        {
            if (!charCountSecond.containsKey(c)) { return false; }
            if (charCountSecond.get(c) != charCountFirst.get(c)) { return false;}
        }
        return true;
    }
}

/*
If you open the keypad of your mobile phone, it'll likely look like this:

   ----- ----- -----
  |     |     |     |
  |  1  |  2  |  3  |
  |     | abc | def |
   ----- ----- -----
  |     |     |     |
  |  4  |  5  |  6  |
  | ghi | jkl | mno |
   ----- ----- -----
  |     |     |     |
  |  7  |  8  |  9  |
  | pqrs| tuv | wxyz|
   ----- ----- -----
        |     |
        |  0  |
        |     |
         -----
Almost every digit is associated with some letters in the alphabet; this allows certain phone numbers to spell out actual words. For example, the phone
number 8464747328 can be written as timisgreat ; similarly, the phone number 2686463 can be written as antoine or as ant6463. 

It's important to note that a phone number doesn't represent a single sequence of letters, but rather multiple combinations of letters. For instance, the
digit 2 can represent three different letters (a, b, and c).

A mnemonic is defined as a pattern of letters, ideas, or associations that assist in remembering something. Companies often times use a mnemonic for their
phone number to make it easier to remember.

Given a stringified phone number of any non-zero length, write a function that returns all mnemonics for this phone number, in any order.

For this problem, a valid mnemonic may only contain letters and the digits 0 and 1. In other words, if a digit is able to be
represented by a letter, then it must be. Digits 0 and 1 are the only two digits that don't have letter representations
on the keypad.

Sample Input:
phoneNumber = "1905"

Sample Output:
[
  "1w0j",
  "1w0k",
  "1w0l",
  "1x0j",
  "1x0k",
  "1x0l",
  "1y0j",
  "1y0k",
  "1y0l",
  "1z0j",
  "1z0k",
  "1z0l",
]
*/
import java.util.*;

class Program {
	public static final Map<Character,String[]> MAPPING = new HashMap<>();
	
	static{
		MAPPING.put('0', new String[]{"0"});
		MAPPING.put('1', new String[]{"1"});
		MAPPING.put('2', new String[]{"a","b","c"});
		MAPPING.put('3', new String[]{"d","e","f"});
		MAPPING.put('4', new String[]{"g","h","i"});
		MAPPING.put('5', new String[]{"j","k","l"});
		MAPPING.put('6', new String[]{"m","n","o"});
		MAPPING.put('7', new String[]{"p","q","r","s"});
		MAPPING.put('8', new String[]{"t","u","v"});
		MAPPING.put('9', new String[]{"w","x","y","z"});
	}
	
  public ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
    String[] curr = new String[phoneNumber.length()];
		Arrays.fill(curr, "0");
		ArrayList<String> mnemonicsList = new ArrayList<>();
		helper(0, phoneNumber, curr, mnemonicsList);
    return mnemonicsList;
  }
	public void helper(int idx, String phoneNumber, String[] curr, ArrayList<String> mnemonicsList){
		if(idx == phoneNumber.length()){
			String mnemonic = String.join("", curr);
			mnemonicsList.add(mnemonic);
		}else{
			char digit = phoneNumber.charAt(idx);
			String[] letters = MAPPING.get(digit);
			for(String letter : letters){
				curr[idx] = letter;
				helper(idx + 1, phoneNumber, curr, mnemonicsList);
			}
		}
	}
}
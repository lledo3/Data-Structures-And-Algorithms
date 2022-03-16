/*
Write a function that takes a string in a string and returns a compressed version of it.

Example 1:
Input: "aabbaccc"
Output: "a2b2a1c3"
*/
class Solution{
	public String stringEncode(String s){
		StringBuidler sb = new StringBuilder();
		for(int i = 0; i < s.length(); i++){
			int count = 1;
			while(i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)){
				count += 1;
				i += 1;
			}
			sb.append(s.charAt(i));
			sb.append(count);
		}
		sb.toString();
	}
}
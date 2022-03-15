/*
A string is provided as input from the console which consist of integer values. Insert '*' if subsequent numbers are even and insert '-'
if subsequent numbers are odd.

Input: 21462675756 Output: 214*6*2*67-5-7-56
Input: 98676555533 Output: 98*6765-5-5-5-3-3
*/
public class StringManiupulation {
	public static void main(String[] args) {
		String s= "21462675756";
		replaceStringValue(s);	
	}
	
	public static boolean checkOdd(char ch){
		return ch % 2 != 0? true:false;
	}
	
	
	public static void replaceStringValue(String s){
		StringBuilder sb = new StringBuilder(s);
		for(int i = 0; i < sb.length()-1; i++){
			if(checkOdd(sb.charAt(i)) && checkOdd(sb.charAt(i+1))){
				sb.insert(i+1, '-');
				s = sb.toString();
				i++;
			}else if (!checkOdd(sb.charAt(i)) && !checkOdd(sb.charAt(i+1))) {
				sb.insert(i+1, '*');
				s = sb.toString();
				i++;
			}
		}
		System.out.println(sb.toString());
	}
}
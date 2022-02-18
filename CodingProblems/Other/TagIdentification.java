/*
Tag Identification Number
You're given a string containing a list of digits. 
You must make as many IDs of the format 8xxxxxxxxxx (an 8 followed by 10 digits) as possible. 
Return the number of IDs you can make. 
The IDs do not have to be unique, and you may rearrange the digits, but you may only use each digit once.
*/
public class Solution {

	public int tagIdentification(String[] pool){
		int size = pool.length();
        int max = size/11;
        int count =0;
        for ( int i =0 ; i < size ; i++){           
            if ( pool.charAt(i) == '8')
                count++
        }
        int result = Math.min(count, max);
		return result;
	}
}
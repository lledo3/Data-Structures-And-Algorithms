/*
Reverse String - O(n)

Given a string, write a function that reverses that string without using built-in functions or libraries.

Example:

Input:  "hello"

Output: "olleh"

Note:
Your algorithm should run in O(n) time and use O(1) extra space.
*/
class Solution {
    void swap(char[] arr, int i, int j){
         char temp = arr[i];
         arr[i] = arr[j];
         arr[j] = temp;
    }
    public String reverse1(String input) {
        char[] charArray = input.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        
        while(left < right){
            swap(charArray, left, right);
            left++;
            right--;
        }
        return new String(charArray);
    }

    public String reverse2(String input) {
        String reverseString = "";
        for(int i = input.length() - 1; i >= 0; i--){
            reverseString += input.charAt(i);
        }
        return reverseString;
    }

    public String reverse3(String input) {
        StringBuilder reversedString = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            reversedString.append(input.charAt(i));
        }
        return reversedString.toString();
    }
}
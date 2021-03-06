import java.io.*;
import java.util.*;

/*
You and your friends are all fans of the hit TV show ThroneWorld and like to discuss it on social media. Unfortunately, some of your friends don't watch every new episode the minute it comes out. Out of consideration for them you would like to obfuscate your status updates so as to keep them spoiler-free.

You settle on a route cipher, which is a type of transposition cipher. Given a message and a number of rows and number of columns, to compute the route encryption of the message:

 - Write out the message row-wise in a grid of size rows by cols
 - then read the message column-wise.

You are guaranteed that rows * cols == len(message).

Your task is to write a function that, given a message, rows, and cols, returns the route encryption of the message.

Example:

message1 = "One does not simply walk into Mordor", rows1 = 6, cols1 = 6

O n e   d o
e s   n o t
  s i m p l
y   w a l k
  i n t o  
M o r d o r

transpose(message1, rows1, cols1) -> "Oe y Mnss ioe iwnr nmatddoploootlk r"

Other examples:

message2 = "1.21 gigawatts!", rows2 = 5, cols2 = 3
1 . 2
1   g
i g a
w a t
t s !

transpose(message2, rows2, cols2) -> "11iwt. gas2gat!"

message2 = "1.21 gigawatts!", rows3 = 3, cols3 = 5
transpose(message2, rows3, cols3) -> "1ga.it2gt1as w!"

Complexity analysis:

n: the length of the message
*/
public class Solution {
  public static void main(String[] argv) {
    
    //String message1 = "One does not simply walk into Mordor";
    //int rows1 = 6; int cols1 = 6;
    
    String message2 = "1.21 gigawatts!";
    int rows2 = 5; int cols2 = 3;
    int rows3 = 3; int cols3 = 5;
    System.out.println(transpose(message2, 5, 3));

  }
  public static String transpose(String str, int row, int col){
    char[] c = str.toCharArray();
    char[][] arr = new char[row][col];
    StringBuilder sb = new StringBuilder();
    int idx = 0;
    for(int i = 0; i < arr.length; i++){
      for(int j = 0; j < arr[0].length; j++){
          arr[i][j] = c[idx];
          idx++;
      }
    }
    
    for(int i = 0; i < arr.length; i++){
      for(int j = 0; j < arr[0].length; j++){
        sb.append(arr[j][i]);
      }
    }
    return sb.toString();
  }
}
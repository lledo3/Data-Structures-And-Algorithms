/*
You are given an array of integers a. A new array b is generated by rearranging the elements of a in the following way:

b[0] is equal to a[0];
b[1] is equal to the last element of a;
b[2] is equal to a[1];
b[3] is equal to the second-last element of a;
b[4] is equal to a[2];
b[5] is equal to the third-last element of a;
and so on.
Your task is to determine whether the new array b is sorted in strictly ascending order or not.

Example

For a = [1, 3, 5, 6, 4, 2], the output should be solution(a) = true.

The new array b will look like [1, 2, 3, 4, 5, 6], which is in strictly ascending order, so the answer is true.

For a = [1, 4, 5, 6, 3], the output should be solution(a) = false.

The new array b will look like [1, 3, 4, 6, 5], which is not in strictly ascending order, so the answer is false.
*/
boolean solution(int[] a) {
    int n = a.length;
    int b[] = new int[n];
    b[0] = a[0];
    int count1 =1,count2 = 0;
    for(int i = 1; i < a.length; i++){
        if(i % 2 == 1){
           b[i] = a[n - count1];
           count1++;
       }else{
           b[i] = a[++count2];
       }
    }
    for(int i = 1; i < a.length; i++){
         if(b[i] <= b[i - 1]){
           return false ;
       }
    }
    return true;
}

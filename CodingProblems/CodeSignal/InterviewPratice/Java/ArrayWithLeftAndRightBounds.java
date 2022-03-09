/*
You are given an array of integers a and two integers l and r. You task is to calculate a boolean array b, where b[i] = true 
if there exists an integer x, such that a[i] = (i + 1) * x and l ≤ x ≤ r. Otherwise, b[i] should be set to false.
*/
public static boolean[] boundedRation(int[] numbers, int left, int right){
	boolean[] result = new boolean[numbers.length];

	for(int i = 0; i < numbers.length; i++){
		for(int x = left; x <= right; x++){
			if((i + 1) * x == numbers[i]){
				result[i] = true;
				continue;
			}
		}
	}
	return result;
}
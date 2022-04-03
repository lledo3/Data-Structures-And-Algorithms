/*
Write a function that takes in an array of unique integers and returns an
array of all permutations of those integers in no particular order.

If the input array is empty, the function should return an empty array.

Sample Input:
array = [1, 2, 3]

Sample Output:
[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
*/
import java.util.*;

class Program {
  public static List<List<Integer>> getPermutations(List<Integer> array) {
    List<List<Integer>> res = new ArrayList<>();
    backTrackPermu1(res, array, 0);
    return res;
  }
	public static void backTrackPermu1(List<List<Integer>> res, List<Integer> array, int start){
        if(array.size() == 0) return;
		List<Integer> list = new ArrayList<>();
        if(start == array.size()){
            for(Integer num : array){
                list.add(num);
            }
            res.add(list);
        }else{
            for(int i = start; i < array.size(); i++){
                permSwap(i, start, array);
                backTrackPermu1(res, array, start + 1);
                permSwap(i, start, array);
            }
        }
    }
    public static void permSwap(int i, int j, List<Integer> array){
        int temp = array.get(i);
		array.set(i, array.get(j));
		array.set(j, temp);
    }
}

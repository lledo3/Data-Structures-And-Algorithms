/*
Backtracking
Given a list of positive numbers without duplicates and a target number, find all unique combinations of the 
numbers that sum to the target. Note: You may use the same number more than once.

Ex: Given the following numbers and target…

numbers = [2,4,6,3], target = 6,
return [
    [2,2,2],
    [2,4],
    [3,3],
    [6]
]
*/
public List<List<Integer>> combinationSum(int[] numbers, int target) {
    List<List<Integer>> combinations = new ArrayList<>();
    Arrays.sort(numbers);
    generateCombinations(combinations, new ArrayList<>(), numbers, target, 0);

    return combinations;
}

public void generateCombinations(List<List<Integer>> combinations, List<Integer> current, int[] numbers, int remaining, int start) {
    if (remaining < 0) {
        return;
    }
    if (remaining == 0) {
        combinations.add(new ArrayList<>(current));
        return;
    }

    for (int i = start; i < numbers.length; i++) {
        current.add(numbers[i]);
        generateCombinations(combinations, current, numbers, remaining - numbers[i], i);
        current.remove(current.size() - 1);
    }
}
/*
Big-O Analysis
Runtime: O(2N) where N is our total number of numbers. This results from having two choices at each of our N numbers.
Space complexity: O(N) where N is the total number of elements in numbers. This results from having at most N calls 
on our stack from our recursive calls.
*/
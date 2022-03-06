/*
A ship is about to set sail and you are responsible for its safety precautions. More specifically, you are responsible 
for determining how many life rafts to carry onboard. You are given a list of all the passengers’ weights and are informed 
that a single life raft has a maximum capacity of limit and can hold at most two people. Return the minimum number of life 
rafts you must take onboard to ensure the safety of all your passengers. Note: You may assume that a the maximum weight of 
any individual is at most limit.

Ex: Given the following passenger weights and limit…

weights = [1, 3, 5, 2] and limit = 5, return 3
weights = [1, 2] and limit = 3, return 1
weights = [4, 2, 3, 3] and limit = 5 return 3
*/
public int numRescueBoats(int[] weights, int limit) {
    Arrays.sort(weights);

    int lifeRafts = 0;
    int i = 0;
    int j = weights.length - 1;
    while(i <= j) {
        if(weights[i] + weights[j] <= limit) {
            i++;
            j--;
        } else {
            j--;
        }

        lifeRafts++;
    }

    return lifeRafts;
}
/*
Big-O Analysis
Runtime: O(NlogN) where N is the number of passengers we have (i.e. weights.length). This results from the overhead of 
sorting our passengers by weight.
Space complexity: O(1) or constant since regardless of the size of our weights array (i.e. the number of passengers we are given) 
the memory we use does not increase.
*/
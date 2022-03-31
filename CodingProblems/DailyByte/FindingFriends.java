/*
You are given a two dimensional matrix,friends, that represents relationships between coworkers in an office. If friends[i][j] = 1 
then coworker i is friends with coworker j and coworker j is friends with coworker i. Similarly if friends[i][j] = 0 then coworker i 
is not friends with coworker j and coworker j is not friend with coworker i. Friendships in the office are transitive (i.e. if coworker 
one is friends with coworker two and coworker two is friends with coworker three, coworker one is also friends with coworker three). 
Given the friendships in the office defined by friends, return the total number of distinct friends groups in the office.
Note: Each coworker is friends with themselves (i.e.matrix[i][j] = 1 for all values where i = j)

Ex: Given the following matrix friends…

friends = [
    [1, 1, 0],
    [1, 1, 0],
    [0, 0, 1]
], return 2.
The 0th and 1st coworkers are friends with one another (first friend group).
The 2nd coworker is friends with themself (second friend group).
*/
public int findFriends(int[][] friends) {
    int[] parent = new int[friends.length];
    Arrays.fill(parent, -1);
    for (int i = 0; i < friends.length; i++) {
        for (int j = 0; j < friends.length; j++) {
            if (friends[i][j] == 1 && i != j) {
                union(parent, i, j);
            }
        }
    }

    int friendGroups = 0;
    for (int i = 0; i < parent.length; i++) {
        if (parent[i] == -1)
            friendGroups++;
    }

    return friendGroups;
}

private void union(int parent[], int x, int y) {
    int xSet = find(parent, x);
    int ySet = find(parent, y);
    if (xSet != ySet) {
        parent[xSet] = ySet;
    }
}

private int find(int parent[], int i) {
    if (parent[i] == -1) {
        return i;
    }

    return find(parent, parent[i]);
}
/*
Big-O Analysis
Runtime: O(N3) where N is the number of coworkers we’re given. This results from iterating through our N * N matrix and for 
each value that is equal to one, we can iterate through all of the N coworkers in the worst case.
Space complexity: O(N) where N is the number of coworkers we’re given (i.e. friends.length). This results from creating our 
parent array that is of size N.
*/
/*
You are serving people in a lunch line and need to ensure each person gets a “balanced” meal. A balanced meal is a meal 
where there exists the same number of food items as drink items. Someone is helping you prepare the meals and hands you food 
items (i.e. F) or a drink items (D) in the order specified by the items string. Return the maximum number of balanced meals 
you are able to create without being able to modify items.
Note: items will only contain F and D characters.

Ex: Given the following items…

items = "FDFDFD", return 3
the first "FD" creates the first balanced meal.
the second "FD" creates the second balanced meal.
the third "FD" creates the third balanced meal.
Ex: Given the following items…

items = "FDFFDFDD", return 2
"FD" creates the first balanced meal.
"FFDFDD" creates the second balanced meal.
*/
public int lunchTime(String items) {
    int balancedMeals = 0;
    int count = 0;
    for (int i = 0; i < items.length(); i++) {
        char current = items.charAt(i);
        if (current == 'F') {
            count++;
        } else if (current == 'D') {
            count--;
        }

        if (count == 0) {
            balancedMeals++;
        }
    }

    return balancedMeals;
}
/*
Big-O Analysis
Runtime: O(N) where N is the number of items we’re given.
Space complexity: O(1) or constant as the amount of memory we use does not increase as our number of items increase.
*/
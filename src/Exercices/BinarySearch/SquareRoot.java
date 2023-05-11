package Exercices.BinarySearch;

public class SquareRoot {

    // This is a problem to find a value result for a given number to be square root without use built-in function.
    // The logic here is to search a value in an imaginare list where we have ordered values to be powered by 2.
    // Time complexity is O(log n) abd space complexity is O(1).

    public static int find(int valueToSquareRoot){
        // Because we truncate the decimals using integers, the problem is equivalent to finding the largest element in
        // the sorted array whose square is equal or less than given value.
        // If there is no exactly square match for the given value we can return the largest element that is smaller the
        // of exactly square. We can subtract 1 from the index after find the first in this case (line 34). Otherwise, we return
        // exactly the match number (line 24)
        if (valueToSquareRoot == 0) return 0; //edge case
        if (valueToSquareRoot == 1) return 1; //edge case

        int left = 1;
        int right = valueToSquareRoot;
        int valueToPower = -1;

        while (left <= right){
            int mid = left + (right -left)/2;

            if(mid == valueToSquareRoot/mid){
                return mid;
            }
            else if(mid > valueToSquareRoot/mid){
                valueToPower = mid;
                right = mid -1;
            } else {
                left = mid +1;
            }
        }

        return valueToPower-1;
    }
}

package Sort;

import contract.Sort;

import java.util.List;

public class QuickSort implements Sort {
    // The time complexity average is O(nlog n) which is O(lon n), however, in the worst case scenario, each interval to sort
    //is one less than the current interval, which would make the time complexity O(n²). This depends of your pivot choose, for example
    // if choose the endpoint index as pivot and the list is already sorted, it will reach this time complexity.
    // This algorithm is not stable, sorting the array in place, but use recursion layers to create new data structures.
    @Override
    public List<Integer> sort(List<Integer> unsortedList) {
        sort(unsortedList, 0, unsortedList.size());
        return unsortedList;
    }

    public void sort(List<Integer> unsortedList, int lowIndex, int highIndex) {
        // Edge case, if you have one element in the list, it's already sorted so we don't need to do nothing 'cause it's already sorted.
        if (highIndex - lowIndex <= 1) return; 

        // Using 3 pointers to work around the list. A pivot, a left and right pointer.
        int pivot = unsortedList.get(highIndex - 1);
        int leftPointer = lowIndex;
        int rightPointer = highIndex - 1;

        // While the left and right pointers match in the same position in the list index we make they work by moving one position each in
        // every iteration comparing against the pivot.
        while (leftPointer < rightPointer) {
            // Moving the left pointer to the right until reach the pivot or match the right index position.
            while (unsortedList.get(leftPointer) < pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            // Moving the right pointer to the left until reach the pivot or match the right index position.
            while (unsortedList.get(rightPointer) >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            // Break the loop as soon as the pointers match
            if (leftPointer == rightPointer) break;

            // Swap the values of the pointers and restarted the process keeping in the loop
            swap(unsortedList, leftPointer, rightPointer);
        }

        // Swap the pivot and the meeting point
        swap(unsortedList, leftPointer, highIndex - 1);

        // Then make the recursion
        sort(unsortedList, lowIndex, leftPointer);
        sort(unsortedList, leftPointer + 1, highIndex);

    }

    private static void swap(List<Integer> unsortedList, int leftPointer, int highIndex) {
        int temp = unsortedList.get(leftPointer);
        unsortedList.set(leftPointer, unsortedList.get(highIndex));
        unsortedList.set(highIndex, temp);
    }

}

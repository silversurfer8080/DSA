import contract.Search;

import java.util.List;

public class BinarySearch implements Search {
    // Algorithm to use in an ordered list
    // This algorithm make use of two pointers to move between the begin and end of list, always making a split, dividing
    // the list in the middle and comparing the target number with middle point number. If middle number it's smaller than
    // target number we make the search in initial half otherwise we look in the end half, using the same approach.
    @Override
    public int search(List<Integer> list, int target) {
        // Initializing the both ends of the list
        int low = 0;
        int high = list.size() - 1;

        // ...and put those values in loop, updating the values for each casa (smaller or bigger than the target)
        while (low <= high){
            //base on the low and high indexes, find the middle point and the middle value to start the compare.
            int middlePosition = (low  + high) / 2;
            int middleNumber = list.get(middlePosition);
            // match? return it
            if (target == middleNumber) {
                return middlePosition;
            }
            // So the target is smaller? Let's reduce the search to back half of the list making the high value be the
            // middle plus one, so when recalculate the middle point we use this new high value
            if(target < middleNumber){
                high = middlePosition + 1;
            }
            // ... same thing if the target is bigger, we move the low point to a new value so we can use to calculate the
            // new middle point of the list
            else {
                low = middlePosition - 1;
            }
        }
        // If we fail to find the number in the list 'cause it doesn't exist than we return the usually '-1' value
        return -1;
    }
}

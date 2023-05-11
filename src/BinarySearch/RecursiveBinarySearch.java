package BinarySearch;

import contract.Search;

import java.util.List;

// This has a O(log n) time complexity, and work in place, just creating a few temporary variables to use as a pointer
// since we need to be aware on which half part of array (or list in this example :P) to look.
public class RecursiveBinarySearch implements Search {


    @Override
    public int search(List<Integer> list, int target) {
        // To make it simple and start with only two parameters ww initialize the variables and pass it to a more parameters.
        int low = 0;
        int high = list.size();

        return search(list, target, low, high);

    }

    private int search(List<Integer> list, int target, int low, int high) {
        // Checking the conditions we're going to pass since this method will be call recursively, once the edges
        // shrink enough and not find the result it will go out of this if and return -1 indicate there was no find for the target.
        if(high >= low && low <= list.size() -1){
            // Recursively updating the middle position and it's value.
            int middlePosition = low + (high - low) / 2;
            int middlePointValue = list.get(middlePosition);
            // We got luck? return the index :D.
            if(target == middlePointValue ) {
                return middlePosition;
            }
            // Here we were not luck, but we know it is bellow the middle point or above the middle point.
            // So here we make the recursive magic were we look into the half interest point of the list.
            if(target < middlePointValue){
               return search(list, target, low, middlePosition -1);
            }
            // One of the odd things when work in case like this is not paying attention on the recursive calls where
            // we update the values we are passing, like the low point or the high point.
            else {
                return search(list, target, middlePosition +1, high);
            }
        }
        return -1;
    }
}

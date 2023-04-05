import java.util.List;

public class RecursiveBinarySearchForBooleanTarget{

    // Similar problem as the normal binary search but this time using a boolean.
    // So the implementation here change in the way we are looking our target.
    // Since it's an ordered list where the all the values are booleans, when we find the true value in the list we
    // need to check if it's the first one or if the previous value isn't true, if not we return the index, also when we
    // find a false value, if we check the next position, and if it's true value we can return, since the problem is about to
    // find the next true boolean value in an ordered list (from false to true).
    public static int search(List<Boolean> list) {
        int high = list.size()-1;
        int low = 0;

        return findBoundaryRecursiveMode(list, low, high);
    }

    public static int findBoundaryRecursiveMode(List<Boolean>arr, int low, int high){

        if(high >= low && low <= arr.size() - 1){

            int midPointIndex = low + (high-low)/2;
            boolean midValue = arr.get(midPointIndex);
            if(midValue && midPointIndex == 0){
                return midPointIndex;
            }
            if(midValue) {
                if(!arr.get(midPointIndex-1)){
                    return midPointIndex;
                } else {
                    return findBoundaryRecursiveMode(arr, low, midPointIndex-1);
                }
            }
            if(!midValue){
                if(arr.size()-1 >= midPointIndex+1 && arr.get(midPointIndex+1)){
                    return midPointIndex+1;
                }else {
                    if (arr.size() > 1) {
                        return findBoundaryRecursiveMode(arr, midPointIndex + 1, high);
                    }
                }

            }

        }
        return -1;
    }
}

package Exercices.BinarySearch;

import contract.MonotonicSearch;

import java.util.List;

public class FindNotSmaller implements MonotonicSearch {

    // Given an array of integers sorted in increasing order and a target,
    // find the index of the first element in the array that is larger than or equal to the target.
    // Assume that it is guaranteed to find a satisfying number.

    //  This is a monotonic function. The time complexity is  O(log n) and space complexity is O(1), despite the variables create.
    @Override
    public int search(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() -1;
        // The variable we use to track the target, cause can be the same or greater than the target.
        int boundaryIndex = -1;

        while(left <= right){
            int mid = left + (right -left)/2;

            if(arr.get(mid) >= target){
                boundaryIndex = mid;
                right = mid -1;
            } else{
                left = mid + 1;
            }
        }
        return boundaryIndex;
    }
}

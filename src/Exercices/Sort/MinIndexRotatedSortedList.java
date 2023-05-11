package Exercices.Sort;

import java.util.List;

public class MinIndexRotatedSortedList {
    // The problem: A sorted array of unique integers was rotated at an unknown pivot.
    // For example, [10, 20, 30, 40, 50] becomes [30, 40, 50, 10, 20]. Find the index of the minimum element in this array.
    // It's a problem where we can solve using a binary search approach. Once it's rotated we know by comparing the edges
    // if it's fit in the bottom half or the upper half of the list.
    // This algo has complexity time of O(log n) and space complexity of O(1)
    public static int findMinimumbyIndex(List<Integer> list ){
            int left = 0;
            int right = list.size()-1;
            int index = -1;

            while(left <= right){
                int mid = left + (right - left)/2;

                if(list.get(right) >= list.get(mid)){
                    index = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return index;
    }


}

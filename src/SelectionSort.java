import contract.Sort;

import java.util.List;

public class SelectionSort implements Sort {
    // It's not a stable algorithm with O(n²) time complexity.
    public List<Integer> sort(List<Integer> unsortedList){
        int n = unsortedList.size();
        for (int i = 0; i < n; i++) {
            int minIndex = i; // Considering the first index as min value to order and then move on.
            for (int j = i; j < n; j++) {
                if (unsortedList.get(j) < unsortedList.get(minIndex)) {
                    minIndex = j; // After started iterate throughout list, start to find the next min value to save.
                }
            }
            //...So here make the swap, inside the first loop, changing the values from the different indexes.
            int temp = unsortedList.get(i);
            unsortedList.set(i, unsortedList.get(minIndex));
            unsortedList.set(minIndex, temp);
        }
        return unsortedList;

    }

}

package Sort;

import contract.Sort;

import java.util.List;

public class BubbleSort implements Sort {
    // The time complexity is O(n²) and it's a stable algorithm, also it's an in place since we do not need additional
    // data structure.
    public List<Integer> sort(List<Integer> unsortedList){
        int listSize = unsortedList.size();
        for(int i = listSize -1; i >= 0; i--){ // 1) Moving from the end....
            boolean condition = false;
            for (int j = 0; j < i; j++){ // 2) ...To the beginning of list, so we are going to move the greater element to the end
                // this swap make the largest element "float" to the "top" during each pass like a "bubble", so the largest element will be
                // at the very last positing in the list, so we can secure move backwards in the list
                // because we know the last element is already in the last index. That's way the Bubble sort name.
                if(unsortedList.get(j) > unsortedList.get(j+1)){
                    int temp = unsortedList.get(j);
                    unsortedList.set(j, unsortedList.get(j+1));
                    unsortedList.set(j+1, temp);
                    condition = true;
                }
            }
            // With the conditional boolean flag we can guarantee there is no more swap to make, assign it to false and return the sorted list.
            if(!condition) return unsortedList;

        }
        return unsortedList;
    }
}

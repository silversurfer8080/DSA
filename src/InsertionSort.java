import contract.Sort;

import java.util.List;

public class InsertionSort implements Sort {
    //stable algorithm with O(N²) time complexity
    public List<Integer> sort(List<Integer> unsortedList){
        for(int i = 0; i < unsortedList.size(); i++) {
            int current = i;
            // Here, we are stand on the current index of our loop, and we start to compare with the previous one and
            // swap it. Because the while loop we keep in the loop while the condition (from the current index to 0 index
            // the list it isn't sorted yet.
            while (current > 0 && unsortedList.get(current) < unsortedList.get(current - 1)) {
                int temp = unsortedList.get(current);
                unsortedList.set(current, unsortedList.get(current - 1));
                unsortedList.set(current - 1, temp);
                current--; // here make the point move backwards to compare the previous consecutive index until the beginning of list.
            }
        }
        return unsortedList;
    }
}

import java.util.List;

public class InsertionSort implements Sort {
    //stable algorithm with O(N²) time complexity
    public List<Integer> sort(List<Integer> unsortedList){
        for(int i = 0; i < unsortedList.size(); i++) {
            int current = i;
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

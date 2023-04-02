import java.util.ArrayList;
import java.util.List;

public class MergeSort implements Sort {
    // Divide to conquer. Time complexity O(nlog(n)).
    // Decide to divide the methods in two to make it more clear.
    public List<Integer> sort (List<Integer> unsortedList){
        int listLength =  unsortedList.size();

        //edge case
        if(listLength <2) return unsortedList;

        //start to split, divide to conquer, each one of the half will be populated and use in a recursive call to this method.
        int midIndex = listLength / 2;
        List<Integer> leftHalf = new ArrayList<>(midIndex);
        List<Integer> rightHalf = new ArrayList<>(listLength - midIndex);

        // Populate each sides we split.
        for (int i = 0; i < midIndex; i++) {
            leftHalf.add(unsortedList.get(i));
        }
        for (int i = midIndex; i < listLength; i++) {
            rightHalf.add(unsortedList.get(i));
        }
        // And now making the recursive call.
        sort(leftHalf);
        sort(rightHalf);

        // Then, after divide it's time to conquer, merging the list pairs and put in order.
        return merge(unsortedList, leftHalf, rightHalf);

    }

    private static List<Integer> merge(List<Integer> list, List<Integer> leftList, List<Integer> rightList){
        int leftSize = leftList.size();
        int rightSize = rightList.size();
        // Here we use three indexes to keep the track, one for the right, one for the left and one to the merged list
        int i =0, j =0, k = 0;
        // When compared, the already ordered list became easy to check which element we put in the merged list first,
        // since the two list began merged is already sorted, so the first element in both lists are already the small one
        //of the lists
        while(i < leftSize && j < rightSize){
            if (leftList.get(i) <= rightList.get(j)){
                list.set(k, leftList.get(i));
                i++;
            } else {
                list.set(k, rightList.get(j));
                j++;
            }
            k++;
        }

        //This two while iterations here is for the case in one of the two list already run out of elements 'cause they
        //were smaller than the elements of remaining list, so we just need to add elements of one list
        while( i < leftSize){
            list.set(k, leftList.get(i));
            i++;
            k++;
        }

        while( j < rightSize){
            list.set(k, rightList.get(j));
            j++;
            k++;
        }

        return list;
    }

}

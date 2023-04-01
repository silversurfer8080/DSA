import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> unorderedList = Arrays.asList(22,4,5,1,2,7,8,9,3);

        System.out.println(InsertionSort.sort(unorderedList));
        System.out.println(SelectionSort.sort(unorderedList));
        System.out.println(BubbleSort.sort(unorderedList));



    }
}
import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class Main {

      private static String dsaAndTime(Sort sortType, List<Integer> unsortedList){
          Instant start = Instant.now();
          List<Integer> orderedList = sortType.sort(unsortedList);
          Instant end = Instant.now();
          Duration timeElapsed = Duration.between(start, end);
          return " result: " + orderedList + "\n Time taken in Milliseconds for 10k integers array: " +timeElapsed.toMillis();
      }

      public static void main(String[] args) {

        List<Integer> unorderedList = new ArrayList<>();

        Random rd = new Random();

        for(int i = 0; i < 20; i++){ // Most of the cases can run up to 100_000_000.
            unorderedList.add(rd.nextInt(15)); // ...also for the random numbers to put on the list
        }

        System.out.println(unorderedList);

        System.out.println(dsaAndTime(new InsertionSort(), unorderedList));
        System.out.println(dsaAndTime(new SelectionSort(),unorderedList));

        System.out.println(dsaAndTime(new BubbleSort(), unorderedList));
        System.out.println(dsaAndTime(new MergeSort(), unorderedList));

        System.out.println(dsaAndTime(new QuickSort(), unorderedList));
    }
}
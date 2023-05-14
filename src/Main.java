import Exercices.BinarySearch.NewspaperProblem;
import Exercices.BinarySearch.PeakOfTheMontain;

import java.util.*;

public class Main {

      public static void main(String[] args) {
//        List<Integer> orderedList = Arrays.asList(1,3,4,6,8,9,11,12,13);
//        int targetInList = 9;// index 5
//        int targetNotInList = 10; //return -1;
//        List<Integer> unorderedList = new ArrayList<>();

//        Random rd = new Random();
//
//        for(int i = 0; i < 2_000_000; i++){ // Most of the cases can run up to 100_000_000.
//            unorderedList.add(rd.nextInt(15_000)); // ...also for the random numbers to put on the list
//        }

//        System.out.println(unorderedList);
////
//        System.out.println(dsaAndTime(new InsertionSort(), unorderedList));
//        System.out.println(dsaAndTime(new SelectionSort(),unorderedList));
//
//        System.out.println(dsaAndTime(new BubbleSort(), unorderedList));
//        System.out.println(dsaAndTime(new MergeSort(), unorderedList));

//        System.out.println(dsaAndTime(new QuickSort(), unorderedList));
//        System.out.println(new BinarySearch().search(orderedList, targetInList));

//          System.out.println(new RecursiveBinarySearch().search(orderedList, targetInList));
//          System.out.println(new RecursiveBinarySearch().search(orderedList, targetNotInList));

//          List<Boolean> list = Arrays.asList(false,false,true);
//          System.out.println(RecursiveBinarySearchForBooleanTarget.search(list));

//          List<Integer> list = Arrays.asList(1,3,5,5,6,8,10,11);
//          System.out.println(new FindNotSmaller().search(list, 9));

//          System.out.println(new FindFirstOccurrence().search(orderedList, targetInList));
//          System.out.println(new SquareRoot().find(8));


          List<Integer> montainList = Arrays.asList(1,3,5,5,6,4,3,2);
          System.out.println(new PeakOfTheMontain().peakOfMountainArray(montainList));

          List<Integer> newspapers = Arrays.asList(7,2,5,10,8);
          System.out.println(new NewspaperProblem().newspapersSplit(newspapers, 2)); //18


    }
}
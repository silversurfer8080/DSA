package playground;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumbersPlayground {

    public static int largestNumber(int[] nums){
        int maxResult = nums[0];
        for (int i = 1; i < nums.length; i++){
            if(maxResult < nums[i]){
                maxResult = nums[i];
            }
        }
        return maxResult;
    }

    public static boolean primeNumber(int num){
        boolean isPrime = true;
        for(int i = 2; i<= Math.sqrt(num); i++){
            if(num % i == 0){
                isPrime = false;
            }
        }
        return isPrime;
    }

    public static int[] removeDuplicates(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }
        return set.stream().mapToInt(Number::intValue).toArray();
    }

    public static int secondLargestNumber(int[] nums){
        int firstMax =  Integer.MIN_VALUE;
        int secondMax =  Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++){
            if(nums[i] > firstMax){
                secondMax = firstMax;
                firstMax = nums[i];
            } else if(nums[i] > secondMax && nums[i] < firstMax){
                secondMax = nums[i];
            }
        }
        return secondMax;
    }

    public static int secondLargestNumber2(int[] nums){
        int result = -1;
        if(nums.length <2) return result;
        Arrays.sort(nums);
        for(int i = nums.length -1; i >= 0; i--){
            if(nums[i] != nums[nums.length-1]) result = nums[i];
        }
        return result;
    }
    public static int secondLargestNumber3(int[] nums){
        List<Integer> list = Arrays.stream(nums).sorted().boxed().toList();
        for (int i = list.size() - 1; i >= 0; i--) {
            if(list.get(i-1) != list.get(list.size()-1)) return list.get(i-1);
        }
        return -1;
    }






}

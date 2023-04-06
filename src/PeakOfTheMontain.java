import java.util.List;

public class PeakOfTheMontain {
    public static int peakOfMountainArray(List<Integer> arr) {
        int low = 0;
        int high = arr.size()-1;
        int peak = arr.get(high/2);

        while(low <= high){
            int mid = low + (high - low)/2;

            if(arr.get(mid) >= arr.get(mid+1)){
                high = mid -1;
                peak = mid;
            } else {
                low = mid +1;
            }
        }
        return peak;
    }

}

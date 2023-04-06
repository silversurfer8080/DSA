import contract.Search;

import java.util.List;

public class FindFirstOccurrence implements Search {
    // This is similar problem as the Find equal or not smaller problem in the class "FindNotSmaller", except we are looking
    // for exact target match and not the match or bigger

    // The time complexity is O(log n) and space complexity O(1).
    @Override
    public int search(List<Integer> list, int target) {
        int left = 0;
        int right = list.size()-1;
        int boundaryIndex = -1;

        while(left <= right){
            int midPoint = left  + (right -left)/2;

            if(list.get(midPoint) >= target){
                if(list.get(midPoint) == target){
                    boundaryIndex = midPoint;
                }
                right =  midPoint - 1;
            } else {
                left = midPoint + 1;
            }

        }
        return boundaryIndex;
    }
}

import java.util.Collections;
import java.util.List;

/**
 * You've begun your new job to organize newspapers. Each morning, you are to separate the newspapers into smaller piles and assign each pile to a co-worker. This way, your co-workers can read through the newspapers and examine its contents simultenously.
 *
 * Each newspaper is marked with a read time to finish all its contents. A worker can read one newspaper at a time, and when they finish a newspaper, they can start reading the next newspaper. Your goal is to minimize the amount of time needed for your co-workers to finish all newspapers. Additionally, the newspapers came in a particular order, and you must not disarrange the original ordering when distributing the newspapers. In other words, you cannot pick and choose newspapers randomly from the whole pile to assign to a co-worker, but rather you must take a subsection of consecutive newspapers from the whole pile.
 *
 * What is the minimum amount of time it would take to have your coworkers go through all the newspapers? That is, if you optimize the distribution of newspapers, what is the longest read time among all piles?
 *
 * Constraints
 * 1 <= newspapers_read_times.length <= 10^5
 *
 * 1 <= newspapers_read_times[i] <= 10^5
 *
 * 1 <= num_coworkers <= 10^5
 *
 * Examples
 * Example 1:
 * Input: newspapers_read_times = [7,2,5,10,8], num_coworkers = 2
 * Output: 18
 * Explanation:
 * Assign first 3 newspapers to one coworker then assign the rest to another. The time it takes for the first 3 newspapers is 7 + 2 + 5 = 14 and for the last 2 is 10 + 8 = 18.
 */
// This problem has O(n log n) solution present here.
public class NewspaperProblem {
    public static int newspapersSplit(List<Integer> newspapersReadTimes, int numCoworkers) {
        int low = Collections.max(newspapersReadTimes);
        int high = 0;
        int ans = -1;
        for (int readTime : newspapersReadTimes)
            high += readTime;
        while (low <= high) {
            int mid = (low + high) / 2;
            // helper function to check if a time works
            if (feasible(newspapersReadTimes, numCoworkers, mid)) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static boolean feasible(List<Integer> newspapersReadTimes, int numCoworkers, int limit) {
        // time to keep track of the current worker's time spent, num_workers to keep track of the number of coworkers used
        int time = 0, numWorkers = 0;
        for (int readTime: newspapersReadTimes) {
            // check if current time exceeds the given time limit
            if (time + readTime > limit) {
                time = 0;
                numWorkers++;
            }
            time += readTime;
        }
        // edge case to check if we needed an extra coworker at the end
        if (time != 0) {
            numWorkers++;
        }
        // check if the number of workers we need is more than what we have
        return numWorkers <= numCoworkers;
    }

}

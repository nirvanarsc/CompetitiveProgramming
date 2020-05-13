package weekly_contests.weekly_14;

import java.util.Comparator;
import java.util.TreeSet;

public class P_480 {

    public double[] medianSlidingWindow(int[] nums, int k) {
        final Comparator<Integer> comparator = (a, b) -> nums[a] == nums[b] ? Integer.compare(a, b)
                                                                            : Integer.compare(nums[a], nums[b]);
        final TreeSet<Integer> max = new TreeSet<>(comparator);
        final TreeSet<Integer> min = new TreeSet<>(comparator);
        final double[] res = new double[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            max.add(i);
        }
        balance(max, min);
        res[0] = getMedian(nums, k, min, max);
        for (int i = k; i < nums.length; i++) {
            if (!max.remove(i - k)) {
                min.remove(i - k);
            }
            min.add(i);
            max.add(min.pollFirst());
            balance(max, min);
            res[i - k + 1] = getMedian(nums, k, min, max);
        }
        return res;
    }

    private static void balance(TreeSet<Integer> max, TreeSet<Integer> min) {
        if (max.size() > min.size()) {
            while (max.size() > min.size()) {
                min.add(max.pollLast());
            }
        }
    }

    private static double getMedian(int[] nums, int k, TreeSet<Integer> min, TreeSet<Integer> max) {
        return (k % 2 == 0) ? 0.5 * nums[max.last()] + 0.5 * nums[min.first()]
                            : 1.0 * nums[min.first()];
    }
}

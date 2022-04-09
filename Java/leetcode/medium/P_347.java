package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

public class P_347 {

    // Priority Queue
    public int[] topKFrequent(int[] nums, int k) {
        final Map<Integer, Integer> frequencyMap = new HashMap<>();
        final PriorityQueue<Map.Entry<Integer, Integer>> min =
                new PriorityQueue<>(k, Map.Entry.comparingByValue());
        for (int num : nums) {
            frequencyMap.merge(num, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            min.add(entry);
            if (min.size() > k) {
                min.remove();
            }
        }
        return min.stream().mapToInt(Map.Entry::getKey).toArray();
    }

    // Quick Select
    public int[] topKFrequentQuickSelect(int[] nums, int k) {
        final Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.merge(num, 1, Integer::sum);
        }
        final List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(frequencyMap.entrySet());

        findKthLargestIndex(k, entries, Map.Entry.comparingByValue());

        final int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = entries.get(i).getKey();
        }

        return res;
    }

    // Bucket Sort
    public int[] topKFrequentBS(int[] nums, int k) {
        final Map<Integer, List<Integer>> buckets = new HashMap<>();
        final Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.merge(num, 1, Integer::sum);
        }

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            buckets.computeIfAbsent(entry.getValue(), v -> new ArrayList<>()).add(entry.getKey());
        }

        final int[] res = new int[k];

        for (int pos = nums.length, i = 0; pos >= 0 && i < k; pos--) {
            for (int num : buckets.getOrDefault(pos, Collections.emptyList())) {
                res[i++] = num;
            }
        }
        return res;
    }

    public static <T> int findKthLargestIndex(int k, List<T> integers, Comparator<T> comparator) {
        final Random random = new Random(0);
        int low = 0, high = integers.size() - 1;
        while (low <= high) {
            final int pivotIdx = random.nextInt(high - low + 1) + low;
            final int newIdx = partition(pivotIdx, integers, low, high, comparator);
            if (newIdx < k - 1) {
                low = newIdx + 1;
            } else if (newIdx == k - 1) {
                return newIdx;
            } else {
                high = newIdx - 1;
            }
        }

        return low;
    }

    public static <T> int partition(int pivotIdx, List<T> a, int begin, int end, Comparator<T> comparator) {
        final T pivot = a.get(pivotIdx);
        Collections.swap(a, pivotIdx, end);
        int index = begin;
        for (int i = begin; i < end; i++) {
            if (comparator.compare(a.get(i), pivot) > 0) {
                Collections.swap(a, index, i);
                index++;
            }
        }
        Collections.swap(a, end, index);
        return index;
    }
}

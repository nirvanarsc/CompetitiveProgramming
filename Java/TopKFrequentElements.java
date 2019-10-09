import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.stream.Collectors;

public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        final Map<Integer, Integer> frequencyMap = new HashMap<>();
        final PriorityQueue<Entry<Integer, Integer>> min =
                new PriorityQueue<>(k, Comparator.comparing(Entry::getValue));

        for (int i : nums) {
            frequencyMap.merge(i, 1, Integer::sum);
        }

        final Iterator<Entry<Integer, Integer>> iterator = frequencyMap.entrySet().iterator();
        for (int i = 0; i < k; i++) {
            min.add(iterator.next());
        }

        while (iterator.hasNext()) {
            final Entry<Integer, Integer> curr = iterator.next();
            if (!min.isEmpty() && min.peek().getValue() < curr.getValue()) {
                min.poll();
                min.add(curr);
            }
        }

        return min.stream().map(Entry::getKey).collect(Collectors.toList());
    }

    public List<Integer> topKFrequent2(int[] nums, int k) {
        final Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (Integer i : nums) {
            frequencyMap.merge(i, 1, Integer::sum);
        }
        final List<Entry<Integer, Integer>> entries = new ArrayList<>(frequencyMap.entrySet());

        final int newIdx = findKthLargestIndex(k, entries, Comparator.comparing(Entry::getValue));

        return entries.subList(0, newIdx + 1).stream().map(Entry::getKey).collect(Collectors.toList());
    }

    public List<Integer> topKFrequent3(int[] nums, int k) {
        final List<Integer>[] bucket = new List[nums.length + 1];
        final Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int n : nums) {
            frequencyMap.merge(n, 1, Integer::sum);
        }

        for (Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            final int frequency = entry.getValue();
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(entry.getKey());
        }

        final List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }

    public static <T> int findKthLargestIndex(int k, List<T> integers, Comparator<T> comparator) {
        final Random random = new Random(0);
        int low = 0, high = integers.size() - 1;
        while (low <= high) {
            final int pivotIdx = random.nextInt(high - low + 1) + low;
            final int newIdx = dutchFlagPartitionIndex(pivotIdx, integers, low, high, comparator);
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

    public static <T> int dutchFlagPartitionIndex(int pivotIdx, List<T> a, int begin, int end,
                                                  Comparator<T> comparator) {
        final T pivot = a.get(pivotIdx);
        int mid = begin;
        while (mid <= end) {
            if (comparator.compare(a.get(mid), pivot) > 0) {
                Collections.swap(a, begin++, mid++);
            } else if (a.get(mid) == pivot) {
                mid++;
            } else {
                Collections.swap(a, mid, end--);
            }
        }

        return mid - 1;
    }
}

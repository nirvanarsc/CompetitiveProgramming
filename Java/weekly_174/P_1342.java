package weekly_174;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class P_1342 {

    public int minSetSizePQ(int[] arr) {
        int count = 0, res = 0;
        final PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));
        final Map<Integer, Integer> freq = new HashMap<>();
        for (int value : arr) {
            freq.merge(value, 1, Integer::sum);
        }
        pq.addAll(freq.entrySet());
        do {
            count += pq.remove().getValue();
            res++;
        } while (count < arr.length / 2);
        return res;
    }

    public int minSetSizeBucketSort(int[] arr) {
        int steps = 0, res = 0;
        final Map<Integer, Integer> freq = new HashMap<>();
        final List<Integer>[] list = new ArrayList[arr.length + 1];
        for (int num : arr) {
            freq.merge(num, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            final int count = entry.getValue();
            if (list[count] == null) {
                list[count] = new ArrayList<>();
            }
            list[count].add(entry.getKey());
        }
        for (int i = arr.length; i > 0; i--) {
            final List<Integer> cur = list[i];
            if (cur != null) {
                for (int ignored : cur) {
                    steps += i;
                    res++;
                    if (steps >= arr.length / 2) {
                        return res;
                    }
                }
            }
        }
        return arr.length;
    }

    public int minSetSizeLHM(int[] arr) {
        int res = 0, target = arr.length / 2;
        final Map<Integer, Integer> freq = new HashMap<>();
        for (int value : arr) {
            freq.merge(value, 1, Integer::sum);
        }
        final Map<Integer, Integer> sortedByValue = freq
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                          LinkedHashMap::new));
        for (Map.Entry<Integer, Integer> e : sortedByValue.entrySet()) {
            if (target <= 0) {
                return res;
            }
            target -= e.getValue();
            res++;
        }
        return res;
    }
}
